package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ProductoResponseDTO;
import com.example.demo.DTO.ProductosRequestDTO;
import com.example.demo.service.ProductosService;

@RestController
@RequestMapping("/producto/v1")
public class ProductosController {
	
	@Autowired
	private ProductosService service;
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar")
	public ResponseEntity<List<ProductoResponseDTO>>listar(){
		return new ResponseEntity<List<ProductoResponseDTO>>(service.listarProducto(),HttpStatus.OK);	
	}
	
	@RequestMapping(method = RequestMethod.POST, path = "/guardar")
	public ResponseEntity<Void> guardar(@RequestBody ProductosRequestDTO producto){
		service.guardarProductos(producto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/listar/{id}")
	public @ResponseBody ResponseEntity<ProductoResponseDTO> productById(@PathVariable Integer id){
		ProductoResponseDTO product = service.productoById(id);
		if(product != null) {
			return new ResponseEntity<ProductoResponseDTO>(product, HttpStatus.OK);

		}
		return new ResponseEntity<ProductoResponseDTO>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.DELETE, path = "/eliminar/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		ProductoResponseDTO product = service.productoById(id);
		if(product != null) {
			service.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping(method = RequestMethod.PUT, path = "/editar")
	public ResponseEntity<Void> editar(@RequestBody ProductosRequestDTO producto){
		ProductoResponseDTO product = service.productoById(producto.getIdProductorq());
		if(product != null) {
			service.editarProducto(producto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
