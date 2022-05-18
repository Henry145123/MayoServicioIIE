package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Producto;

public interface ProductoService {

	void guardarProducto(Producto p);
	void actualizarProducto(Producto p);
	void eliminarProducto(Integer id);
	List<Producto> listaProductos();
	Producto obtenerProductoId(Integer id);
}
