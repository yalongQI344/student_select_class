package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import Model.Page;
import Model.Student;
@Repository("studentDaoImp")
public class StudentDaoImp implements StudentDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void delete(Student student) {
		// TODO Auto-generated method stub
		int id = student.getId();
		String sql = "delete from stu_student where id = ?";
		jdbcTemplate.update(sql, id);
	}

	public void update(Student student) {
		// TODO Auto-generated method stub
		String sql = "update stu_student set name = ?,age = ?,major = ?"
				+ ",classRoom = ? where id = ?";
		jdbcTemplate.update(sql, student.getName(),
				student.getAge(),student.getMajor(),student.getClassRoom()
				,student.getId());
	}

	public Student selectOneStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "select * from stu_student where id = ?";
		try {
			return  jdbcTemplate.queryForObject(sql,
					new BeanPropertyRowMapper(Student.class) ,student.getId());
		} catch (Exception e) {
			return null;
		}
	}

	public List<Student> selectStudentList(Page page) {
		// TODO Auto-generated method stub
		String sql = "select * from stu_student limit ?,?";
		List<Student> list = null;
		list = jdbcTemplate.query(sql, 
				new Object[]{page.getFirstResult(),page.getMaxResult()},
				new BeanPropertyRowMapper(Student.class));
		return list;
	}

	public void insert(Student student) {
		// TODO Auto-generated method stub
		
	}

	public int selectCount() {
		// TODO Auto-generated method stub
		String countSql = "select count(*) from stu_student";
		return jdbcTemplate.queryForObject(countSql, int.class);
	}

}
