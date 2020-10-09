-- begin BOOKSHOP_ARCHIVE
create table BOOKSHOP_ARCHIVE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    AUTHOR varchar(255) not null,
    FILE_ varchar(255),
    BOOKNAME varchar(255) not null,
    YEAR_ varchar(255),
    --
    primary key (ID)
)^
-- end BOOKSHOP_ARCHIVE
