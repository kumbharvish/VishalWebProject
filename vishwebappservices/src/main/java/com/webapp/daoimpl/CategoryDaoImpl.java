package com.webapp.daoimpl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.webapp.dao.CategoryDao;
import com.webapp.dto.ProductCategory;

public class CategoryDaoImpl implements CategoryDao {

	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public List<ProductCategory> getAllCategories() {
		//Criteria criteria = sessionFactory.openSession().createCriteria(ProductCategory.class);
		
		// Create CriteriaBuilder
		CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();

		// Create CriteriaQuery
		CriteriaQuery<ProductCategory> criteria2 = builder.createQuery(ProductCategory.class);
		criteria2.from(ProductCategory.class);
		
		return sessionFactory.openSession().createQuery(criteria2).getResultList();
       // return (List<ProductCategory>) criteria2.getre;
	}

}
