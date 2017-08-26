package com.webapp.dao;
import java.util.List;

import com.webapp.dto.ProductCategory;

public interface CategoryDao {
	
	public List<ProductCategory>getAllCategories();
}
