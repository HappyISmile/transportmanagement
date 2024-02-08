-- begin TRANSPORTMANAGEMENT_PLANIN
create table TRANSPORTMANAGEMENT_PLANIN (
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
    ORDER_NUMBER varchar(50),
    ARRIVAL_DATE timestamp,
    NUMBER_TC varchar(20),
    LIFTING_CAPACITY integer,
    FIO varchar(100),
    PHONE varchar(20),
    STATUS integer,
    CONDITION integer,
    GATES varchar(5),
    REGISTRATION_DATE timestamp,
    GATE_SETTING_DATE timestamp,
    DEPARTURE_ALLOWED_DATE timestamp,
    DEPARTURE_DATE timestamp,
    --
    primary key (ID)
)^
-- end TRANSPORTMANAGEMENT_PLANIN
