package com.example.demo.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Imagem;
import com.example.demo.service.ImagemService;

@Controller
@RequestMapping(path="/img")
public class ImagemController {
	@Autowired
	private ImagemService service;
	
	@PostMapping("/add")
	@ResponseBody
	public String addImagem(@ModelAttribute Imagem imagem) {
		Imagem ret = service.adicionarImagem(imagem);
		return "Imagem " + ret.getNome() + " Criado";
	}
	
	public String editImagem(@ModelAttribute Imagem imagem) {
		Imagem ret = service.editarImagem(imagem);
		return "Usuario " + ret.getNome() + " Editado";
	}
	
	public String deleteImagem(Long ID) {
		service.deletarImagem(ID);
		return "Usuario do Id" + ID + " Deletado";
	}
}