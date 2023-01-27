package Entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the lop database table.
 * 
 */
@Entity
@NamedQuery(name="Lop.findAll", query="SELECT l FROM Lop l")
public class Lop implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

//	@Column(name="chuyen_nganh_id")
//	private int chuyenNganhId;
	
	@ManyToOne
	@JoinColumn(name="chuyen_nganh_id")
	private ChuyenNganh chuyenNganh;
	
	private int khoa;

	@OneToMany(mappedBy="lop")
	private List<SinhVienLop> dsSinhVien;
	
//	@Column(name="mon_id")
//	private int monId;
	
	public Mon getMon() {
		return mon;
	}

	public void setMon(Mon mon) {
		this.mon = mon;
	}

	@ManyToOne
	@JoinColumn(name ="mon_id")
	private Mon mon;

	private String ten;

	public Lop() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public int getChuyenNganhId() {
//		return this.chuyenNganhId;
//	}
//
//	public void setChuyenNganhId(int chuyenNganhId) {
//		this.chuyenNganhId = chuyenNganhId;
//	}
	
	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public int getKhoa() {
		return this.khoa;
	}

	public void setKhoa(int khoa) {
		this.khoa = khoa;
	}

	public String getTen() {
		return this.ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

}