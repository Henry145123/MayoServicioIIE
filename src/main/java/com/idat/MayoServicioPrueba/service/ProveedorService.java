package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Proveedor;

public interface ProveedorService {

	void guardarProveedor(Proveedor p);
	void actualizarProveedor(Proveedor p);
	void eliminarProveedor(Integer id);
	List<Proveedor> listaProveedores();
	Proveedor obtenerProveedorId(Integer id);
}
