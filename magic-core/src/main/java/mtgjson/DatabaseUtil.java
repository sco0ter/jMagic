package mtgjson;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.core.H2Database;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.exception.DataAccessException;
import org.jooq.generated.Tables;
import org.jooq.generated.tables.records.CardAvailabilityRecord;
import org.jooq.generated.tables.records.CardRecord;
import org.jooq.generated.tables.records.SetRecord;
import org.jooq.impl.DSL;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public final class DatabaseUtil {

    private final DataSource dataSource;

    public DatabaseUtil(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void init() throws SQLException, LiquibaseException {

        try (Connection connection = dataSource.getConnection()) {

            Database database = new H2Database();
            database.setConnection(new JdbcConnection(connection));
            Liquibase liquibase =
                    new liquibase.Liquibase("databaseChangelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update(new Contexts(), new LabelExpression());
        }
    }

    public void insert(Set set) throws SQLException {
        try (Connection connection = dataSource.getConnection()) {
            DSLContext context = DSL.using(connection, SQLDialect.DEFAULT);
            SetRecord setRecord = context.newRecord(Tables.SET, set);
            context.insertInto(Tables.SET).set(setRecord).execute();

            for (Card card : set.getCards()) {
                CardRecord cardRecord = context.newRecord(Tables.CARD, card);
                cardRecord.store();
                for (Availability availability : card.getAvailabilities()){
                    CardAvailabilityRecord cardAvailabilityRecord = new CardAvailabilityRecord(null, cardRecord.getId(), availability);
                    cardAvailabilityRecord.store();
                }
            }
        }
    }
}
