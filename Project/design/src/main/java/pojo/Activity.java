package pojo;

public class Activity {
	private Integer activityId;
	private String activityName;
	private Integer isPassed;
	private String startTime;
	private String endTime;
	private Integer peopleCountMax;
	private Integer peopleCountCurrent;
	private String requirement;
	private String activityIntroduction;
	public Integer getActivityId() {
		return activityId;
	}
	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public Integer getIsPassed() {
		return isPassed;
	}
	public void setIsPassed(Integer isPassed) {
		this.isPassed = isPassed;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getPeopleCountMax() {
		return peopleCountMax;
	}
	public void setPeopleCountMax(Integer peopleCountMax) {
		this.peopleCountMax = peopleCountMax;
	}
	public Integer getPeopleCountCurrent() {
		return peopleCountCurrent;
	}
	public void setPeopleCountCurrent(Integer peopleCountCurrent) {
		this.peopleCountCurrent = peopleCountCurrent;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getActivityIntroduction() {
		return activityIntroduction;
	}
	public void setActivityIntroduction(String activityIntroduction) {
		this.activityIntroduction = activityIntroduction;
	}

	
}