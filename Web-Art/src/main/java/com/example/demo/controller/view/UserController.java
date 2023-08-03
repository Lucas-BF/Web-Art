package com.example.demo.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping(path="/user")
public class UserController {
	@Autowired
	private UserService service;
	
	@GetMapping("/")
	public String template() {
		return "template";
	}
	
	@PostMapping("/add")
	@ResponseBody
	public String addUser(@ModelAttribute User user) {
		User ret = service.adicionarUsuario(user);
		return "Usuario " + ret.getUsername() + " Criado";
	}
	
	public String editUser(@ModelAttribute User user) {
		User ret = service.editarUsuario(user);
		return "Usuario " + ret.getUsername() + " Editado";
	}
	
	public String deleteUser(Long ID) {
		service.deletarUsuario(ID);
		return "Usuario do Id" + ID + " Deletado";
	}
}