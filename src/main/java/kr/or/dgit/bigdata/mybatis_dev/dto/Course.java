package kr.or.dgit.bigdata.mybatis_dev.dto;

import java.util.Date;

public class Course {
	private int courseId;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private int tutorId;
	
	/*getter/setter*/
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getTutorId() {
		return tutorId;
	}
	public void setTutorId(int tutorId) {
		this.tutorId = tutorId;
	}
	
	
	
	/*toString*/
	
	@Override
	public String toString() {
		return String.format("Course [%s, %s, %s, %s, %s, %s]", courseId, name, description, startDate, endDate, tutorId);
	}
	
	
	
	
}
