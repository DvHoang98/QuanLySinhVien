package Models;

public class SinhVienModel {
	
	private int id;
	private String hoTen;
	private String email;
	private String sdt;
	private String diaChi;
	private int gioiTinh;
	private String password;
	private int chuyenNganhId;
	private String avatar;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getChuyenNganhId() {
		return chuyenNganhId;
	}
	public void setChuyenNganhId(int chuyenNganhId) {
		this.chuyenNganhId = chuyenNganhId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public SinhVienModel(int id, String hoTen, String email, String sdt, String diaChi, int gioiTinh, String password,
			int chuyenNganhId, String avatar) {
		super();
		this.id = id;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.diaChi = diaChi;
		this.gioiTinh = gioiTinh;
		this.password = password;
		this.chuyenNganhId = chuyenNganhId;
		this.avatar = avatar;
	}
	
	public SinhVienModel() {
		super();
	}
	@Override
	public String toString() {
		return "SinhVien [id=" + id + ", hoTen=" + hoTen + ", email=" + email + ", sdt=" + sdt + ", diaChi=" + diaChi
				+ ", gioiTinh=" + gioiTinh + ", password=" + password + ", chuyenNganhId=" + chuyenNganhId + ", avatar="
				+ avatar + "]";
	}
	
	
}
