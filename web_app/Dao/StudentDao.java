package Dao;

import java.util.List;

import Model.Page;
import Model.Student;

public interface StudentDao {
	void delete(Student student);
	void update(Student student);
	Student selectOneStudent(Student student);
	List<Student> selectStudentList(Page page);
	void insert(Student student);
	int selectCount();
}
