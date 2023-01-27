package Models;

public class MonModel {

	private int id;
	private String ten;
	private int hocKy;
	private int soTinChi;
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
	public int getHocKy() {
		return hocKy;
	}
	public void setHocKy(int hocKy) {
		this.hocKy = hocKy;
	}
	public int getSoTinChi() {
		return soTinChi;
	}
	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}
	public MonModel(int id, String ten, int hocKy, int soTinChi) {
		super();
		this.id = id;
		this.ten = ten;
		this.hocKy = hocKy;
		this.soTinChi = soTinChi;
	}
	
	public MonModel() {
		super();
	}
	@Override
	public String toString() {
		return "Mon [id=" + id + ", ten=" + ten + ", hocKy=" + hocKy + ", soTinChi=" + soTinChi + "]";
	}
	
	
	
}
