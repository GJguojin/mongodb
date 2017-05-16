package com.ji.mongodb.model;

import org.springframework.data.annotation.Id;

public class Document {
	
	@Id
	private String key;
	
	private byte[] file;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

}
