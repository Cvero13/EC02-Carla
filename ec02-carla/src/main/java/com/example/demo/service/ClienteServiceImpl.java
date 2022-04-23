package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ClienteRequestDTO;
import com.example.demo.DTO.ClienteResponseDTO;
import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Override
	public void guardarCliente(ClienteRequestDTO c) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setIdCliente(c.getIdClienterq());
		cliente.setNombre(c.getNombreClienterq());
		cliente.setDireccion(c.getDireccionClienterq());
		cliente.setDni(c.getDniClienterq());
		
		repository.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarCliente(ClienteRequestDTO c) {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		
		cliente.setIdCliente(c.getIdClienterq());
		cliente.setNombre(c.getNombreClienterq());
		cliente.setDni(c.getDniClienterq());
		cliente.setDireccion(c.getDireccionClienterq());
	}

	@Override
	public List<ClienteResponseDTO> listarCliente() {
		// TODO Auto-generated method stub
		List<Cliente> cliente = repository.findAll();
		
		List<ClienteResponseDTO> dto = new ArrayList<ClienteResponseDTO>();
		ClienteResponseDTO clienteDto = null;
		
		for (Cliente clientes : cliente) {
			clienteDto = new ClienteResponseDTO();
			
			clienteDto.setIdClienterp(clientes.getIdCliente());
			clienteDto.setNombreClienterp(clientes.getNombre());
			clienteDto.setDireccionClienterp(clientes.getDireccion());
			clienteDto.setDniClienterp(clientes.getDni());
			
			dto.add(clienteDto);
		}
		return dto;
	}

	@Override
	public ClienteResponseDTO clienteById(Integer id) {
		// TODO Auto-generated method stub
		Cliente cliente = repository.findById(id).orElse(null);
		ClienteResponseDTO clienteDto = new ClienteResponseDTO();
		
		clienteDto = new ClienteResponseDTO();	
		clienteDto.setIdClienterp(cliente.getIdCliente());
		clienteDto.setNombreClienterp(cliente.getNombre());
		clienteDto.setDniClienterp(cliente.getDni());
		clienteDto.setDireccionClienterp(cliente.getDireccion());

		return clienteDto;
	}

}
