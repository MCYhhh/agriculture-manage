# 建立数据库

# create database platform;
# use platform;

# 建立模式

# create schema platform;
# use platform;


drop table if exists  user;
create table user(
                     uid int auto_increment primary key , #用户id（主键上自动建立索引）
        uaccount varchar(32)  character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null unique ,   #用户账号（注册中要求用户账号唯一）
                         uname varchar(32)  character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #用户昵称
                         upwd varchar(300) character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #密码(可能有加密操作，字符串比较长）
                         utype int  not null default 0,   #用户角色（0----顾客，1-----农户或商家，2------后台管理员）
                         usex char(2) character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #用户性别
                         uemail varchar(20) character set utf8mb4 collate utf8mb4_da_0900_ai_ci , #邮箱
                         utel char(11) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,#电话
                         uaddress varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #地址
                         uimg varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,    #头像
                         udesp varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #个人简介
                         state int not null default 0,#状态（0---正常，1---禁用）
                         create_time datetime not null default current_timestamp,  #不填默认当前时间
                         update_time datetime not null default current_timestamp on update  current_timestamp, #当前修改的时间
                         unique index index_name(uaccount) using btree   #在用户账号上创建唯一索引（注册中要求用户账号唯一）
                         )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                         comment '用户表'
;

drop table if exists goods;
create table goods(
                      gid int auto_increment primary key , #商品id（主键上自动建立索引）
        gname varchar(32)  character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #商品名称
                          gprice decimal(7,2) not null ,   #商品单价
                          gsate int not null default 0,   #商品状态（0--未购买，1---购物车中，2----购买待支付，3----已支付）
                              gimg varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,#商品图片
                          gdesp varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci, #商品描述
                          state int not null default 0,#状态（0---正常，1---禁用）
                              create_time datetime not null default current_timestamp,  #不填默认当前时间
                          update_time datetime not null default current_timestamp on update current_timestamp #当前修改的时间
)engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
    comment '商品表'
;

drop table if exists chargegoods;
create table chargegoods (
                             cid int auto_increment primary key , #商品管理id（主键上自动建立索引）
        uid int not null ,   #商家或农户id
                                 gid int not null ,   #商品id
                                 cnum int not null ,  #商品数量
                                 cdate datetime not null default current_timestamp, #商品的添加时间，精确到秒，不填表示当前时间
                                 index index_gid(gid) using btree ,  #在外键上创建索引
                                 index index_uid(uid) using btree ,  #在外键上创建索引
                                 state int not null default 0,#状态（0---正常，1---禁用）
                                 foreign key (gid) references goods(gid) on delete cascade on update restrict,  #商品id作为外键(级联操作，删除商品管理表中对应的数据，不存在外键删除问题）
                                 foreign key (uid) references user(uid) on delete cascade on update restrict,  #用户id作为外键(级联操作，删除用户表中对应的数据，不存在外键删除问题）
                                 update_time datetime not null default current_timestamp on update  current_timestamp #当前修改的时间
                                 )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                                 comment '商品管理表'
;

drop table if exists orders;
create table orders(
                       oid int auto_increment primary key , #订单id（主键上自动建立索引）
        cid int not null ,  #顾客id
                           ototal decimal(10,2),   #顾客总消费
                           odate datetime default current_timestamp on update current_timestamp, #商品订单更新时间，精确到秒，不填表示当前时间
                           uid int not null ,#农户或商家id
                           foreign key (cid) references user(uid) on delete cascade on update restrict,  #订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                           foreign key (uid) references user(uid) on delete cascade on update restrict,  #订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                           osate int not null default 0,   #订单状态（0----未支付，1---已支付，2----退货未退款，3---退货并收到退款）
                           create_time datetime not null default current_timestamp  #商品订单生成时间,不填默认当前时间
                           )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                           comment '订单表'
;

drop table if exists detailorder;
create table detailorder(
                            did int auto_increment primary key , #订单商品管理id（主键上自动建立索引）
        oid int not null ,   #订单id
                                gid int not null ,   #商品id
                                dnum int not null ,  #订单中该商品的数量
                                dtotal decimal(10,2) not null , #该订单总消费
                                index index_gid(gid) using btree ,  #在外键上创建索引
                                index index_oid(oid) using btree ,  #在外键上创建索引
                                foreign key (gid) references goods(gid) on delete cascade on update restrict,  #商品id作为外键(级联操作，删除商品管理表中对应的数据，不存在外键删除问题）
                                foreign key (oid) references orders(oid) on delete cascade on update restrict  #订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                                )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                                comment '订单商品表'
;

drop table if exists scenery;
create table scenery(
                        sid int auto_increment primary key , #景区id（主键上自动建立索引）
        sname varchar(32)  character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #景区名称
                            saddress varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #景区地址
                            sprice decimal(7,2) not null , #景区门票
                            sdesp varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #景区介绍
                            sstate int not null default 0 ,#景区状态（0---开放，1----闭馆）
                                sdate datetime not null default current_timestamp on update  current_timestamp,   #每次更新这条数据的时候，该字段都会更新成当前时间
                            uid int not null, #景区负责人
                            index index_uid(uid) using btree ,  #在外键上创建索引
                            foreign key (uid) references user(uid) on delete cascade on update restrict  #订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                            )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                            comment '景区表'
;

drop table if exists reserve;
create table reserve(
                        rid int auto_increment primary key , #景区预约id（主键上自动建立索引）
        sid int not null ,   #景区id
                            gid int not null ,   #商品id
                            uid int not null, #顾客id
                            dnum int not null ,  #订单中该商品的数量
                            dtotal decimal(10,2), #该订单总消费
                            index index_gid(gid) using btree ,  #在外键上创建索引
                            index index_sid(sid) using btree ,  #在外键上创建索引
                            index index_uid(uid) using btree ,  #在外键上创建索引
                            foreign key (gid) references goods(gid) on delete cascade on update restrict,  #商品id作为外键(级联操作，删除景区预约表中对应的数据，不存在外键删除问题）
                            foreign key (sid) references scenery(sid) on delete cascade on update restrict,  #景区id作为外键(级联操作，删除景区预约表中对应的数据，不存在外键删除问题）
                            foreign key (uid) references user(uid) on delete cascade on update restrict,  #用户id作为外键(级联操作，删除景区预约表中对应的数据，不存在外键删除问题）
                            create_time datetime not null default current_timestamp,  #不填默认当前时间
                            update_time datetime not null default current_timestamp on update  current_timestamp  #当前修改的时间
                            )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                            comment '景区预约'
;

drop table if exists comment;
create table comment(
                        cid int auto_increment primary key , #评论id（主键上自动建立索引）
        ctype int not null ,#评论类型（0---商家或用户，1---顾客）
                                ccontent varchar(20)  character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #评论内容
                            uid int not null ,  #评论用户
                            index index_uid(uid) using btree ,  #在外键上创建索引
                            foreign key (uid) references user(uid) on delete cascade on update restrict,  #用户id作为外键(级联操作，删除评论表中对应的数据，不存在外键删除问题）
                            create_time datetime not null default current_timestamp,  #不填默认当前时间
                            update_time datetime not null default current_timestamp on update  current_timestamp  #当前修改的时间
                            )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                            comment '评论表'
;

drop table if exists replay;
create table replay(
                       rid int auto_increment primary key , #回复id（主键上自动建立索引）
        cid int not null , #评论id ,如果rtype=0，则cid=rpid
                           rpid int not null , #回复目标id ，如果rtype=1，则rpid表示该条回复的父回复
                           rtype int not null ,#回复类型（0---对于别人的评论，1---对于别人的回复）
                               fuid int not null ,#回复用户id
                           tuid int not null, #目标用户id  （如果rtype=0，则tuid是发表对应评论的用户，如果rtype=1，则tuid是发表父回复的用户）
                           index index_cid(cid) using btree ,  #在外键上创建索引
                           index index_fuid(fuid) using btree ,  #在外键上创建索引
                           index index_tuid(tuid) using btree ,  #在外键上创建索引
                           foreign key (cid) references comment(cid) on delete cascade on update restrict,  #用户id作为外键(级联操作，删除用户菜单表中对应的数据，不存在外键删除问题）
                           foreign key (fuid) references user(uid) on delete cascade on update restrict,  #用户id作为外键(级联操作，删除用户菜单表中对应的数据，不存在外键删除问题）
                           foreign key (tuid) references user(uid) on delete cascade on update restrict,  #用户id作为外键(级联操作，删除用户菜单表中对应的数据，不存在外键删除问题）
                           create_time datetime not null default current_timestamp,  #不填默认当前时间
                           update_time datetime not null default current_timestamp on update  current_timestamp  #当前修改的时间
                           )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                           comment '回复表'
;

drop table if exists menu;
create table menu(
                     mid int auto_increment primary key , #菜单id（主键上自动建立索引）
        mtitle varchar(20)  character set utf8mb4 collate utf8mb4_da_0900_ai_ci not null ,   #菜单名称
                         mdesp varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #菜单描述
                         mpath varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #菜单功能url
                         mrouter varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci,  #对应的前端路由
                         mvisible int default 0,   #菜单状态（0--显示，1隐藏）
                             state int default 0,  #菜单状态（0--正常，1---停用）
                             update_by int,
                     create_by int,
                     create_time datetime not null default current_timestamp,  #不填默认当前时间
                         update_time datetime not null default current_timestamp on update  current_timestamp,  #当前修改的时间
                         del int default 0,  #是否删除（0---未删除，1--已删除）
                             mpid int,  #父级菜单id（可为空）
                         micon varchar(100) character set utf8mb4 collate utf8mb4_da_0900_ai_ci  #菜单图标
)engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
    comment '菜单表'
;

drop table if exists administrate;
create table administrate(
                             rid int not null , #角色id
                                 mid int not null, #菜单id
                                 primary key (rid,mid),
                             foreign key (mid) references menu(mid) on delete cascade on update restrict  #用户id作为外键(级联操作，删除用户菜单表中对应的数据，不存在外键删除问题）
                                 )engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                                 comment '用户菜单表'
;

drop table if exists role;
create table role(
                     rid int auto_increment primary key , #用户id
                         rtype int not null ,#用户角色类型（0----顾客，1-----农户或商家，2------后台管理员）
                             update_by int,
                     state int default 0 not null ,#角色状态（0---正常，1---停用）
                             create_by int,
                     create_time datetime not null default current_timestamp,  #不填默认当前时间
                         update_time datetime not null default current_timestamp on update  current_timestamp,  #当前修改的时间
                         del int default 0  #是否删除（0---未删除，1--已删除）
)engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
    comment '角色表'
;

drop table if exists user_role;
create table user_role(
                          rid int not null , #用户id
                              uid int not null ,
                          primary key (rid,uid)
)engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
    comment '用户角色表'
;

drop table if exists trolley;
create table trolley(
                        tid int auto_increment primary key , #购物车管理id（主键上自动建立索引）
        gid int not null ,   #商品id
                            tnum int not null ,  #购物车中该商品的数量
                            ttotal decimal(10,2) not null , #该样产品总消费
                            cid int not null ,  #顾客id
                            uid int not null ,#农户或商家id
                            tstate int not null default 0,   #商品状态（0----未被勾选上，1---勾选上，2----，3---）
                                create_time datetime not null default current_timestamp ,#购物车生成时间,不填默认当前时间
                            update_time datetime not null default current_timestamp on update  current_timestamp ,#当前修改的时间
                            foreign key (gid) references goods(gid) on delete cascade on update restrict,  #商品id作为外键(级联操作，删除商品管理表中对应的数据，不存在外键删除问题）
                            foreign key (cid) references user(uid) on delete cascade on update restrict  ,#订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                            foreign key (uid) references user(uid) on delete cascade on update restrict  #订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                            ) engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                            comment '购物车';

drop table if exists article;
create table article(
                        id int auto_increment primary key , #文章id（主键上自动建立索引）
        title varchar(50) not null ,#标题
                           type int not null ,#类型（0表示游记，1表示娱乐）
                            summary varchar(50) not null ,#摘要
                           content varchar(200) not null ,#正文
                           score decimal(2,1) not null ,#评分
                           uid int not null ,#作者id
                           create_time datetime not null default current_timestamp ,#购物车生成时间,不填默认当前时间
                           update_time datetime not null default current_timestamp on update  current_timestamp ,#当前修改的时间
                            foreign key (uid) references user(uid) on delete cascade on update restrict  #订单id作为外键(级联操作，删除订单表中对应的数据，不存在外键删除问题）
                            ) engine =InnoDB auto_increment=0 character set utf8mb4 collate utf8mb4_da_0900_ai_ci row_format =dynamic
                            comment '文章';