package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.BodegaResponseDTO;
import com.example.demo.DTO.ProductoResponseDTO;
import com.example.demo.DTO.ProductosRequestDTO;
import com.example.demo.model.Bodega;
import com.example.demo.model.Productos;
import com.example.demo.repository.BodegaRepository;
import com.example.demo.repository.ProductoRepository;
@Service
public class ProductoServiceImpl implements ProductosService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public void guardarProductos(ProductosRequestDTO p) {
		// TODO Auto-generated method stub
		Productos producto = new Productos();
		producto.setIdProducto(p.getIdProductorq());
		producto.setProducto(p.getNombreProductorq());
		producto.setDescripcion(p.getDescripcionProductorq());
		producto.setPrecio(p.getPrecioProductorq());
		producto.setStock(p.getStockProductorq());	
		
		repository.save(producto);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void editarProducto(ProductosRequestDTO p) {
		// TODO Auto-generated method stub
		Productos producto = new Productos();
		
		producto.setIdProducto(p.getIdProductorq());
		producto.setProducto(p.getNombreProductorq());
		producto.setDescripcion(p.getDescripcionProductorq());
		producto.setPrecio(p.getPrecioProductorq());
		producto.setStock(p.getStockProductorq());
	}

	@Override
	public List<ProductoResponseDTO> listarProducto() {
		// TODO Auto-generated method stub
		List<Productos> producto = repository.findAll();
		
		List<ProductoResponseDTO> dto = new ArrayList<ProductoResponseDTO>();
		ProductoResponseDTO productoDto = null;
		
		for (Productos productos : producto) {
			productoDto = new ProductoResponseDTO();
			
			productoDto.setIdProductorp(productos.getIdProducto());
			productoDto.setNombreProductorp(productos.getProducto());
			productoDto.setDescripcionProductorp(productos.getDescripcion());
			productoDto.setPrecioProductorp(productos.getPrecio());
			productoDto.setStockProductorp(productos.getStock());
			
			dto.add(productoDto);
		}
		return dto;
	}

	@Override
	public ProductoResponseDTO productoById(Integer id) {
		// TODO Auto-generated method stub
		Productos producto = repository.findById(id).orElse(null);
		ProductoResponseDTO productoDto = new ProductoResponseDTO();
		
		productoDto = new ProductoResponseDTO();	
		productoDto.setIdProductorp(producto.getIdProducto());
		productoDto.setNombreProductorp(producto.getProducto());
		productoDto.setDescripcionProductorp(producto.getDescripcion());
		productoDto.setPrecioProductorp(producto.getPrecio());
		productoDto.setStockProductorp(producto.getStock());
		
		return productoDto;
	}

}
