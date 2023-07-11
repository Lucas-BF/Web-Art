package com.example.demo.controller.apirest;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping(path = "/api")
public class MainRestController {
	// Aula 07
	@Autowired
	private UserRepository res;
	
	//Aula 03
	// Retornar um dado simples para um requisição
	@GetMapping
	public String initial() {
		return "Olá, welcome to my app API!";
	}

	// Obter um parâmetro via requisição (path)
	@GetMapping("/cliente/{id}")
	public String page1(@PathVariable("id") int id) {
		return "Olá, o seu id é: " + id;
	}
	
	// Obter um parâmetro via requisição (request)
	@GetMapping("/{id}")
	public String page2(@PathVariable("id") int id, @RequestParam("nome") String nome) {
		return "Olá, mundo! id: " + id + ", nome do cara: " + nome;
	}
	
	// Obter vários parâmetros via requisição (request)
	@PostMapping("/foos")
	@ResponseBody
	public String page3(@RequestParam Map<String, String> allParams) {
		return "Olá, pega e não solta: " + allParams.entrySet();
	}
	
	//Aula 04
	// Validar campos enviados via body request
	@PostMapping("/user/register")
	@ResponseStatus(HttpStatus.CREATED)
	public Map<String, String> registerUser(@RequestBody Map<String, String> userMap) {
		try {
			if(userMap.get("id") == null) 		throw new Exception("Campo id não encontrado!");
			if(userMap.get("username") == null) throw new Exception("Campo nome do usuário não encontrado!");
			if(userMap.get("password") == null) throw new Exception("Campo senha não encontrado!");
			
			System.out.println("User ID: "   + userMap.get("id"));
			System.out.println("User name: " + userMap.get("username"));
			System.out.println("Password: "  + userMap.get("password"));
			
			return userMap;
		} catch (Exception err) {
			System.out.println("Erro ao registrar usuário: " + err);
			return null;
		}
	}
	
	// Simular acesso ao banco de dados
	@GetMapping("/user/{id}")
	public ResponseEntity<?> login(@PathVariable("id") int id) {
		//Optional<Ativo> ativo = repo.findById(id);
		if(id == 123) {
			return ResponseEntity.ok().header("Content-Type", "application/json").body("Vini linguição"); //ativo.get()
		} else {
			return ResponseEntity.notFound().header("Content-Type", "text/html").build();
		}
	}
	
	// Acessar dados de uma classe via body request
	@RequestMapping(value = "/user/register2", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public User registerUser(@ModelAttribute User userMap) {
		try {
			if(userMap.getId() == null) 	  throw new Exception("Campo id não encontrado!");
			if(userMap.getUsername() == null) throw new Exception("Campo nome do usuário não encontrado!");
			
			System.out.println("User ID: "   + userMap.getId());
			System.out.println("User name: " + userMap.getUsername());
			
			return userMap;
		} catch (Exception err) {
			System.out.println("Erro ao registrar usuário: "  + err);
			return null;
		}
	}
	
	// Aula 07?
	@PostMapping("/add")
	public String addUser2(@RequestBody User user) throws Exception {
		System.out.println("User: "   + user.getUsername());
		try {
			User userResult = res.save(user);
			return "Usuário adicionado: " + userResult.getId();
		} catch (Exception error) {
			return "Erro ao salvar o usuário: " + error;
		}
	}
}