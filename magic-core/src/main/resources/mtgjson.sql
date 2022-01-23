CREATE TABLE Set
(
    id                 INTEGER PRIMARY KEY AUTO_INCREMENT,
    base_set_size      INTEGER,
    block              TEXT,
    booster            LONGTEXT,
    code               VARCHAR(8) UNIQUE NOT NULL,
    code_v3            VARCHAR(8) UNIQUE,
    is_foil_only       BOOLEAN           NOT NULL DEFAULT FALSE,
    is_foreign_only    BOOLEAN           NOT NULL DEFAULT FALSE,
    is_non_foil_only   BOOLEAN           NOT NULL DEFAULT FALSE,
    is_online_only     BOOLEAN           NOT NULL DEFAULT FALSE,
    is_paper_only      BOOLEAN           NOT NULL DEFAULT FALSE,
    is_partial_preview BOOLEAN           NOT NULL DEFAULT FALSE,
    keyrune_code       TEXT,
    mcm_id             INTEGER,
    mcm_id_extras      INTEGER,
    mcm_name           TEXT,
    mtgo_code          TEXT,
    name               TEXT,
    parent_code        TEXT,
    release_date       DATE,
    tcgplayer_group_id INTEGER,
    total_set_size     INTEGER,
    type               ENUM ('core', 'masters', 'expansion', 'memorabilia', 'commander', 'starter', 'archenemy', 'box', 'draft_innovation', 'from_the_vault', 'funny', 'duel_deck', 'masterpiece', 'promo', 'premium_deck', 'planechase', 'token', 'vanguard', 'treasure_chest', 'spellbook')
);

CREATE TABLE Card
(
    id                          INTEGER PRIMARY KEY AUTO_INCREMENT,
    artist                      TEXT,
    ascii_name                  TEXT,
    border_color                ENUM ('BLACK', 'WHITE', 'BORDERLESS', 'SILVER', 'GOLD'),
    edhrec_rank                 INTEGER,
    face_mana_value             FLOAT,
    face_name                   TEXT,
    finishes                    TEXT,
    flavor_text                 TEXT,
    frame_version               ENUM ('_2003', '_1993', '_2015', '_1997', 'FUTURE'),
    has_foil                    BOOLEAN  NOT NULL DEFAULT 0,
    has_non_foil                BOOLEAN  NOT NULL DEFAULT 0,
    is_full_art                 BOOLEAN  NOT NULL DEFAULT 0,
    is_online_only              BOOLEAN  NOT NULL DEFAULT 0,
    is_promo                    BOOLEAN  NOT NULL DEFAULT 0,
    is_reprint                  BOOLEAN  NOT NULL DEFAULT 0,
    --keywords                    TEXT,
    layout                      ENUM ('NORMAL', 'ADVENTURE', 'CLASS', 'AFTERMATH', 'SPLIT', 'FLIP', 'LEVELER', 'SAGA', 'TRANSFORM', 'VANGUARD', 'MELD', 'MODAL_DFC', 'SCHEME', 'PLANAR', 'HOST', 'AUGMENT'),
    leadership_skills           TEXT,
    loyalty                     TEXT,
    mana_value                  FLOAT,
    mcm_id                      TEXT,
    mcm_meta_id                 TEXT,
    mtg_arena_id                TEXT,
    mtgjson_v4_id               TEXT,
    mtgo_foil_id                TEXT,
    mtgo_id                     TEXT,
    multiverse_id               TEXT,
    name                        TEXT,
    number                      TEXT,
    power                       TEXT,
    --promo_types                 TEXT,
    --purchase_urls               TEXT,
    scryfall_id                 TEXT,
    scryfall_illustration_id    TEXT,
    scryfall_oracle_id          TEXT,
    set_code                    TEXT,
    side                        TEXT,
    --subtypes                    TEXT,
    --supertypes                  TEXT,
    tcgplayer_etched_product_id TEXT,
    tcgplayer_product_id        TEXT,
    text                        TEXT,
    toughness                   TEXT,
    type                        TEXT,
    --types                       TEXT,
    uuid                        CHAR(36) NOT NULL,
    watermark                   TEXT
);

CREATE TABLE Set_Card
(
    card_id                    INTEGER PRIMARY KEY,
    converted_mana_cost        FLOAT,
    face_converted_mana_cost   FLOAT,
    flavor_name                TEXT,
    hand                       TEXT,
    has_alternative_deck_limit BOOLEAN NOT NULL DEFAULT 0,
    has_content_warning        BOOLEAN NOT NULL DEFAULT 0,
    is_alternative             BOOLEAN NOT NULL DEFAULT 0,
    is_oversized               BOOLEAN NOT NULL DEFAULT 0,
    is_reserved                BOOLEAN NOT NULL DEFAULT 0,
    is_starter                 BOOLEAN NOT NULL DEFAULT 0,
    is_story_spotlight         BOOLEAN NOT NULL DEFAULT 0,
    is_textless                BOOLEAN NOT NULL DEFAULT 0,
    is_timeshifted             BOOLEAN NOT NULL DEFAULT 0,
    life                       TEXT,
    mana_cost                  TEXT,
    original_release_date      TEXT,
    original_text              TEXT,
    original_type              TEXT,
    rarity                     ENUM ('uncommon', 'common', 'rare', 'mythic', 'special', 'bonus'),
    --other_face_ids             TEXT,
    --printings                  TEXT,
    --variations                 TEXT,
    CONSTRAINT FK_Card_Set_Card FOREIGN KEY (card_id) REFERENCES Card (id)
);

CREATE TABLE Token_Card
(
    card_id         INTEGER PRIMARY KEY,
    CONSTRAINT FK_Card_Token_Card FOREIGN KEY (card_id) REFERENCES Card (id)
);

CREATE TABLE Token_Card_Reverse_Related
(
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id         INTEGER,
    reverse_related TEXT,
    CONSTRAINT FK_Token_Card_Token_Card_Reverse_Related FOREIGN KEY (card_id) REFERENCES Token_Card (card_id)
);

CREATE TABLE Card_Availability
(
    id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id      INTEGER REFERENCES Card,
    availability ENUM ('ARENA', 'DREAMCAST', 'MTGO', 'PAPER', 'SHANDALAR'),
    CONSTRAINT FK_Card_Card_Availability FOREIGN KEY (card_id) REFERENCES Card (id)
);

CREATE TABLE Card_Frame_Effect
(
    id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id      INTEGER REFERENCES Card,
    frame_effect ENUM ('colorshifted', 'companion', 'compasslanddfc', 'devoid', 'draft', 'etched', 'extendedart',
        'fullart', 'inverted', 'legendary', 'miracle', 'mooneldrazidfc', 'nyxborn', 'nyxtouched', 'originpwdfc',
        'showcase', 'snow', 'sunmoondfc', 'tombstone', 'waxingandwaningmoondfc'),
    CONSTRAINT FK_Card_Card_Frame_Effect FOREIGN KEY (card_id) REFERENCES Card (id)
);

CREATE TABLE Card_Color
(
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id INTEGER REFERENCES Card,
    color   ENUM ('WHITE', 'BLUE', 'BLACK', 'RED', 'GREEN'),
    CONSTRAINT FK_Card_Card_Color FOREIGN KEY (card_id) REFERENCES Card (id)
);

CREATE TABLE Card_Color_Identity
(
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id INTEGER REFERENCES Card,
    color   ENUM ('WHITE', 'BLUE', 'BLACK', 'RED', 'GREEN'),
    CONSTRAINT FK_Card_Card_Color_Identity FOREIGN KEY (card_id) REFERENCES Card (id)
);

CREATE TABLE Card_Color_Indicator
(
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id INTEGER REFERENCES Card,
    color   ENUM ('WHITE', 'BLUE', 'BLACK', 'RED', 'GREEN'),
    CONSTRAINT FK_Card_Card_Color_Indicator FOREIGN KEY (card_id) REFERENCES Card (id)
);