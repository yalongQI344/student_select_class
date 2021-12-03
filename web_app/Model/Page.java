package Model;

public class Page {
	private Integer currentPage;//当前页数
	private Integer firstResult;//
	private Integer maxResult;//
	private Integer count;//记录总数
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public Integer getFirstResult() {
		return firstResult;
	}
	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}
	public Integer getMaxResult() {
		return maxResult;
	}
	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Page [currentPage=" + currentPage + ", firstResult=" + firstResult + ", maxResult=" + maxResult
				+ ", count=" + count + "]";
	}
	
}
