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
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分表';

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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='会员积分变更日志表';





-- ****************************************************************************************************************************************
-- 报名模块
-- ****************************************************************************************************************************************

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity`;
CREATE TABLE `t_activity` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `status` int(11) DEFAULT NULL COMMENT '状态，新建、发布、报名中、报名结束、活动中、活动结束',
  `title` varchar(150) DEFAULT NULL COMMENT '主题',
  `summary` varchar(1000) DEFAULT NULL COMMENT '摘要',
  `sponsorId` int(11) DEFAULT NULL COMMENT '主办方，t_activity_sponsor.id',
  `editor` varchar(50) DEFAULT NULL COMMENT '编辑作者',
  `FromTime` datetime DEFAULT NULL COMMENT '活动起始时间',
  `ToTime` datetime DEFAULT NULL COMMENT '活动终止时间',
  `detail` mediumtext COMMENT '详情',
  `expenseExplanation` text COMMENT '费用说明',
  `refundExplanation` text COMMENT '退款说明',
  `notice` text COMMENT '报名须知',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `releaseTime` datetime DEFAULT NULL COMMENT '发布时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动主办方表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_sponsor`;
CREATE TABLE `t_activity_sponsor` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(150) DEFAULT NULL COMMENT '名称',
  `contact` varchar(100) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(100) DEFAULT NULL COMMENT '电话',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `logo` varchar(500) DEFAULT NULL COMMENT 'logo路径',
  `score` int(11) DEFAULT NULL COMMENT '星级分数',
  `declaration` varchar(500) DEFAULT NULL COMMENT '宣言、口号、公告、声明',
  `summary` varchar(1000) DEFAULT NULL COMMENT '简介',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动主办方表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动费用表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_expense`;
CREATE TABLE `t_activity_expense` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `price` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `quota` int(11) DEFAULT NULL COMMENT '名额、配额，-1：不限',
  `plan` varchar(100) DEFAULT NULL COMMENT '标题、尺寸、型号、计划、方案等',
  `explanation` varchar(500) DEFAULT NULL COMMENT '费用说明',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动费用表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动报名表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_sign_up`;
CREATE TABLE `t_activity_sign_up` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `activityId` bigint(20) DEFAULT NULL COMMENT '活动主键，t_activity.id',
  `memberId` int(11) DEFAULT NULL COMMENT '会员主键，t_member.id',
  `activityExpenseId` bigint(20) DEFAULT NULL COMMENT '活动费用主键，t_activity_expense.id',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '流水号码',
  `status` int(4) DEFAULT NULL COMMENT '状态，1：已报名、-1：已取消报名',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '实际支付金额',
  `channel` varchar(150) DEFAULT NULL COMMENT '报名渠道',
  `signUpTime` datetime DEFAULT NULL COMMENT '报名时间',
  `cancelSignUpTime` datetime DEFAULT NULL COMMENT '取消报名时间',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `refundTime` datetime DEFAULT NULL COMMENT '退款时间',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动报名表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动支付记录表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_payment_log`;
CREATE TABLE `t_activity_payment_log` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `activitySignUpId` bigint(20) DEFAULT NULL COMMENT '报名表主键，t_activity_sign_up.id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '流水号码',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动支付记录表';

-- ----------------------------------------------------------------------------------------------------------------------------------------
-- 活动退款记录表
-- ----------------------------------------------------------------------------------------------------------------------------------------
DROP TABLE IF EXISTS `t_activity_refund_log`;
CREATE TABLE `t_activity_refund_log` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `activitySignUpId` bigint(20) DEFAULT NULL COMMENT '报名表主键，t_activity_sign_up.id',
  `amount` decimal(10,2) DEFAULT NULL COMMENT '金额',
  `serialNumber` varchar(100) DEFAULT NULL COMMENT '流水号码',
  `remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='活动退款记录表';


