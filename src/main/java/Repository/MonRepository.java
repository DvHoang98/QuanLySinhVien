package Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Entities.Mon;
import Utils.JpaUtil;

public class MonRepository {

	EntityManager em;

	public MonRepository() {
		em = JpaUtil.getEntityManager();
	}
	
	public void insert (Mon mon) throws Exception{
		try {
			em.getTransaction().begin();
			em.persist(mon);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void update (Mon mon) throws Exception{
		try {
			em.getTransaction().begin();
			em.merge (mon);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public void delete (Mon mon) throws Exception{
		try {
			em.getTransaction().begin();
			em.remove (mon);
			em.getTransaction().commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			em.getTransaction().rollback();
			throw e;
		}
	}
	
	public List<Mon> getAll (){
		String jpql = "SELECT l FROM Mon l";
		TypedQuery<Mon> query = em.createQuery(jpql,Mon.class);
		return query.getResultList();
	}
	
	public Mon findById (int id) {
		return em.find(Mon.class, id);
	}
	
}
