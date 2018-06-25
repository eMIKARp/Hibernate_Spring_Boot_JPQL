package pl.myapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import pl.myapp.model.Product;

@Repository
@Transactional
public class ProductDao {

	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}
	
	public Product get(Long id) {
		return em.find(Product.class, id);
	}
	
	public void save(Product product) {
		em.persist(product);
	}
	
	public List<Product> getAll(){
		
		TypedQuery<Product> getAllQuery = em.createNamedQuery("Product.findAll", Product.class);
		List<Product> resultList = getAllQuery.getResultList();
		
		return resultList;
	}
	
	public void deleteAll(){
		TypedQuery<Product> deleteAllQuery = em.createNamedQuery("Product.deleteAll", Product.class);
		deleteAllQuery.executeUpdate();
	}
	
	public List<Product> customGet(String jpqlQuery){
		TypedQuery<Product> customGetQuery = em.createQuery(jpqlQuery, Product.class);
		return customGetQuery.getResultList();
	}
	
	public List<Product> getByName(String name){
		TypedQuery<Product> getByNameQuery = em.createQuery("Product.findByName", Product.class);
		getByNameQuery.setParameter("name", name);
		List<Product> resultList = getByNameQuery.getResultList();
		return resultList;
	}
	
	public void deleteByProducer(String producer) {
		TypedQuery<Product> deleteByProducerQuery = em.createQuery("Product.deleteByProducer", Product.class);
		deleteByProducerQuery.setParameter("producer", producer);
		deleteByProducerQuery.executeUpdate();
	}
	
}
