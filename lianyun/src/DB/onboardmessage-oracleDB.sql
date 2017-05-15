-- Create table
create table ONBOARDMESSAGE
(
  id             VARCHAR2(128) not null,
  accountname    VARCHAR2(128),
  accountphone   VARCHAR2(20),
  appointtime    VARCHAR2(128),
  onboardtime    VARCHAR2(128),
  onboardaddress VARCHAR2(4000),
  appointstatus  VARCHAR2(1),
  onboardstatus  VARCHAR2(1)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    minextents 1
    maxextents unlimited
  );
-- Create/Recreate primary, unique and foreign key constraints 
alter table ONBOARDMESSAGE
  add constraint PK primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
