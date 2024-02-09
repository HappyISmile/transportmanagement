create table TRANSPORTMANAGEMENT_GATE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NUMBER_GATE varchar(5),
    TIME_FROM time,
    TIME_BY time,
    --
    primary key (ID)
);