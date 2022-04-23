package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Bodega;

@Repository
public interface BodegaRepository extends JpaRepository<Bodega, Integer>{
	

}
