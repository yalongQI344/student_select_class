package Action;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import Exception.NotFindException;

@ControllerAdvice
public class ExceptionAdvice {
	@ExceptionHandler(NotFindException.class)
	public String isNotFindExcption(Exception e,Model model){
		model.addAttribute("message", e.getMessage());
		return "JSP/exception";
	}
}
