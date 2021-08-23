package com.cognixia.jump.model;

import java.io.Serializable;

import com.cognixia.jump.utility.display.Display;

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
	
	public String getDisplayId() {
		String idString = "" + id;
		if (idString.length() < 4) {
			idString = Display.createRepeatCharString('0', 4 - idString.length()) + idString;
		}
		return "#" + idString;
	}
	
}
