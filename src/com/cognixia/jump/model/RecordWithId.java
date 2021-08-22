package com.cognixia.jump.model;

import java.io.Serializable;

public abstract class RecordWithId implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	protected RecordWithId(Long id) {
		super();
		this.id = id;
	}
	
	public boolean hasId(Long id) {
		return (long) id == (long) this.id;
	}
	
	public Long getId() {
		return id;
	}
	
}
