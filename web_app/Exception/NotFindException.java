package Exception;

public class NotFindException extends RuntimeException{
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return "不存在ID";
	}
}
