-- ****************************************************************************************************************************************
-- 会员积分模块
-- ****************************************************************************************************************************************

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 会员积分表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_member_points`;
CREATE TABLE `t_member_points` (
  `memberId` int(11) NOT NULL COMMENT '主键和会员表主键，t_member.id',
  `points` int(11) DEFAULT '0' COMMENT '积分数',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`memberId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员积分表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 会员积分变更日志表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_member_points_log`;
CREATE TABLE `t_member_points_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `memberId` int(11) DEFAULT NULL COMMENT '会员表主键，t_member.id',
  `points` int(11) DEFAULT NULL COMMENT '积分变更数',
  `type` varchar(50) DEFAULT NULL COMMENT '积分变更类型，如：SIGNIN、READ等',
  `dataId` int(11) DEFAULT '0' COMMENT '对象主键，如：文章id、视频id等',
  `description` varchar(255) DEFAULT NULL COMMENT '积分变更描述，如：签到、阅读等',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员积分变更日志表';





-- ****************************************************************************************************************************************
-- 报名模块
-- ****************************************************************************************************************************************

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(11) DEFAULT '0' COMMENT '状态，0：新建、1：审核中、2：审核通过、3：报名中、 -1：报名结束',
  `title` varchar(150) DEFAULT NULL COMMENT '主题',
  `summary` varchar(1000) DEFAULT NULL COMMENT '摘要',
  `sponsorId` bigint(20) DEFAULT NULL COMMENT '主办方表主键，t_activity_sponsor.id',
  `homePath` varchar(500) DEFAULT NULL COMMENT '首页图片路径',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '编号，系统生成',
  `editor` varchar(50) DEFAULT NULL COMMENT '编辑作者',
  `fromTime` datetime DEFAULT NULL COMMENT '活动起始时间',
  `toTime` datetime DEFAULT NULL COMMENT '活动终止时间',
  `address` varchar(500) DEFAULT NULL COMMENT '活动地址',
  `detail` mediumtext COMMENT '详情',
  `expenseExplanation` text COMMENT '费用说明',
  `refundExplanation` text COMMENT '退款说明',
  `notice` text COMMENT '报名须知',
  `clickCount` int(11) DEFAULT '0' COMMENT '阅读数量',
  `likeCount` int(11) DEFAULT '0' COMMENT '喜欢数量、收藏数量',
  `shareCount` int(11) DEFAULT '0' COMMENT '分享数量',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动表';

INSERT INTO `t_activity` VALUES (1, -1, '达记讲古', '逢周三下午，达记讲古', 1, 'http://172.16.20.192:8080/activityHome/1.jpg', '20190409001', '罗达', '2019-04-11 14:00:00', '2019-04-11 17:00:00', '广东省佛山市禅城区南庄镇醒群江边村榕树头', '这是详情', '这是费用说明', '这是退款说明', '这是报名须知', 0, 0, 0, '这是备注', '2019-04-09 16:07:12', '2019-04-09 16:07:06', '2019-04-29 17:47:06');
INSERT INTO `t_activity` VALUES (2, 1, '3D全息投影', '全息投影展示装修效果', 2, 'http://172.16.20.192:8080/activityHome/2.jpg', '20190409002', '超记', '2019-05-01 09:00:00', '2019-05-07 17:00:00', '广东省佛山市南海区西樵镇西樵山脚', '这是详情', '这是费用说明', '这是退款说明', '这是报名须知', 0, 0, 0, NULL, '2019-04-09 16:33:55', '2019-04-09 16:33:52', '2019-04-09 16:33:53');
INSERT INTO `t_activity` VALUES (3, 0, '精装修是好是坏', '为你讲述精装修房验收注意事项', 2, 'http://172.16.20.192:8080/activityHome/3.jpg', '20190409003', '超记', '2019-05-12 14:00:00', '2019-05-12 16:00:00', '广东省佛山市南海区西樵镇西樵山顶', '这是详情', '这是费用说明', '这是退款说明', '这是报名须知', 0, 0, 0, '', '2019-04-09 16:42:16', '2019-04-09 16:42:11', '2019-04-29 10:50:04');
INSERT INTO `t_activity` VALUES (4, 0, '汽车之家联合东风日产展览', '车展', 4, 'http://172.16.20.192:8080/activityHome/3.jpg', '20190426001', '涛桑', '2019-04-26 15:00:00', '2019-05-02 15:00:00', '佛山市西樵镇新田汽车之家研究中心', '明细', '免费、5元', '不予退款', '注意事项', 0, 0, 0, '备注', NULL, '2019-04-26 16:42:07', '2019-04-29 10:50:15');
INSERT INTO `t_activity` VALUES (5, 0, '波桑农庄五一特惠套餐', '五一2款套餐特惠', 5, 'http://172.16.20.192:8080/activityHome/3.jpg', '20190428001', '波桑', '2019-05-01 11:30:00', '2019-05-04 21:00:00', '广东揭阳市唔知路', '山珍海味特惠', '山珍：100元，海味：150元', '退款说明', '注意事项', 0, 0, 0, '备注', NULL, '2019-04-28 16:08:41', '2019-04-29 10:50:21');
INSERT INTO `t_activity` VALUES (6, 0, '珠海门窗装修讲座', '摘要', 2, 'http://172.16.20.192:8080/activityHome/3.jpg', '20190429002', '超桑', '2019-04-30 09:00:00', '2019-04-30 15:00:00', '珠海市', '明细', '费用说明', '退款说明', '注意事项', 0, 0, 0, '备注', NULL, '2019-04-29 17:51:48', '2019-04-30 09:38:18');

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动主办方表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_sponsor`;
CREATE TABLE `t_activity_sponsor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '编号，系统生成',
  `name` varchar(150) DEFAULT NULL COMMENT '名称',
  `contact` varchar(100) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `logoPath` varchar(500) DEFAULT NULL COMMENT 'logo路径',
  `score` int(11) DEFAULT '0' COMMENT '星级分数',
  `declaration` varchar(500) DEFAULT NULL COMMENT '宣言、口号、公告、声明',
  `summary` varchar(1000) DEFAULT NULL COMMENT '简介',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动主办方表';

INSERT INTO `t_activity_sponsor` VALUES (1, '20190409001', '达记历史研究所', '罗达', '13690649663', '广东省佛山市禅城区南庄镇醒群江边村榕树头隔离', 'http://172.16.20.192:8080/sponsorLogo/1.jpg', 1, '这是描述', '讲古佬', '2019-04-09 16:08:56', '2019-04-09 16:08:58');
INSERT INTO `t_activity_sponsor` VALUES (2, '20190409002', '超记装修工作室', '超记', '13123456789', '广东省佛山市南海区西樵镇西樵山顶超记农庄', 'http://172.16.20.192:8080/sponsorLogo/2.jpg', 2, '这是描述', '装修佬', '2019-04-09 16:31:15', '2019-04-09 16:31:17');
INSERT INTO `t_activity_sponsor` VALUES (3, '20190426001', '春少比亚迪专卖店', '春少', '13674016400', '广东省佛山市罗村唔知边度', 'http://172.16.20.192:8080/sponsorLogo/2.jpg', 0, '这是描述', '比亚迪全车型专卖店', '2019-04-26 14:53:24', '2019-04-26 15:16:35');
INSERT INTO `t_activity_sponsor` VALUES (4, '20190426002', '涛桑汽车之家', '涛桑', '13724630294', '广东省佛山市西樵新田汽车之家研究中心', 'http://172.16.20.192:8080/sponsorLogo/2.jpg', 0, '这是描述', '汽车之家研究中心', '2019-04-26 15:19:00', '2019-04-26 15:19:00');
INSERT INTO `t_activity_sponsor` VALUES (5, '20190428001', '波桑农庄', '波桑', '13434929459', '广东揭阳市唔知路', 'http://172.16.20.192:8080/sponsorLogo/2.jpg', 0, '专门收集全世界美食', '美食专家', '2019-04-28 15:29:49', '2019-04-28 15:29:49');


-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动套餐表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_package`;
CREATE TABLE `t_activity_package` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activityId` bigint(20) DEFAULT NULL COMMENT '活动表主键，t_activity.id',
  `price` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `quota` int(11) DEFAULT '-1' COMMENT '名额、配额，-1：不限',
  `title` varchar(100) DEFAULT NULL COMMENT '主题，套餐、尺寸、型号、方案等',
  `explanation` varchar(500) DEFAULT NULL COMMENT '费用说明',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动套餐表';

INSERT INTO `t_activity_package` VALUES (1, 1, 5.00, -1, '套餐一', '5元', '2019-04-10 16:48:36', '2019-04-10 16:48:39');
INSERT INTO `t_activity_package` VALUES (2, 1, 10.00, 10, '套餐二', '下午茶，沙县拌面一碟', '2019-04-10 17:37:38', '2019-04-10 17:37:40');
INSERT INTO `t_activity_package` VALUES (3, 2, 0.00, -1, '免费', '免费', '2019-04-12 16:29:32', '2019-04-12 16:29:34');
INSERT INTO `t_activity_package` VALUES (4, 3, 10.00, -1, '活动费用', '10元', '2019-04-12 16:29:47', '2019-04-12 16:29:50');
INSERT INTO `t_activity_package` VALUES (5, 4, 0.00, 10, '免费', '免费', '2019-04-26 16:47:18', '2019-04-26 16:52:09');
INSERT INTO `t_activity_package` VALUES (6, 4, 10.00, 6, '10元', '10元', '2019-04-26 16:52:09', '2019-04-26 16:52:09');
INSERT INTO `t_activity_package` VALUES (7, 5, 100.00, -1, '100元套餐', '山珍', '2019-04-28 16:08:41', '2019-04-28 16:26:17');
INSERT INTO `t_activity_package` VALUES (8, 5, 200.00, 10, '200元套餐', '山珍海味', '2019-04-28 16:26:17', '2019-04-28 16:26:17');
INSERT INTO `t_activity_package` VALUES (9, 6, 0.00, -1, '免费', '免费', '2019-04-29 17:51:48', '2019-04-30 09:38:18');
INSERT INTO `t_activity_package` VALUES (17, 6, 5.00, 5, '5元', '5元', '2019-04-30 09:38:18', '2019-04-30 09:38:18');

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动报名表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_sign_up`;
CREATE TABLE `t_activity_sign_up` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activityId` bigint(20) DEFAULT NULL COMMENT '活动表主键，t_activity.id',
  `memberId` int(11) DEFAULT NULL COMMENT '会员表主键，t_member.id',
  `activityPackageId` bigint(20) DEFAULT NULL COMMENT '活动费用表主键，t_activity_package.id',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '编号，流水号码，系统生成',
  `status` int(4) DEFAULT '0' COMMENT '状态，1：已签到、0：已报名、-1：已取消报名',
  `amount` decimal(10,2) DEFAULT '0.00' COMMENT '实际支付金额',
  `channel` varchar(150) DEFAULT NULL COMMENT '报名渠道',
  `name` varchar(100) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `IDCard` varchar(100) DEFAULT NULL COMMENT '身份证号码',
  `signUpTime` datetime DEFAULT NULL COMMENT '报名时间',
  `cancelSignUpTime` datetime DEFAULT NULL COMMENT '取消报名时间',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `refundTime` datetime DEFAULT NULL COMMENT '退款时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动报名表';

INSERT INTO `t_activity_sign_up` VALUES (1, 1, 1, 1, '20190411', 0, 0.00, 'weixin', 'Jalo', '13516555700', '123456789', NULL, NULL, '备注😀', NULL, '2019-04-17 12:21:11', '2019-04-17 12:21:16');

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 会员收藏活动中间表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_member_like`;
CREATE TABLE `t_activity_member_like` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activityId` bigint(20) DEFAULT NULL COMMENT '活动表主键，t_activity.id',
  `phone` varchar(50) DEFAULT NULL COMMENT '会员手机号码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='会员收藏活动中间表';

INSERT INTO `t_activity_member_like` VALUES (2, 1, '13690649663');
INSERT INTO `t_activity_member_like` VALUES (4, 1, '13516555700');

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动支付记录表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_payment_log`;
CREATE TABLE `t_activity_payment_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activitySignUpId` bigint(20) DEFAULT NULL COMMENT '报名表主键，t_activity_sign_up.id',
  `amount` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '编号，流水号码，系统生成',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动支付记录表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动退款记录表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_refund_log`;
CREATE TABLE `t_activity_refund_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activitySignUpId` bigint(20) DEFAULT NULL COMMENT '报名表主键，t_activity_sign_up.id',
  `amount` decimal(10,2) DEFAULT '0.00' COMMENT '金额',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '编号，流水号码，系统生成',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动退款记录表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动评价表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_review`;
CREATE TABLE `t_activity_review` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `activitySignUpId` bigint(20) DEFAULT NULL COMMENT '活动报名表主键，t_activity_sign_up.id',
  `activityId` bigint(20) DEFAULT NULL COMMENT '活动表主键，t_activity.id',
  `content` varchar(1000) DEFAULT NULL COMMENT '评论内容',
  `picture` varchar(500) DEFAULT NULL COMMENT '图片路径',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动评价表';

INSERT INTO `t_activity_review` VALUES (1, 1, 1, '讲古可以', NULL, '2019-04-17 14:53:52', '2019-04-17 14:53:52');

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动系统用户表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_user`;
CREATE TABLE `t_activity_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `phone` varchar(50) DEFAULT NULL COMMENT '手机号码',
  `telephone` varchar(50) DEFAULT NULL COMMENT '固定电话号码',
  `address` varchar(200) DEFAULT NULL COMMENT '联系地址',
  `enabled` tinyint(1) DEFAULT '1',
  `username` varchar(100) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `userface` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='活动系统用户表';

INSERT INTO t_activity_user VALUES (1, '系统管理员', NULL, NULL, NULL, 1, 'admin', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', NULL, NULL);
INSERT INTO t_activity_user VALUES (2, '活动管理员', NULL, NULL, NULL, 1, 'activitymanager', '$2a$10$lBPZ8SzSV4uVMU9rxBPvh.fbkyANGqZ6jcMgPejIzIsBs/BvCf9zm', NULL, NULL);
INSERT INTO t_activity_user VALUES (3, '活动编辑员', NULL, NULL, NULL, 1, 'activityeditor', '$2a$10$lBPZ8SzSV4uVMU9rxBPvh.fbkyANGqZ6jcMgPejIzIsBs/BvCf9zm', NULL, NULL);

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动系统角色表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_role`;
CREATE TABLE `t_activity_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '角色名称',
  `nameZh` varchar(50) DEFAULT NULL COMMENT '角色名称（中文）',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名系统角色表';

INSERT INTO t_activity_role VALUES (1, 'ROLE_ADMIN', '系统管理员', NOW(), NOW());
INSERT INTO t_activity_role VALUES (2, 'ROLE_ACTIVITY_MANAGER', '活动报名管理员', NOW(), NOW());
INSERT INTO t_activity_role VALUES (3, 'ROLE_ACTIVITY_EDITOR', '活动报名管理员', NOW(), NOW());

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动系统菜单表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_menu`;
CREATE TABLE `t_activity_menu` (
  `id` int(11) NOT NULL COMMENT '主键ID',
  `url` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `iconCls` varchar(100) DEFAULT NULL COMMENT '图标',
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL COMMENT '父节点',
	`enabled` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名系统菜单表';

INSERT INTO t_activity_menu VALUES (1, '/', NULL, NULL, '所有', NULL, NULL, NULL, NULL, 1);
INSERT INTO t_activity_menu VALUES (11, '/', '/home', 'Home', '活动报名', NULL, NULL, 1, 1, 1);
INSERT INTO t_activity_menu VALUES (99, '/', '/home', 'Home', '系统管理', NULL, NULL, 1, 1, 1);
INSERT INTO t_activity_menu VALUES (101, '/activity/**', '/activity/activity', 'Home', '活动资料', NULL, NULL, 1, 11, 1);
INSERT INTO t_activity_menu VALUES (102, '/sponsor/**', '/activity/sponsor', 'Home', '主办方资料', NULL, NULL, 1, 11, 1);
INSERT INTO t_activity_menu VALUES (901, '/system/user/**', '/system/user', 'Home', '用户管理', NULL, NULL, 1, 99, 1);
INSERT INTO t_activity_menu VALUES (902, '/system/role/**', '/system/role', 'Home', '角色管理', NULL, NULL, 1, 99, 1);

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 报名系统用户角色中间表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_user_role`;
CREATE TABLE `t_activity_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `activityUserId` int(11) DEFAULT NULL COMMENT '活动系统用户表主键，t_activity_user.id',
  `activityRoleId` int(11) DEFAULT NULL COMMENT '活动系统角色表主键，t_activity_role.id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名系统用户角色中间表';

INSERT INTO t_activity_user_role VALUES (1, 1, 1);
INSERT INTO t_activity_user_role VALUES (2, 2, 2);
INSERT INTO t_activity_user_role VALUES (3, 3, 3);

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 报名系统角色权限中间表
-- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE `t_activity_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `activityRoleId` int(11) DEFAULT NULL COMMENT '活动系统角色表主键，t_activity_role.id',
  `activityMenuId` int(11) DEFAULT NULL COMMENT '报名系统菜单表主键，t_activity_menu.id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名系统角色菜单中间表';

INSERT INTO t_activity_role_menu VALUES (1, 1, 1);
INSERT INTO t_activity_role_menu VALUES (2, 1, 11);
INSERT INTO t_activity_role_menu VALUES (3, 1, 99);
INSERT INTO t_activity_role_menu VALUES (4, 1, 101);
INSERT INTO t_activity_role_menu VALUES (5, 1, 102);
INSERT INTO t_activity_role_menu VALUES (6, 1, 901);
INSERT INTO t_activity_role_menu VALUES (7, 1, 902);
INSERT INTO t_activity_role_menu VALUES (8, 2, 1);
INSERT INTO t_activity_role_menu VALUES (9, 2, 11);
INSERT INTO t_activity_role_menu VALUES (10, 2, 101);
INSERT INTO t_activity_role_menu VALUES (11, 2, 102);
INSERT INTO t_activity_role_menu VALUES (12, 3, 1);
INSERT INTO t_activity_role_menu VALUES (13, 3, 11);
INSERT INTO t_activity_role_menu VALUES (14, 3, 101);
INSERT INTO t_activity_role_menu VALUES (15, 3, 102);







