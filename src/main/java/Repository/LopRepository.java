package Repository;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Lop;
import Entities.SinhVien;
import Entities.SinhVienLop;
import Utils.JpaUtil;

public class LopRepository {

	EntityManager em;

	public LopRepository() {
		em = JpaUtil.getEntityManager();
	}
	
	public void insert (Lop lop) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(lop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void update (Lop lop) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge (lop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void delete (Lop lop) throws Exception{
		try {
			em.getTransaction().begin();
			em.remove (lop);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Lop> getAll (){
		String jpql = "SELECT l FROM Lop l";
		TypedQuery<Lop> query = em.createQuery(jpql,Lop.class);
		return query.getResultList();
	}
	
	public Lop findById (int id) {
		return em.find(Lop.class, id);
	}
	
	public List<SinhVienLop> getSinhVienInLop(int idLop){
		String jpql = "SELECT svl FROM SinhVienLop svl "
				+ "WHERE svl.lop.id = " +idLop;
		TypedQuery<SinhVienLop> query = em.createQuery(jpql,SinhVienLop.class);
//		query.setParameter(1, idLop);
		return query.getResultList();
	}
	
	public List<SinhVien> getSinhVienOutLop(int idLop){
		String nativeQuery = "select * from sinh_vien WHERE sinh_vien.id NOT IN "
				+ "( SELECT sinh_vien.id FROM sinh_vien INNER JOIN sinh_vien_lop ON sinh_vien.id = sinh_vien_lop.sinh_vien_id"
				+ " WHERE sinh_vien_lop.lop_id = "+idLop+" )";
		TypedQuery<SinhVien> query = (TypedQuery<SinhVien>) em.createNativeQuery(nativeQuery,SinhVien.class);
		return query.getResultList();
	}
	
	
	
}
