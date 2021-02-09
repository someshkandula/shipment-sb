package com.somesh.airship.dto;

import java.io.Serializable;

/**
 * @author ksomalin
 *
 */
public class Response implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Meta MetaObject;
	Data DataObject;

	// Getter Methods

	public Meta getMeta() {
		return MetaObject;
	}

	public Data getData() {
		return DataObject;
	}

	// Setter Methods

	public void setMeta(Meta metaObject) {
		this.MetaObject = metaObject;
	}

	public void setData(Data dataObject) {
		this.DataObject = dataObject;
	}
}
