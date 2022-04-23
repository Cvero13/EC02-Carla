package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BodegaRequestDTO;
import com.example.demo.DTO.BodegaResponseDTO;
import com.example.demo.DTO.ClienteResponseDTO;
import com.example.demo.model.Bodega;
import com.example.demo.model.Cliente;
import com.example.demo.repository.BodegaRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	private BodegaRepository repository;
	
	@Override
	public void guardarBodega(BodegaRequestDTO b) {
		// TODO Auto-generated method stub
		Bodega bodega = new Bodega();
		bodega.setIdBodega(b.getIdBodegarq());
		bodega.setNombre(b.getNombreBodegarq());
		bodega.setDireccion(b.getDireccionBodegarq());
		
		repository.save(bodega);
	}

	@Override
	public void eliminarBodega(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void editarBodega(BodegaRequestDTO b) {
		// TODO Auto-generated method stub
		Bodega bodega = new Bodega();
		
		bodega.setIdBodega(b.getIdBodegarq());
		bodega.setNombre(b.getNombreBodegarq());
		bodega.setDireccion(b.getDireccionBodegarq());
		
	}

	@Override
	public List<BodegaResponseDTO> listarBodega() {
		// TODO Auto-generated method stub
		List<Bodega> bodega = repository.findAll();
		
		List<BodegaResponseDTO> dto = new ArrayList<BodegaResponseDTO>();
		BodegaResponseDTO bodegaDto = null;
		
		for (Bodega bodegas : bodega) {
			bodegaDto = new BodegaResponseDTO();
			
			bodegaDto.setIdBodegarp(bodegas.getIdBodega());
			bodegaDto.setNombreBodegarp(bodegas.getNombre());
			bodegaDto.setDireccionBodegarp(bodegas.getDireccion());
			
			dto.add(bodegaDto);
		}
		return dto;
	}

	@Override
	public BodegaResponseDTO bodegaById(Integer id) {
		// TODO Auto-generated method stub
		Bodega bodega = repository.findById(id).orElse(null);
		BodegaResponseDTO bodegaDto = new BodegaResponseDTO();
		
		bodegaDto = new BodegaResponseDTO();	
		bodegaDto.setIdBodegarp(bodega.getIdBodega());
		bodegaDto.setNombreBodegarp(bodega.getNombre());
		bodegaDto.setDireccionBodegarp(bodega.getDireccion());

		return bodegaDto;
	}

}
