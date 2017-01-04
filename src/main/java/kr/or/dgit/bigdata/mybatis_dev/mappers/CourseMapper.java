package kr.or.dgit.bigdata.mybatis_dev.mappers;

import java.util.List;
import java.util.Map;

import kr.or.dgit.bigdata.mybatis_dev.dto.Course;
import kr.or.dgit.bigdata.mybatis_dev.dto.Student;

public interface CourseMapper {
	
	List<Course> searchCourses(Map<String, Object>map);
	List<Course> searchCaseCourses(Map<String, Object>map);
	List<Course> searchWhereCourses(Map<String, Object>map);
	List<Course> searchTrimCourses(Map<String, Object>map);
	List<Course> searchForeachCoursesByTutors(Map<String, Object>map);
	

}
