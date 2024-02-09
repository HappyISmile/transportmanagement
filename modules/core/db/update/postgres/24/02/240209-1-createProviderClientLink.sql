create table PROVIDER_CLIENT_LINK (
    CLIENT_ID uuid,
    PROVIDER_ID uuid,
    primary key (CLIENT_ID, PROVIDER_ID)
);
