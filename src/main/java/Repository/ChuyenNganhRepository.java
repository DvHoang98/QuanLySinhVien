package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.ChuyenNganh;
import Utils.JpaUtil;

public class ChuyenNganhRepository {

	private EntityManager em;

	public ChuyenNganhRepository() {
		em = JpaUtil.getEntityManager();
	}
	
	public void insert (ChuyenNganh cn ) throws Exception {
		
		try {
			em.getTransaction().begin();
			em.persist(cn);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
		
	}
	
	public void update ( ChuyenNganh cn) throws Exception{
		
		try {
			em.getTransaction().begin();
			em.merge(cn);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void delete(ChuyenNganh cn) throws Exception{
		
		try {
			em.getTransaction().begin();
			em.remove(cn);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
		
	}
	
	public List<ChuyenNganh> getAll(){
		String jpql = "SELECT cn FROM ChuyenNganh cn";
		TypedQuery<ChuyenNganh> query = em.createQuery(jpql,ChuyenNganh.class);
		
		return query.getResultList();
	}
	
	public ChuyenNganh findById(int id) {
		return em.find(ChuyenNganh.class, id);
	}
	
}
