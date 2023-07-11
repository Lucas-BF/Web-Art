package com.example.demo.controller.view;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(path="/home")
public class MainControllerView {
	//Formar de retornar uma página via path
	
	//1
	@GetMapping() 
	public String page(){
		return "index";
	}
	
	//2
	@GetMapping("/something") 
	@ResponseBody
	public String page2(){
		return "index";
	}
	
	//3
	@GetMapping("/something2")
	public ResponseEntity<String> page3(){
		String body = "Hello world!";
		String etag = "oi";
		return ResponseEntity.ok().eTag(etag).body(body);
	}
	
	//Aula 05
	@PostMapping("/form")
	public String page4(@ModelAttribute User userMap){
		return "success";
	}
	
	//Aula 07?
	@GetMapping("/user/new")
	public String addUser() {
		return "addUser";
	}
}
