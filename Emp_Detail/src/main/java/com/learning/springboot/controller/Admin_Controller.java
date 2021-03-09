package com.learning.springboot.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;

import com.learning.springboot.idao.IDAO;
import com.learning.springboot.model.UserModel;

@Controller
public class Admin_Controller {

	@Autowired 
	IDAO idao;
	
	@Autowired
	UserModel mainmodel;

	public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/webapp/imagedata";
	
	@GetMapping(value = "/")
	public ModelAndView getpage() {
		ModelAndView mv = new ModelAndView();
		  List<UserModel> detail = (List<UserModel>) idao.findAll();
		  mv.setViewName("index");
		  mv.addObject("details", detail);
			 
		  return mv;
	}
	@GetMapping("/addDetail")
	public String getaddDetail(Model mod) {
		UserModel model=new UserModel();
		mod.addAttribute("details", model);
		return "addDetail";
	}
	
	@PostMapping("/addDetail")
	public String postaddDetail(@ModelAttribute(name = "details")UserModel model,
			@RequestParam("fileimage") MultipartFile multipartFile) throws IOException {

		StringBuffer fileName=new StringBuffer();
		String filename=model.getName()+multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4);
		
		 Path fileNameAndPath=Paths.get(uploadDirectory,filename);
		 Files.write(fileNameAndPath,multipartFile.getBytes());
		 model.setUserphoto(filename);
		 idao.save(model);
		 
	return "redirect:/";
	}
	
	@GetMapping("/editbyid{id}")
	public String edituser(@PathVariable Long id,ModelMap mode) {
		Optional<UserModel>  mod=idao.findById(id);
		UserModel mod1=mod.get();
		mode.addAttribute("details", mod1);
		return "editbyid";
	}
	
	@PostMapping("/editbyid")
	public String pedituser(@ModelAttribute("details")UserModel mode)  {
		Optional<UserModel> data=idao.findById(mode.getId());
		UserModel m= data.get();
		if(data.isPresent()) {
			System.out.println(data);
			UserModel mod=new UserModel();
			mod.setId(m.getId());
			mod.setName(mode.getName());
			mod.setContact(mode.getContact());
			mod.setPost(mode.getPost());
			mod.setUserphoto(m.getUserphoto());
			idao.save(mod);
		}
		return "redirect:/"; 
	}  
	
	@RequestMapping("deletebyid{id}")
	public String deleteuser(@PathVariable Long id) {
		idao.deleteById(id);
		return "redirect:/"; 
	}
	
	@GetMapping("changephoto{id}")
	public String changeUserphoto(@PathVariable Long id,ModelMap mod) {
		Optional<UserModel>  model=idao.findById(id);
		UserModel mod1=model.get();
		mod.addAttribute("details", mod1);
		return "changephoto";
	}
	
	@PostMapping("changephoto")
	public String changeUserphot(@ModelAttribute(name = "details")UserModel model,
			@RequestParam("fileimage") MultipartFile multipartFile) throws IOException {
		Optional<UserModel> data=idao.findById(model.getId());
		UserModel m= data.get();
		if(data.isPresent()) {
			System.out.println(data);
			UserModel mod=new UserModel();
			mod.setId(m.getId());
			mod.setName(m.getName());
			mod.setContact(m.getContact());
			mod.setPost(m.getPost());
			
			
			StringBuffer fileName=new StringBuffer();
			String filename=model.getName()+multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().length()-4);
			
			 Path fileNameAndPath=Paths.get(uploadDirectory,filename);
			 Files.write(fileNameAndPath,multipartFile.getBytes());
			 model.setUserphoto(filename);
			 mod.setUserphoto(model.getUserphoto());
			 idao.save(mod);
			
		} 
	return "redirect:/";
	}
	 
}
