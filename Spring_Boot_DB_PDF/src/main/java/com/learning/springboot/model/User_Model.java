package com.learning.springboot.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "PDF_Demo")
public class User_Model {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String filename;
	private String filetype;
	
	@Lob
	private byte[] data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFiletype() {
		return filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public User_Model(String filename, String filetype, byte[] data) {
		super();
		this.filename = filename;
		this.filetype = filetype;
		this.data = data;
	}

	public User_Model() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User_Model [id=" + id + ", filename=" + filename + ", filetype=" + filetype + ", data="
				+ Arrays.toString(data) + "]";
	}
	
	
}
