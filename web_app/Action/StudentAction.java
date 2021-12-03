package Action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import Exception.NotFindException;
import Model.ListShow;
import Model.Page;
import Model.Student;
import Service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentAction{
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/{id}",method = RequestMethod.POST )
	public @ResponseBody Student getStudent(@PathVariable("id") Integer id){
		Student student =  new Student();
		student.setId(id);
		student  = studentService.findOne(student);
		if(student==null)
			throw new NotFindException();
		return studentService.findOne(student);
	}
	
	@RequestMapping(value = "/{id}",method = RequestMethod.GET )
	public String getStudent2(@PathVariable("id") Integer id,Model model){
		Student student =  new Student();
		student.setId(id);
		student  = studentService.findOne(student);
		if(student==null)
			throw new NotFindException();
		model.addAttribute("student", student);
		return "JSP/student";
	}
	
	//利用ajax更新
	@RequestMapping(value = "/{id}",method = RequestMethod.PUT )
	public  @ResponseBody String update(@PathVariable("id") Integer id,
			@RequestBody Student student){
		student.setId(id);
		studentService.updateOne(student);
		return "success";
	}
	
	//利用ajax删除
	@RequestMapping(value = "/{id}",method = RequestMethod.DELETE )
	public @ResponseBody String delete(@PathVariable("id") Integer id){
			Student student = new Student();
			student.setId(id);
			studentService.deleteOne(student);
			return "success";
	}
	
	
	@RequestMapping(value="/list" )
	public String  getList(Page page,Model model){
		if(page.getFirstResult()==null) page.setFirstResult(0);
		if(page.getMaxResult()==null) page.setMaxResult(20);
		List<Student> list = null;
		//在service层对Page进行逻辑判断
		list = studentService.findList(page);
		if(list==null&&list.size()==0)
			throw new NotFindException();
		ListShow ls =  new ListShow();
		ls.setList(list);ls.setPage(page);
		model.addAttribute("showList", ls);
		return "index";
	} 
	
}
