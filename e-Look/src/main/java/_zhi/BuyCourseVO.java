package _zhi;

public class BuyCourseVO {
	private Integer memberID;
	private Integer courseID;
	private Integer score;
	public BuyCourseVO(){};
	public BuyCourseVO(Integer memberID, Integer courseID, Integer score) {
		this.memberID = memberID;
		this.courseID = courseID;
		this.score = score;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public Integer getCourseID() {
		return courseID;
	}
	public void setCourseID(Integer courseID) {
		this.courseID = courseID;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
	
}
