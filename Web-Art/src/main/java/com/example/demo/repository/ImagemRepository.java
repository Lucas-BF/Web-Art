package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Imagem;

@Repository
public interface ImagemRepository extends JpaRepository<Imagem, Long> {

}