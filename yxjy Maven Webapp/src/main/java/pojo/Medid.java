package pojo;

public class Medid {
	private Integer mid;
	private int type;  //type 0 表示图片  1 表示视频
	private int pid;
	private String pname;
	private String url;
	private String mdate;
	
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Medid [mid=" + mid + ", type=" + type + ", pid=" + pid
				+ ", url=" + url + "]";
	}
	
	

}
