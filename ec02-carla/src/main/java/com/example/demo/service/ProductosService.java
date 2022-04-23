package com.example.demo.service;

import java.util.List;

import com.example.demo.DTO.ProductoResponseDTO;
import com.example.demo.DTO.ProductosRequestDTO;

public interface ProductosService {

	public void guardarProductos(ProductosRequestDTO p);
	public void eliminarProducto(Integer id);
	public void editarProducto(ProductosRequestDTO p);
	public List<ProductoResponseDTO> listarProducto();
	public ProductoResponseDTO productoById(Integer id);
}
