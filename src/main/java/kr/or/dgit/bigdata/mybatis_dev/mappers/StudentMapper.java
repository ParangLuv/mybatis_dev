package kr.or.dgit.bigdata.mybatis_dev.mappers;

import java.util.List;
import java.util.Map;

import kr.or.dgit.bigdata.mybatis_dev.dto.Student;

public interface StudentMapper {
	Student findStudentById(int id);
	List<Student> findAllStudent();
	
	Map<String, Object> findStudentByIdForMap(int id);
	List<Map<String, Object>> findAllStudentForMap();
	
	int insertStudent(Student student);
	int insertStudentAutoInc(Student student);
		
	int updateStudent(Student student);
	
	int deleteStudent(int id);
	
	//////////// Join&Expand /////////////
	Student selectStudentWithAddress(int id);
	
}
