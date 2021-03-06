DROP DATABASE IF EXISTS `managercenter`;
CREATE DATABASE `managercenter` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

use `managercenter`;

DROP TABLE IF EXISTS MANAGER CASCADE;
CREATE TABLE `MANAGER` (
  `ID` int(11) NOT NULL auto_increment,
  `EMAIL` varchar(255) NOT NULL COMMENT '邮箱',
  `PASSWORD` varchar(255) NOT NULL default '' COMMENT '密码',
  `NICKNAME` varchar(255) NOT NULL COMMENT '姓名',
  `ENAME` varchar(255) NOT NULL COMMENT '英文名',
  `LOGO` varchar(255) default '' COMMENT 'LOGO',
  `STATUS` int(2) NOT NULL COMMENT '状态',
  `DEPARTMENT_ID` int(11) default 0 COMMENT '部门ID',
  `POSITION_ID` int(11) default 0 COMMENT '职位ID',
  `ROLE_ID` int(11) NOT NULL COMMENT '角色ID',
  `CREATOR` varchar(255) NOT NULL COMMENT '创建人',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  `LOGINTIME` datetime default '0000-00-00 00:00:00' COMMENT '最后登录时间',
  `LOGINIP` varchar(100) default '-' COMMENT '最后登录IP地址',
  PRIMARY KEY  (`id`),
  index(EMAIL)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员';

insert into MANAGER(`EMAIL`,`PASSWORD`,`NICKNAME`,`ENAME`,`LOGO`,`STATUS`,`DEPARTMENT_ID`,`POSITION_ID`,`ROLE_ID`,`CREATOR`,`CREATETIME`,`LOGINTIME`,`LOGINIP`) 
values('qiu_sen@126.com','21232f297a57a5a743894a0e4a801fc3','邱森','Nathan','',1,0,0,1,'qiu_sen@126.com','2012-08-01 08:08:08','2012-08-01 08:08:08','127.0.0.1');


DROP TABLE IF EXISTS MANAGER_INFO CASCADE;
CREATE TABLE `MANAGER_INFO` (
  `ID` int(11) NOT NULL auto_increment,
  `EMAIL` varchar(255) NOT NULL COMMENT '邮箱',
  `TEL`  varchar(255) NOT NULL COMMENT '座机',
  `MOBILE` varchar(255) NOT NULL COMMENT '手机',
  `SEX` int(2) NOT NULL COMMENT '性别：0、保密；1、男；2、女',
  `ADDRESS` varchar(255) NOT NULL COMMENT '联系地址',
  `QQ` varchar(255) NOT NULL COMMENT 'QQ',
  `UPDATETIME` datetime default '2000-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  index(EMAIL)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='管理员详细信息';

DROP TABLE IF EXISTS DEPARTMENT CASCADE;
CREATE TABLE `DEPARTMENT` (
  `ID` int(11) NOT NULL auto_increment,
  `NAME` varchar(255) NOT NULL COMMENT '名称',
  `CODE`  varchar(255) NOT NULL COMMENT '代号',
  `TYPE` int(2) NOT NULL COMMENT '类型：1、公司；2、部门；3、项目组',
  `LEADER_EMAIL` varchar(255) default NULL COMMENT '主管EMAIL',
  `SUPER_ID` int(11) NOT NULL COMMENT '上级部门ID',
  `CREATOR` varchar(255) NOT NULL COMMENT '创建人',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  `UPDATOR` varchar(255) default NULL COMMENT '修改人',
  `UPDATETIME` datetime default '2000-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  index(CODE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门';


DROP TABLE IF EXISTS POSITION CASCADE;
CREATE TABLE `POSITION` (
  `ID` int(11) NOT NULL auto_increment,
  `NAME` varchar(255) NOT NULL COMMENT '名称',
  `CODE`  varchar(255) NOT NULL COMMENT '代号',
  `CREATOR` varchar(255) NOT NULL COMMENT '创建人',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  `UPDATOR` varchar(255) default NULL COMMENT '修改人',
  `UPDATETIME` datetime default '2000-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  index(CODE)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='职位';


DROP TABLE IF EXISTS DEP_POS CASCADE;
CREATE TABLE `DEP_POS` (
  `ID` int(11) NOT NULL auto_increment,
  `DEPARTMENT_ID` int(11) default 0 COMMENT '部门ID',
  `POSITION_ID` int(11) default 0 COMMENT '职位ID',
  `CREATOR` varchar(255) NOT NULL COMMENT '创建人',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  `UPDATOR` varchar(255) default NULL COMMENT '修改人',
  `UPDATETIME` datetime default '2000-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`id`),
  index(DEPARTMENT_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='部门职位';


DROP TABLE IF EXISTS ROLE CASCADE;
CREATE TABLE `ROLE` (
  `ID` int(11) NOT NULL auto_increment,
  `ROLENAME` varchar(20) NOT NULL COMMENT '角色名称',
  `STATUS` int(2) NOT NULL COMMENT '角色状态',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  `RIGHTS` varchar(255) default '' COMMENT '权限',
  PRIMARY KEY  (`ID`),
  index(ROLENAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色';

insert into ROLE(`ROLENAME`,`STATUS`,`CREATETIME`,`RIGHTS`)values('管理员',1,'2012-08-01 08:08:08',',1,2,3,4,');

DROP TABLE IF EXISTS MENU CASCADE;
CREATE TABLE `MENU` (
  `ID` int(11) NOT NULL auto_increment,
  `MENUNAME` varchar(255) NOT NULL COMMENT '菜单名称',
  `STATUS` int(2) NOT NULL COMMENT '状态',
  `ORDERNUM` int(11) NOT NULL COMMENT '排序',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  index(MENUNAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='菜单';

insert into MENU(`MENUNAME`,`STATUS`,`ORDERNUM`,`CREATETIME`)values('功能列表',1,1,'2012-08-08 08:08:08');
insert into MENU(`MENUNAME`,`STATUS`,`ORDERNUM`,`CREATETIME`)values('系统菜单',1,10,'2012-08-08 08:08:08');

DROP TABLE IF EXISTS CATALOG CASCADE;
CREATE TABLE `CATALOG` (
  `ID` int(11) NOT NULL auto_increment,
  `CATALOGNAME` varchar(255) NOT NULL COMMENT '目录名称',
  `STATUS` int(2) NOT NULL COMMENT '状态',
  `ORDERNUM` int(11) NOT NULL COMMENT '排序',
  `MENU_ID` int(11) NOT NULL COMMENT '所属菜单ID',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY  (`id`),
  index(CATALOGNAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='目录';

insert into CATALOG(`CATALOGNAME`,`STATUS`,`ORDERNUM`,`MENU_ID`,`CREATETIME`)values('业务功能',1,1,1,'2012-08-08 08:08:08');
insert into CATALOG(`CATALOGNAME`,`STATUS`,`ORDERNUM`,`MENU_ID`,`CREATETIME`)values('系统管理',1,1,2,'2012-08-08 08:08:08');
insert into CATALOG(`CATALOGNAME`,`STATUS`,`ORDERNUM`,`MENU_ID`,`CREATETIME`)values('模块管理',1,2,2,'2012-08-08 08:08:08');
insert into CATALOG(`CATALOGNAME`,`STATUS`,`ORDERNUM`,`MENU_ID`,`CREATETIME`)values('地域管理',1,4,2,'2012-08-08 08:08:08');

DROP TABLE IF EXISTS MODULE CASCADE;
CREATE TABLE `MODULE` (
  `ID` int(11) NOT NULL auto_increment,
  `MODULENAME` varchar(20) NOT NULL COMMENT '模块名称',
  `MODULEURL` varchar(100) NOT NULL COMMENT '模块URL',
  `MODULEACT` varchar(100) NOT NULL COMMENT '模块Action',
  `CATALOG_ID` int(11) NOT NULL COMMENT '所属目录ID',
  `STATUS` int(2) NOT NULL COMMENT '模块状态',
  `CREATETIME` datetime default '0000-00-00 00:00:00' COMMENT '创建时间',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='模块';

insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('管理员管理','/admin/manager','managerAction',2,1,'2012-08-08 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('角色管理','/admin/role','roleAction',2,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('部门管理','/admin/department','departmentAction',2,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('职位管理','/admin/position','positionAction',2,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('菜单管理','/admin/menu','menuAction',3,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('目录管理','/admin/catalog','catalogAction',3,1,'2012-08-08 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('模块管理','/admin/module','moduleAction',3,1,'2012-08-08 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('日志管理','/admin/logs','logsAction',1,1,'2012-08-01 08:08:08');

insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('字典管理','/admin/dict','dictAction',1,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('报表','/admin/report','reportAction',1,1,'2012-08-01 08:08:08');

insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('省','/admin/province','provinceAction',1,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('市','/admin/city','cityAction',1,1,'2012-08-01 08:08:08');
insert into MODULE(`MODULENAME`,`MODULEURL`,`MODULEACT`,`CATALOG_ID`,`STATUS`,`CREATETIME`)values('区','/admin/area','areaAction',1,1,'2012-08-01 08:08:08');


DROP TABLE IF EXISTS LOGS CASCADE;
CREATE TABLE `LOGS` (
  `ID` int(11) NOT NULL auto_increment,
  `EMAIL` varchar(255) NOT NULL COMMENT '邮箱',
  `NICKNAME` varchar(255) default '' COMMENT '昵称',
  `IP` varchar(100) default '' COMMENT 'IP',
  `ACT` varchar(255) default '' COMMENT '操作标识：login、logoff，……',
  `OPTTIME` datetime default '0000-00-00 00:00:00' COMMENT '操作时间',
  `CONTENT` varchar(2000) default '' COMMENT '操作内容',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志';


DROP TABLE IF EXISTS DICT CASCADE;
CREATE TABLE `DICT` (
  `ID` int(11) NOT NULL auto_increment,
  `CODE` varchar(255) NOT NULL COMMENT '编码',
  `NAME` varchar(255) NOT NULL COMMENT '名称',
  `GROUP` varchar(255) NOT NULL COMMENT '数据组',
  `VALUE` varchar(255) NOT NULL COMMENT '值',
  `CREATEUSER` varchar(255) NOT NULL COMMENT '创建人',
  `CREATETIME` datetime default '2000-01-01 00:00:00' COMMENT '创建时间',
  `UPDATEUSER` varchar(255) default NULL COMMENT '修改人',
  `UPDATETIME` datetime default '2000-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='字典';








DROP TABLE IF EXISTS MEMBER CASCADE;
CREATE TABLE `MEMBER` (
  `ID` int(11) NOT NULL auto_increment,
  `USERNAME` varchar(255) NOT NULL COMMENT '用户名',
  `PASSWD` varchar(255) NOT NULL COMMENT '密码',
  `NAME` varchar(255) NOT NULL COMMENT '姓名',
  `STATUS` int(2) NOT NULL COMMENT '状态',
  `REGTIME` datetime default '2000-01-01 00:00:00' COMMENT '注册时间',
  `LOGINTIME` datetime default '2000-01-01 00:00:00' COMMENT '最后登录时间',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员';


DROP TABLE IF EXISTS MEMBER_INFO CASCADE;
CREATE TABLE `MEMBER_INFO` (
  `ID` int(11) NOT NULL auto_increment,
  `USERNAME` varchar(255) NOT NULL COMMENT '用户名',
  `SEX` int(2) NOT NULL COMMENT '性别：0、保密；1、男；2、女',
  `EMAIL` varchar(255) NOT NULL COMMENT '邮箱',
  `QQ` varchar(255) NOT NULL COMMENT 'QQ',
  `TEL`  varchar(255) NOT NULL COMMENT '座机',
  `MOBILE` varchar(255) NOT NULL COMMENT '手机',
  
  `NATIVE_PROVINCE_CODE` varchar(255) default NULL COMMENT '籍贯省编号',
  `NATIVE_CITY_CODE` varchar(255) default NULL COMMENT '籍贯市编号',
  `NATIVE_AREA_CODE` varchar(255) default NULL COMMENT '籍贯区编号',
  `ADDR_PROVINCE_CODE` varchar(255) default NULL COMMENT '现居省编号',
  `ADDR_CITY_CODE` varchar(255) default NULL COMMENT '现居市编号',
  `ADDR_AREA_CODE` varchar(255) default NULL COMMENT '现居区编号',
  `ADDRESS` varchar(255) default NULL COMMENT '地址',
  `POST_CODE` varchar(255) default NULL COMMENT '邮编',
  
  
  `CREATETIME` datetime default '2000-01-01 00:00:00' COMMENT '创建时间',
  `UPDATETIME` datetime default '2000-01-01 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员详细信息';


