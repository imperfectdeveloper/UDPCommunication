package com.udpcommunication;

import java.io.Serializable;

public class Command implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private byte command_number;
	public byte getCommand_number() {
		return command_number;
	}

	public void setCommand_number(byte command_number) {
		this.command_number = command_number;
	}

	public Object getParameter_object() {
		return parameter_object;
	}

	public void setParameter_object(Object parameter_object) {
		this.parameter_object = parameter_object;
	}

	private Object parameter_object;
	
	public Command(byte command_number) {
		this.command_number = command_number;
	}
	
	public Command(byte command_number, Object parameter_object) {
		this.command_number=command_number;
		this.parameter_object=parameter_object;
	}
}
