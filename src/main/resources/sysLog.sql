CREATE TABLE sysLog(
id VARCHAR2(32) default SYS_GUID() PRIMARY KEY,
visitTime timestamp,
username VARCHAR2(50),
ip VARCHAR2(30),
url VARCHAR2(50),
executionTime int,
method VARCHAR2(200) );

select * from sysLog;
