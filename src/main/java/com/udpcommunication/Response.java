package com.udpcommunication;

import java.io.Serializable;

public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte response_status;
	private Object response_object;
	
	public byte getResponse_status() {
		return response_status;
	}

	public void setResponse_status(byte response_status) {
		this.response_status = response_status;
	}

	public Object getResponse_object() {
		return response_object;
	}

	public void setResponse_object(Object response_object) {
		this.response_object = response_object;
	}

	public Response(byte response_status, Object response_object) {
		this.response_status = response_status;
		this.response_object = response_object;
	}
	
	
}
