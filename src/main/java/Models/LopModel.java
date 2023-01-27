package Models;

public class LopModel {

	private int id;
	private String ten;
	private int monId;
	private int chuyenNganhId;
	private int khoa;
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
	public int getMonId() {
		return monId;
	}
	public void setMonId(int monId) {
		this.monId = monId;
	}
	public int getChuyenNganhId() {
		return chuyenNganhId;
	}
	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
	}
	public int getKhoa() {
		return khoa;
	}
	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}
	public LopModel(int id, String ten, int monId, int chuyenNganhId, int khoa) {
		super();
		this.id = id;
		this.ten = ten;
		this.monId = monId;
		this.chuyenNganhId = chuyenNganhId;
		this.khoa = khoa;
	}
	public LopModel() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Lop [id=" + id + ", ten=" + ten + ", monId=" + monId + ", chuyenNganhId=" + chuyenNganhId + ", khoa="
				+ khoa + "]";
	}
	
	
	
	
	
}
