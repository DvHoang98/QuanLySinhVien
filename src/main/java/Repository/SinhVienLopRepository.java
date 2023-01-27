package Repository;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;

import Entities.ChuyenNganh;
import Entities.Lop;
import Entities.Mon;
import Entities.SinhVien;
import Entities.SinhVienLop;
import Utils.JpaUtil;

public class SinhVienLopRepository {

	EntityManager em;

	public SinhVienLopRepository() {
		em = JpaUtil.getEntityManager();
	}
	
	public void insert (SinhVienLop svl) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(svl);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void update (SinhVienLop svl) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge (svl);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void delete (SinhVienLop svl) throws Exception{
		try {
			em.getTransaction().begin();
			em.remove (svl);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public SinhVienLop findByAttribute(int idSv , int idLop) throws Exception{
		try {
			String jpql = "SELECT svl FROM SinhVienLop svl WHERE "
					+ "svl.sinhVien.id = ?1 AND svl.lop.id = ?2";
			TypedQuery<SinhVienLop> query =
				this.em.createQuery(jpql, SinhVienLop.class);
			query.setParameter(1, idSv);
			query.setParameter(2, idLop);
			return query.getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return null;
		}
	}
	
	public SinhVienLop findById (int id) {
		return em.find(SinhVienLop.class, id);
	}
	
	public void saveOrUpdate(SinhVienLop svl)throws Exception{
//		try {
//			em.getTransaction().begin();
//			em.persist(svl); 
//			em.getTransaction().commit();
//		} catch (EntityExistsException e) {
//			em.getTransaction().begin();
//			em.merge(svl); 
//			em.getTransaction().commit();
//		} catch (Exception e) {
//			em.getTransaction().rollback();
//		}
		
		Session session = em.unwrap(Session.class);
		try {
			session.saveOrUpdate(svl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<SinhVienLop> getAll(){
		String jpql = "SELECT cn FROM SinhVienLop cn";
		TypedQuery<SinhVienLop> query = em.createQuery(jpql,SinhVienLop.class);
		
		return query.getResultList();
	}

}
