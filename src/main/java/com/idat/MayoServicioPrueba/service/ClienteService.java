package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Cliente;

public interface ClienteService {

	void guardarCliente(Cliente c);
	void actualizarCliente(Cliente c);
	void eliminarCliente(Integer id);
	List<Cliente> listaClientes();
	Cliente obtenerClienteId(Integer id);
}
