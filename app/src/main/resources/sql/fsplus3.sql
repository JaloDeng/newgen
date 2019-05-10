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

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动系统菜单表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_menu`;
CREATE TABLE `t_activity_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `url` varchar(100) DEFAULT NULL,
  `path` varchar(100) DEFAULT NULL,
  `component` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL COMMENT '名称',
  `iconCls` varchar(100) DEFAULT NULL COMMENT '图标',
  `keepAlive` tinyint(1) DEFAULT NULL,
  `requireAuth` tinyint(1) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL COMMENT '父节点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名系统菜单表';

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

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 报名系统角色权限中间表
-- ----------------------------------------------------------------------------------------------------------------------------------------
CREATE TABLE `t_activity_role_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `activityRoleId` int(11) DEFAULT NULL COMMENT '活动系统角色表主键，t_activity_role.id',
  `activityMenuId` int(11) DEFAULT NULL COMMENT '报名系统菜单表主键，t_activity_menu.id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报名系统角色菜单中间表';







