package com.learning.springboot.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.learning.springboot.model.User_Model;

@Service
public class IDAO_Imp {

	@Autowired
	IDAO dao;
	
	public User_Model savefile(MultipartFile file) {
		String getfilename=file.getOriginalFilename();
		try {
				User_Model model=new User_Model(getfilename,file.getContentType(),file.getBytes());
				return dao.save(model);
		}
		catch(Exception e) {
			System.out.println("Error "+e);
		}
		return null;
	}
	
	public Optional<User_Model> getfile(int id) {
		return dao.findById(id);
	}
	
	public List<User_Model> getfile(){
		return dao.findAll();
	}
}
