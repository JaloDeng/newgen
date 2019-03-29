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
  `type` varchar(50) DEFAULT NULL COMMENT '积分变更类型，如：sign、read等',
  `dataId` int(11) DEFAULT '0' COMMENT '对象主键，如：文章id、视频id等',
  `description` varchar(255) DEFAULT NULL COMMENT '积分变更描述，如：签到、阅读等',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员积分变更日志表';