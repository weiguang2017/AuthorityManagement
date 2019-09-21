-- 用户表
CREATE TABLE users(
id varchar2(32) default SYS_GUID() PRIMARY KEY,
email VARCHAR2(50) UNIQUE NOT NULL,
username VARCHAR2(50),
PASSWORD VARCHAR2(50),
phoneNum VARCHAR2(20),
STATUS INT
);

INSERT INTO users(id,email,username,password,phonenum,status) 
values('1700765','neu_ldk@163.com','ldk','123','13866666666',1);
commit;
select * from users;

-- 角色表

CREATE TABLE role(
id varchar2(32) default SYS_GUID() PRIMARY KEY,
roleName VARCHAR2(50) ,
roleDesc VARCHAR2(50)
);


insert into role (id,roleName,roledesc) values('1','USER','user');
insert into role (id,roleName,roledesc) values('2','ADMIN','admin');
commit;
select * from role;


-- 用户角色关联表
CREATE TABLE users_role(
userId varchar2(32),
roleId varchar2(32),
PRIMARY KEY(userId,roleId),
FOREIGN KEY (userId) REFERENCES users(id),
FOREIGN KEY (roleId) REFERENCES role(id)
);

insert into users_role (userId,roleId) values('1700765','1');
insert into users_role (userId,roleId) values('1700765','2');
commit;


select * from users_role;
select * from role where id in (select roleId from users_role where userId='1700765')



-- 资源权限表
CREATE TABLE permission(
id varchar2(32) default SYS_GUID() PRIMARY KEY,
permissionName VARCHAR2(50) ,
url VARCHAR2(50)
)

insert into permission (permissionName,url) values('findAllUsers','/user/findAll.do');
insert into permission (permissionName,url) values('findUserById','/user/findById.do');
insert into permission (permissionName,url) values('saveUser','/user/save.do');
commit;

select * FROM permission;



-- 角色权限关联表
CREATE TABLE role_permission(
permissionId varchar2(32),
roleId varchar2(32),
PRIMARY KEY(permissionId,roleId),
FOREIGN KEY (permissionId) REFERENCES permission(id),
FOREIGN KEY (roleId) REFERENCES role(id)
)
----------permissionId:
      --find all  0BF91605ED6F47D7901D4FEC2A30C742 
      --findByid  BED09B44836749679D5BB46E0DDC115F 
      --save   321DFECC3BE1430DB5DB5DB4C3C00C31
insert into role_permission (permissionId,roleId) values('0BF91605ED6F47D7901D4FEC2A30C742','2');
insert into role_permission (permissionId,roleId) values('BED09B44836749679D5BB46E0DDC115F','1');
insert into role_permission (permissionId,roleId) values('321DFECC3BE1430DB5DB5DB4C3C00C31','2');
commit;
select * from role_permission;



