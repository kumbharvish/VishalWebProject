package com.webapp.response;

import java.io.Serializable;
import java.util.List;

public class AppResponse<T> {
	
	List<T> data;

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

}
