package Service;

import java.util.List;

import Model.Page;
import Model.Student;

public interface StudentService {
	
	Student findOne(Student student);
	List<Student> findList(Page page);
	void selectCount(Page page);
	void deleteOne(Student student);
	void updateOne(Student student);
}
