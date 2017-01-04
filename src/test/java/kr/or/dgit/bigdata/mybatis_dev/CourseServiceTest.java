package kr.or.dgit.bigdata.mybatis_dev;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import kr.or.dgit.bigdata.mybatis_dev.dto.Course;
import kr.or.dgit.bigdata.mybatis_dev.service.CourseService;

public class CourseServiceTest {
	
	private static CourseService courseService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		courseService = CourseService.getInstance();		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		courseService = null;
	}

	@Test
	public void testSearchCourse() {
		GregorianCalendar cal = new GregorianCalendar(2013,1,1);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorId", 1);
		map.put("courseName", "%java%");
		map.put("startDate", cal.getTime());
		
		List<Course> courses = courseService.searchCourses(map);
		Assert.assertNotNull(courses);
		
		for(Course course : courses){
			Assert.assertNotNull(course);			
		}
	}

	
	@Test
	public void testSearchCaseCourses() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("searchBy", "Tutor");
		map.put("tutorId", 1);
				
		List<Course> courses = courseService.searchCaseCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);			
		}
		
		map.replace("searchBy", "CourseName");
		map.remove("tutorId");
		map.put("courseName", "%java%");
		
		courses = courseService.searchCaseCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
	}
	
	@Test
	public void testSearchWhereCourses() {
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Course> courses = courseService.searchWhereCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);			
		}

		map.put("tutorId", 1);
		
		courses = courseService.searchWhereCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
		
		map.put("courseName", "%java%");
		courses = courseService.searchWhereCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
		
		map.clear();
		map.put("endDate", new Date());
		courses = courseService.searchWhereCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
		
		
	}
	
	
	@Test
	public void testSearchTrimCourses() {
		Map<String, Object> map = new HashMap<String, Object>();
		List<Course> courses = courseService.searchTrimCourses(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);			
		}
		
		map.put("tutorId", 1);
		courses = courseService.searchTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
		
		map.put("courseName", "%java%");
		courses = courseService.searchTrimCourses(map);
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}	
	}
	
	
	@Test
	public void testSearchForeachCoursesByTutors() {
		List<Integer> tutorIds = new ArrayList<Integer>();
		tutorIds.add(1);
		tutorIds.add(2);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tutorIds", tutorIds);
		
		List<Course> courses = courseService.searchForeachCoursesByTutors(map);
		
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
	}
	
	
	
}
