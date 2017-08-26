package com.webapp.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.webapp.dto.Supplier;
@Component("supplierDaoImpl")
public class SupplierDaoImpl {
	
	public JdbcTemplate template;  
	
	public void setTemplate(JdbcTemplate template) {  
	    this.template = template;  
	}  
	public List<Supplier> getSuppliers(){  
	    return template.query("SELECT * FROM supplier_details",new RowMapper<Supplier>(){  
	        public Supplier mapRow(ResultSet rs, int row) throws SQLException {  
	        	Supplier e=new Supplier();  
	           e.setSupplierID(rs.getInt("SUPPLIER_ID"));
	           e.setSupplierName(rs.getString("SUPPLIER_NAME"));
	           e.setCity(rs.getString("CITY"));
	           e.setComments(rs.getString("COMMENTS"));
	           e.setEmailId(rs.getString("EMAIL"));
	           e.setMVAT(rs.getString("MVAT"));
	           e.setPanNo(rs.getString("PAN_NO"));
	           e.setSupplierMobile(rs.getLong("MOBILE"));
	           e.setSupplierAddress(rs.getString("ADDRESS"));
	            return e;  
	        }  
	    });  
	}  
}
