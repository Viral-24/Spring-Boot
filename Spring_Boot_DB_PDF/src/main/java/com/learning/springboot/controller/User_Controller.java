package com.learning.springboot.controller;

import org.springframework.http.HttpHeaders;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.learning.springboot.dao.IDAO_Imp;
import com.learning.springboot.model.User_Model;

@Controller
public class User_Controller {

	@Autowired
	IDAO_Imp imp;
	
	@GetMapping("/")
	public String  get(Model model) {
		List<User_Model> data=imp.getfile();
		model.addAttribute("data", data);
		return "index";
	}
	@PostMapping("/uploadfiles")
	public String upload(@RequestParam("files") MultipartFile files) {
		imp.savefile(files);
		return "redirect:/";
	}
	
	@GetMapping("/download/{id}")
	public ResponseEntity<ByteArrayResource> download(@PathVariable int id){
		User_Model model=imp.getfile(id).get();
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(model.getFiletype()))
				.header(HttpHeaders.CONTENT_DISPOSITION,"attachment:filename=\""+model.getFilename()+"\"")
				.body(new ByteArrayResource(model.getData()));
	}
}
