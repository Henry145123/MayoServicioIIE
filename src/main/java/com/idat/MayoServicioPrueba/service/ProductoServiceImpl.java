package com.idat.MayoServicioPrueba.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.dto.ProductoDTORequest;
import com.idat.MayoServicioPrueba.dto.ProductoDTOResponse;
import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository proRep;
	
	@Override
	public void guardarProducto(ProductoDTORequest pro) {
		
		Producto p = new Producto();
		p.setNombreProducto(pro.getNombre());
		p.setDescripcion(pro.getDescripcionProducto());
		p.setPrecio(pro.getPrecioProducto());
		p.setStock(pro.getStockProducto());
	
		proRep.save(p);
	}

	@Override
	public void actualizarProducto(ProductoDTORequest pro) {
		
		
		Producto p = new Producto();
		p.setIdProducto(pro.getId());
		p.setNombreProducto(pro.getNombre());
		p.setDescripcion(pro.getDescripcionProducto());
		p.setPrecio(pro.getPrecioProducto());
		p.setStock(pro.getStockProducto());
		proRep.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		proRep.deleteById(id);
	}

	@Override
	public List<ProductoDTOResponse> listaProductos() {
		
		List<ProductoDTOResponse> listar = new ArrayList<>();
		ProductoDTOResponse dto = null;
		List<Producto> p =proRep.findAll();
		
		for(Producto productos : p) {
			dto = new ProductoDTOResponse();
			
			dto.setId(productos.getIdProducto());
			dto.setNombre(productos.getNombreProducto());
			dto.setDescripcionProducto(productos.getDescripcion());
			dto.setPrecioProducto(productos.getPrecio());
			dto.setStockProducto(productos.getStock());
			
			listar.add(dto);
		}
		
		return listar;
	}

	@Override
	public ProductoDTOResponse obtenerProductoId(Integer id) {
		
		Producto productos = proRep.findById(id).orElse(null);
		ProductoDTOResponse dto = new ProductoDTOResponse();
		
		dto.setId(productos.getIdProducto());
		dto.setNombre(productos.getNombreProducto());
		dto.setDescripcionProducto(productos.getDescripcion());
		dto.setPrecioProducto(productos.getPrecio());
		dto.setStockProducto(productos.getStock());
		
		return dto;
	}

}
