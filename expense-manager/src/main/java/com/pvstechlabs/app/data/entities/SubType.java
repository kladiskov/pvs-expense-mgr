package com.pvstechlabs.app.data.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubType {
	
	@Column(name="SUBTYPE_NAME")
	private String subTypeName;


	public String getSubTypeName() {
		return subTypeName;
	}

	public void setSubTypeName(String subTypeName) {
		this.subTypeName = subTypeName;
	}

}
