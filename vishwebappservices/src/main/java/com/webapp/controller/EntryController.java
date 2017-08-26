package com.webapp.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.webapp.daoimpl.CategoryDaoImpl;
import com.webapp.daoimpl.SupplierDaoImpl;
import com.webapp.dto.ProductCategory;
import com.webapp.dto.Supplier;
import com.webapp.response.AppResponse;

@Controller("entryController")
public class EntryController implements ApplicationContextAware{
	
	/*@Autowired
	SupplierDaoImpl supplierDaoImpl;*/
	
	private ApplicationContext applicationContext;
	
	//Get Supplier Service
	@RequestMapping(method = RequestMethod.GET ,value="/supplier-details", produces = "application/json")
	@ResponseBody
	public AppResponse getSupplierDetails(@RequestParam(value="id",required=false) String id) {
		AppResponse<Supplier> response = new AppResponse();
		SupplierDaoImpl supplierDaoImpl = (SupplierDaoImpl)getBean("supplierDaoImpl");
		response.setData(supplierDaoImpl.getSuppliers());
		return response;
	}
	
	//Get Product Categories Service With Hibernate
	@RequestMapping(method = RequestMethod.GET ,value="/product-categories", produces = "application/json")
	@ResponseBody
	public AppResponse getProductCategories() {
		AppResponse<ProductCategory> response = new AppResponse();
		CategoryDaoImpl categoryDaoImpl = (CategoryDaoImpl)getBean("categoryDaoImpl");
		response.setData(categoryDaoImpl.getAllCategories());
		return response;
	}
	
	
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		applicationContext = context;
	}
	
	public Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

}
