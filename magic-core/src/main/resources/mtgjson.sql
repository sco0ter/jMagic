CREATE TABLE "Set"
(
    id                 INTEGER PRIMARY KEY AUTO_INCREMENT,
    base_set_size      INTEGER,
    block              TEXT,
    booster            LONGTEXT,
    code               VARCHAR(8) UNIQUE NOT NULL,
    is_foil_only       BOOLEAN           NOT NULL DEFAULT FALSE,
    is_foreign_only    BOOLEAN           NOT NULL DEFAULT FALSE,
    is_non_foil_only   BOOLEAN           NOT NULL DEFAULT FALSE,
    is_online_only     BOOLEAN           NOT NULL DEFAULT FALSE,
    is_partial_preview BOOLEAN           NOT NULL DEFAULT FALSE,
    keyrune_code       TEXT,
    mcm_id             INTEGER,
    mcm_id_extras      INTEGER,
    mcm_name           TEXT,
    mtgo_code          TEXT,
    name               TEXT,
    parent_code        TEXT,
    release_date       DATE,
    sealed_product     TEXT,
    tcgplayer_group_id INTEGER,
    total_set_size     INTEGER,
    type               ENUM ('core', 'masters', 'expansion', 'memorabilia', 'commander', 'starter', 'archenemy', 'box', 'draft_innovation', 'from_the_vault', 'funny', 'duel_deck', 'masterpiece', 'promo', 'premium_deck', 'planechase', 'token', 'vanguard', 'treasure_chest', 'spellbook')
);

CREATE TABLE "Card"
(
    id                          INTEGER PRIMARY KEY AUTO_INCREMENT,
    artist                      TEXT,
    ascii_name                  TEXT,
    border_color                ENUM ('black', 'white', 'borderless', 'silver', 'gold'),
    color_indicator             TEXT,
    converted_mana_cost         FLOAT,
    duel_deck                   TEXT,
    edhrec_rank                 INTEGER,
    face_converted_mana_cost    FLOAT,
    face_mana_value             FLOAT,
    face_name                   TEXT,
    finishes                    TEXT,
    flavor_name                 TEXT,
    flavor_text                 TEXT,
    frame_effects               TEXT,
    frame_version               ENUM ('2003', '1993', '2015', '1997', 'future'),
    hand                        TEXT,
    has_alternative_deck_limit  BOOLEAN         NOT NULL DEFAULT 0,
    has_content_warning         BOOLEAN         NOT NULL DEFAULT 0,
    has_foil                    BOOLEAN         NOT NULL DEFAULT 0,
    has_non_foil                BOOLEAN         NOT NULL DEFAULT 0,
    is_alternative              BOOLEAN         NOT NULL DEFAULT 0,
    is_full_art                 BOOLEAN         NOT NULL DEFAULT 0,
    is_online_only              BOOLEAN         NOT NULL DEFAULT 0,
    is_oversized                BOOLEAN         NOT NULL DEFAULT 0,
    is_promo                    BOOLEAN         NOT NULL DEFAULT 0,
    is_reprint                  BOOLEAN         NOT NULL DEFAULT 0,
    is_reserved                 BOOLEAN         NOT NULL DEFAULT 0,
    is_starter                  BOOLEAN         NOT NULL DEFAULT 0,
    is_story_spotlight          BOOLEAN         NOT NULL DEFAULT 0,
    is_textless                 BOOLEAN         NOT NULL DEFAULT 0,
    is_timeshifted              BOOLEAN         NOT NULL DEFAULT 0,
    keywords                    TEXT,
    layout                      ENUM ('normal', 'adventure', 'class', 'aftermath', 'split', 'flip', 'leveler', 'saga', 'transform', 'vanguard', 'meld', 'modal_dfc', 'scheme', 'planar', 'host', 'augment'),
    leadership_skills           TEXT,
    life                        TEXT,
    loyalty                     TEXT,
    mana_cCost                  TEXT,
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
    original_release_date       TEXT,
    original_text               TEXT,
    original_type               TEXT,
    other_face_ids              TEXT,
    power                       TEXT,
    printings                   TEXT,
    promo_types                 TEXT,
    purchase_urls               TEXT,
    rarity                      ENUM ('uncommon', 'common', 'rare', 'mythic', 'special', 'bonus'),
    scryfall_id                 TEXT,
    scryfall_illustration_id    TEXT,
    scryfall_oracle_id          TEXT,
    set_code                    TEXT,
    side                        TEXT,
    subtypes                    TEXT,
    supertypes                  TEXT,
    tcgplayer_etched_product_id TEXT,
    tcgplayer_product_id        TEXT,
    text                        TEXT,
    toughness                   TEXT,
    type                        TEXT,
    types                       TEXT,
    uuid                        CHAR(36) NOT NULL,
    variations                  TEXT,
    watermark                   TEXT
);

CREATE TABLE "Token_Card"
(
    id              INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id         INTEGER,
    reverse_related TEXT
);

CREATE TABLE "Card_Availability"
(
    id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id      INTEGER REFERENCES "Card",
    availability ENUM ('arena', 'dreamcast', 'mtgo', 'paper', 'shandalar'),
    CONSTRAINT FK_Card_Card_Availability FOREIGN KEY (card_id) REFERENCES "Card" (id)
);

CREATE TABLE "Card_Frame_Effect"
(
    id           INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id      INTEGER REFERENCES "Card",
    frame_effect ENUM ('colorshifted', 'companion', 'compasslanddfc', 'devoid', 'draft', 'etched', 'extendedart',
        'fullart', 'inverted', 'legendary', 'miracle', 'mooneldrazidfc', 'nyxborn', 'nyxtouched', 'originpwdfc',
        'showcase', 'snow', 'sunmoondfc', 'tombstone', 'waxingandwaningmoondfc'),
    CONSTRAINT FK_Card_Card_Frame_Effect FOREIGN KEY (card_id) REFERENCES "Card" (id)
);

CREATE TABLE "Card_Color"
(
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id INTEGER REFERENCES "Card",
    color   ENUM ('WHITE', 'BLUE', 'BLACK', 'RED', 'GREEN'),
    CONSTRAINT FK_Card_Card_Color FOREIGN KEY (card_id) REFERENCES "Card" (id)
);

CREATE TABLE "Card_Color_Identity"
(
    id      INTEGER PRIMARY KEY AUTO_INCREMENT,
    card_id INTEGER REFERENCES "Card",
    color   ENUM ('WHITE', 'BLUE', 'BLACK', 'RED', 'GREEN'),
    CONSTRAINT FK_Card_Card_Color_Identity FOREIGN KEY (card_id) REFERENCES "Card" (id)
);