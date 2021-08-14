package com.cognixia.jump.model;

public abstract class RecordWithId {
	
	private Long id;
	
	public boolean hasId(Long id) {
		return (long) id == (long) this.id;
	}
	
	public Long getId() {
		return id;
	}
	
}
