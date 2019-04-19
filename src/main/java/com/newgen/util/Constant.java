package com.newgen.util;

/**
 * @author Jalo Deng
 * @email 651379728@qq.com
 * @time 2019年4月19日 上午10:38:59
 */

public class Constant {

	public static enum MemberPointsType {
		SIGNIN("签到", 2, 1), 
		READ("阅读", 1, 2);
		
		private final String description;
		private final Integer points;
		private final Integer maxTimes;
		
		private MemberPointsType(String description, Integer points, Integer maxTimes) {
			this.description = description;
			this.points = points;
			this.maxTimes = maxTimes;
		}
		
		public String getDescription() {
			return this.description;
		}
		
		public Integer getPoints() {
			return this.points;
		}
		
		public Integer getMaxTimes() {
			return this.maxTimes;
		}
	}
	
}
