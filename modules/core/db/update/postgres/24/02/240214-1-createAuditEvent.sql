create table TRANSPORTMANAGEMENT_AUDIT_EVENT (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    REGISTRATION_NUMBER varchar(10),
    NUMBER_TC varchar(20),
    STATUS integer,
    CONDITION integer,
    CREATE_DATE timestamp,
    --
    primary key (ID)
);