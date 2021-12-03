package Model;

import java.util.List;

public class ListShow {
	private Page page;
	private List<Student> list;
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public List<Student> getList() {
		return list;
	}
	public void setList(List<Student> list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "ListShow [page=" + page + ", list=" + list + "]";
	}
	
}
