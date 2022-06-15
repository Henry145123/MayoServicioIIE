package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.dto.ProductoDTORequest;
import com.idat.MayoServicioPrueba.dto.ProductoDTOResponse;
import com.idat.MayoServicioPrueba.model.Producto;

public interface ProductoService {

	void guardarProducto(ProductoDTORequest p);
	void actualizarProducto(ProductoDTORequest p);
	void eliminarProducto(Integer id);
	List<ProductoDTOResponse> listaProductos();
	ProductoDTOResponse obtenerProductoId(Integer id);
}
