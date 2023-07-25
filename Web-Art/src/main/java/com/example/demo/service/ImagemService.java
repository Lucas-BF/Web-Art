package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Imagem;
import com.example.demo.repository.ImagemRepository;

@Service
public class ImagemService {

	@Autowired
	private ImagemRepository repi;
	
	public Imagem adicionarImagem(Imagem imagem) {
        return repi.save(imagem);
    }

	public Imagem editarImagem(Imagem imagem) {
        return repi.save(imagem);
    }
    public void deletarImagem(Long ImagemId) {
    	repi.deleteById(ImagemId);
    }
	
}