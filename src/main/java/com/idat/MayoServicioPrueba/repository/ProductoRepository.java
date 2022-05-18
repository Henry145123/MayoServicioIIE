package com.idat.MayoServicioPrueba.repository;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Producto;

public interface ProductoRepository {

	void guardarProducto(Producto p);
	void actualizarProducto(Producto p);
	void eliminarProducto(Integer id);
	List<Producto> listaProductos();
	Producto obtenerProductoId(Integer id);
}
