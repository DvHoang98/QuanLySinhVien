package Models;

public class ChuyenNganhModel {
	private int id;
	private String ten;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public ChuyenNganhModel(int id, String ten) {
		super();
		this.id = id;
		this.ten = ten;
	}
	public ChuyenNganhModel() {
		super();
	}
	@Override
	public String toString() {
		return "ChuyenNganh [id=" + id + ", ten=" + ten + "]";
	}
	
	
}
