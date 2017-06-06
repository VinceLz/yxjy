package pojo;

public class Address {
	private int sid;
	private String address;
	private String phone;
	private String weixing;
	private String qq;
	private String code;
	private String shopAddress;
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getWeixing() {
		return weixing;
	}
	public void setWeixing(String weixing) {
		this.weixing = weixing;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	@Override
	public String toString() {
		return "Address [address=" + address + ", phone=" + phone
				+ ", weixing=" + weixing + ", qq=" + qq + ", code=" + code
				+ ", shopAddress=" + shopAddress + "]";
	}
	

}
