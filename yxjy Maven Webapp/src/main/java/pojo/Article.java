package pojo;

public class Article {
	private Integer aid;
	private String atitle;
	private String acontent;
	private int pid;
	private int type; // type 0 表示文章 1 表示简介的文章 2 表示科普文章
	private String img;
	private String adate;
	private String author;
	private String pname;
	
	private String desc;
	
	private String tx1;
	private String tx2;
	private String tx3;
	
	public String getTx1() {
		return tx1;
	}

	public void setTx1(String tx1) {
		this.tx1 = tx1;
	}

	public String getTx2() {
		return tx2;
	}

	public void setTx2(String tx2) {
		this.tx2 = tx2;
	}

	public String getTx3() {
		return tx3;
	}

	public void setTx3(String tx3) {
		this.tx3 = tx3;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getAtitle() {
		return atitle;
	}

	public void setAtitle(String atitle) {
		this.atitle = atitle;
	}

	public String getAcontent() {
		return acontent;
	}

	public void setAcontent(String acontent) {
		this.acontent = acontent;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Article [aid=" + aid + ", atitle=" + atitle + ", acontent="
				+ acontent + ", pid=" + pid + ", type=" + type + ", img=" + img
				+ ", adate=" + adate + ", author=" + author + ", pname="
				+ pname + ", desc=" + desc + "]";
	}

	

}
