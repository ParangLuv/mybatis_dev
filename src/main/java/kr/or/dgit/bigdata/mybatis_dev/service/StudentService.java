package kr.or.dgit.bigdata.mybatis_dev.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Assert;

import kr.or.dgit.bigdata.mybatis_dev.dto.Student;
import kr.or.dgit.bigdata.mybatis_dev.mappers.StudentMapper;
import kr.or.dgit.bigdata.mybatis_dev.util.MyBatisSqlSessionFactory;

public class StudentService {
	private static final Logger logger = Logger.getLogger(StudentService.class);

	private final static StudentService instance = new StudentService();

	public static StudentService getInstance() {
		return instance;
	}

	private StudentService() {
	}

	public Student findStudentById(int studId){

		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start"); 
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try{

		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		return studentMapper.findStudentById(studId);

		}finally {
			sqlSession.close();
		}
	}
	
	public int insertStudent(Student student) {

		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.insertStudent(student);
			sqlSession.commit();
			return res;

		} finally {
			sqlSession.close();

		}

	}
	
	public int insertStudentAutoInc(Student student) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.insertStudentAutoInc(student);
			sqlSession.commit();
			return res;
			
		} finally {
			sqlSession.close();
			
		}
		
	}

	public int updateStudent(Student student) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.updateStudent(student);
			sqlSession.commit();
			return res;
			
		} finally {
			sqlSession.close();
			
		}
		
	}
	
	public int deleteStudent(int id) {
		
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.deleteStudent(id);
			sqlSession.commit();
			return res;
			
		} finally {
			sqlSession.close();
			
		}
		
	}
	
	public List<Student> findAllStudent() {
		
		if (logger.isDebugEnabled()) {
			logger.debug("findStudentById(int) - start");
		}
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudent();
		} finally {
			sqlSession.close();
			
		}
		
	}
	
	
	public Map<String, Object> findStudentByIdForMap(int stud_Id){
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findStudentByIdForMap(stud_Id);
		}finally{
			sqlSession.close();
		}
		
	}
	
	public List<Map<String, Object>> findAllStudentForMap(){
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.findAllStudentForMap();
		}finally{
			sqlSession.close();
		}
		
	}
	
	public Student selectStudentWithAddress(int studId){
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAddress(studId);
		}finally{
			sqlSession.close();
		}
		
	}
	
	public Student selectStudentWithAddressResult(int studId){
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try{
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			return studentMapper.selectStudentWithAddressResult(studId);
		}finally{
			sqlSession.close();
		}
		
	}
	
	public int updateSetStudent(Student student){
		
		SqlSession sqlSession = MyBatisSqlSessionFactory.openSession();
		
		try {
			StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
			int res = studentMapper.updateSetStudent(student);
			sqlSession.commit();
			return res;
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
			throw new RuntimeException(e.getCause());
		} finally{
			sqlSession.close();
		}
	}
	
}
