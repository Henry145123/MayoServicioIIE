package com.idat.MayoServicioPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoRepository proRep;
	
	@Override
	public void guardarProducto(Producto p) {
		// TODO Auto-generated method stub
		proRep.save(p);
	}

	@Override
	public void actualizarProducto(Producto p) {
		// TODO Auto-generated method stub
		proRep.saveAndFlush(p);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		proRep.deleteById(id);
	}

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		return proRep.findAll();
	}

	@Override
	public Producto obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		return proRep.findById(id).orElse(null);
	}

}
