package kr.or.dgit.bigdata.mybatis_dev;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import kr.or.dgit.bigdata.mybatis_dev.dto.Course;
import kr.or.dgit.bigdata.mybatis_dev.dto.Tutor;
import kr.or.dgit.bigdata.mybatis_dev.service.TutorService;

public class TutorServiceTest {
	private static TutorService tutorService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		tutorService = TutorService.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		tutorService = null;
	}

	@Test
	public void testFindTutorById() {
		Tutor tutor = tutorService.findTutorById(1);
		Assert.assertNotNull(tutor);
		List<Course> courses = tutor.getCourses();
		Assert.assertNotNull(courses);
		for(Course course : courses){
			Assert.assertNotNull(course);
		}
	}

}
