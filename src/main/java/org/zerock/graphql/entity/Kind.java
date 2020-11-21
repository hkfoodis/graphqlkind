package org.zerock.graphql.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "kind")
public class Kind implements Serializable {

	private static final long serialVersionUID = -2054386655979281969L;
	
	@Id
	@Column(name = "Kind_code", length = 20, nullable = false)
	private String kind_code;
	
	@Column(name = "Kind_name", length = 20)
	private String kind_name;
	
	public Kind() {
		
	}
	
	public String getKind_code() {
		return kind_code;
	}
	
	public void setKind_code(String kind_code) {
		this.kind_code = kind_code;
	}
	
	public String getKind_name() {
		return kind_name;
	}
	
	public void setKind_name(String kind_name) {
		this.kind_name = kind_name;
	}
}
