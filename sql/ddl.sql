DROP TABLE IF EXISTS public.emp CASCADE;

CREATE TABLE emp
(
   id              bigint         NOT NULL,
   designation     varchar(255),
   first_name      varchar(255),
   gender          varchar(255),
   last_name       varchar(255),
   location        varchar(255),
   marital_status  varchar(255),
   name            varchar(255),
   pan_no          varchar(255),
   salary          integer        NOT NULL
);

ALTER TABLE emp
   ADD CONSTRAINT emp_pkey
   PRIMARY KEY (id);


INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('branch_seq','SEQUENCE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('dept_seq','SEQUENCE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('emp_seq','SEQUENCE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('employee_seq','SEQUENCE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('organisation_seq','SEQUENCE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('branch','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('branch_employees','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('dept','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('emp','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('employee','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('organisation','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('organisation_branches','TABLE',NULL,'public',NULL);
INSERT INTO target_table (NAME,TYPE,DATABASE,SCHEMA,REMARKS) VALUES ('organisation_departments','TABLE',NULL,'public',NULL);

COMMIT;
