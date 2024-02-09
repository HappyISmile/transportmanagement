create table TRANSPORTMANAGEMENT_CLIENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CODE_CLIENT integer,
    NAME varchar(200),
    ADDRESS varchar(200),
    PERSON varchar(100),
    --
    primary key (ID)
);