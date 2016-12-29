package kr.or.dgit.bigdata.mybatis_dev;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.bigdata.mybatis_dev.dto.PhoneNumber;
import kr.or.dgit.bigdata.mybatis_dev.dto.Student;
import kr.or.dgit.bigdata.mybatis_dev.service.StudentService;

public class StudentServiceTest {
	private static StudentService studentService;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		studentService = StudentService.getInstance();
	}	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		studentService = null;		
	}

	@Test
	public void testFindStudentById() {
		Student student = studentService.findStudentById(1);
		Assert.assertNotNull(student);
	}
	
	@Test
	public void insertStudent() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1980, 0, 1);
		
		Student insStd = new Student();
		insStd.setStudId(4);
		insStd.setName("박경아");
		insStd.setEmail("aa@aa.net");
		insStd.setPhone(new PhoneNumber("010-1111-1111"));
		insStd.setDob(cal.getTime());
		
		
		int res = studentService.insertStudent(insStd);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void insertStudentAutoInc() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1980, 0, 1);
		
		Student insStd = new Student();
		insStd.setName("박경아2");
		insStd.setEmail("aa2@aa.net");
		insStd.setPhone(new PhoneNumber("010-1111-1111"));
		insStd.setDob(cal.getTime());
		
		
		int res = studentService.insertStudent(insStd);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void updateStudent() {
		Calendar cal = Calendar.getInstance();
		cal.clear();
		cal.set(1980, 0, 1);
		
		Student insStd = new Student();
		insStd.setStudId(2);
		insStd.setName("최문영");
		insStd.setEmail("aa3@aa.net");
		insStd.setPhone(new PhoneNumber("010-1111-1111"));
		insStd.setDob(cal.getTime());
				
		int res = studentService.updateStudent(insStd);
		Assert.assertEquals(1, res);
	}
	
	@Test
	public void deleteStudent() {
		int deleteStudent = studentService.deleteStudent(10);
		Assert.assertEquals(1, deleteStudent);
	}
	
	@Test
	public void findAllStudent(){
		List<Student> students = studentService.findAllStudent();
		Assert.assertNotNull(students);
		for(Student student : students){
			Assert.assertNotNull(student);
			System.out.println(student);
		}
	}
	
	
	@Test
	public void findStudentByIdForMap(){
		Map<String, Object> students = studentService.findStudentByIdForMap(1);
		Assert.assertNotNull(students);
	}
	
	@Test
	public void findAllStudentForMap(){
		List<Map<String, Object>> students = studentService.findAllStudentForMap();
		Assert.assertNotNull(students);
		for(Map<String, Object> student : students){
			Assert.assertNotNull(student);
			System.out.println(student);
		}
	}
	
	
}
