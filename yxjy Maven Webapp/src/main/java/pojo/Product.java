package pojo;

public class Product {
	private Integer pid;
	private String pname;
	private String pimg;
	private String pdesc;
	private int isOk;
	private String ppay;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public int getIsOk() {
		return isOk;
	}
	public void setIsOk(int isOk) {
		this.isOk = isOk;
	}
	public String getPpay() {
		return ppay;
	}
	public void setPpay(String ppay) {
		this.ppay = ppay;
	}
	@Override
	public String toString() {
		return "product [pid=" + pid + ", pname=" + pname + ", pimg=" + pimg
				+ ", pdesc=" + pdesc + ", isOk=" + isOk + ", ppay=" + ppay
				+ "]";
	}
	
}
