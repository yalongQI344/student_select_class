package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import Dao.StudentDao;
import Model.Page;
import Model.Student;

@Service
public class StudentServiceImp implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	//开启事务
//	@Transactional(isolation=Isolation.READ_COMMITTED
//			,propagation=Propagation.REQUIRED)
	public Student findOne(Student student) {
		return studentDao.selectOneStudent(student);
	}
	
	
	public List<Student> findList(Page page) {
		check(page);
		return studentDao.selectStudentList(page);
	}
	
	public void selectCount(Page page) {
		// TODO Auto-generated method stub
		page.setCount(studentDao.selectCount());
	}
	
//对页数进行逻辑判断
	private void check(Page page ){
		selectCount(page);
		int i = page.getFirstResult();
		if(i>page.getCount()){
			page.setFirstResult(i-page.getMaxResult());
			page.setCurrentPage((page.getFirstResult()+page.getMaxResult())/20);
			return;
		}
		if(i<=0){
			page.setCurrentPage(1);
			page.setFirstResult(0);
		}
	}
	
	@Transactional(isolation=Isolation.READ_COMMITTED
			,propagation=Propagation.REQUIRED)
	public void deleteOne(Student student) {
		// TODO Auto-generated method stub
		studentDao.delete(student);
	}

	@Transactional(isolation=Isolation.READ_COMMITTED
			,propagation=Propagation.REQUIRED)
	public void updateOne(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}

}
