package com.pvstechlabs.app.data.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "EXPENSE_TYPE")
public class Type {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TYPE_ID")
	private long typeId;

	@Column(name = "TYPE_NAME")
	private String typeName;

	@ElementCollection
	@CollectionTable(name = "EXPENSE_SUBTYPE", joinColumns = @JoinColumn(name = "TYPE_ID"))
	@Column(name = "SUBTYPE_NAME")
	private List<SubType> subTypes = new ArrayList<>();

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<SubType> getSubtypes() {
		return subTypes;
	}

	public void setSubtypes(List<SubType> subTypes) {
		this.subTypes = subTypes;
	}

}
