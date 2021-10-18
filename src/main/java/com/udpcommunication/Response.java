package com.udpcommunication;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class Response implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte response_status;
	private Object response_object;
	
	public Response(byte respone_status) {
		this.response_status = respone_status;
	}
	
	public Response(byte respone_status,Object respone_object) {
		this.response_status = respone_status;
		this.response_object = respone_object;
	}
	
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

	
	
}
