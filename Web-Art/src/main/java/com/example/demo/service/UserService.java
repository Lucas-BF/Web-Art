package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repu;
	
	public User adicionarUsuario(User user) {
        return repu.save(user);
    }

	public User editarUsuario(User user) {
        return repu.save(user);
    }
    public void deletarUsuario(Long userId) {
    	repu.deleteById(userId);
    }
	
}
