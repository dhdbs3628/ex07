package com.example.controller;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@Resource(name="uploadPath")
	private String path;
	
	@RequestMapping("formUpload")
	public void uploadForm(){
		
	}
	
	@RequestMapping("ajaxUpload")
	public void uploadAjax(){
		
	}
	
	@RequestMapping(value="formUpload", method=RequestMethod.POST)
	public void uploadFormPost(MultipartFile file)throws Exception{
		System.out.println("upload............");
		System.out.println("path.........." + path);
		
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString() + "_" + file.getOriginalFilename();
		System.out.println("파일명:" + savedName);
		
		File target = new File(path, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
	}
	
	@ResponseBody
	@RequestMapping(value="uploadFile", method=RequestMethod.POST)
	public String uploadAjax(MultipartFile file)throws Exception{
		UUID uid=UUID.randomUUID();
		String savedName=uid.toString() + "_" + file.getOriginalFilename();
		System.out.println("파일명:" + savedName);
		
		File target = new File(path, savedName);
		FileCopyUtils.copy(file.getBytes(), target);
		return savedName;
	}
	
	//파일삭제
	@ResponseBody
	@RequestMapping(value="deleteFile", method=RequestMethod.POST)
	public void deleteFile(String fileName){
		new File(path + "/" + fileName).delete();
	}
	
	//이미지파일 보기
	@ResponseBody
	@RequestMapping("displayFile")
	public byte[] displayFile(String fileName)throws Exception{
		FileInputStream in=new FileInputStream(path + "/" + fileName);
		byte[] image=IOUtils.toByteArray(in);
		in.close();
		return image;
	}
}







