package com.idat.MayoServicioPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Cliente;
import com.idat.MayoServicioPrueba.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository cliRep;
	
	@Override
	public void guardarCliente(Cliente c) {
		// TODO Auto-generated method stub
		cliRep.save(c);
	}

	@Override
	public void actualizarCliente(Cliente c) {
		// TODO Auto-generated method stub
		cliRep.saveAndFlush(c);
	}

	@Override
	public void eliminarCliente(Integer id) {
		// TODO Auto-generated method stub
		cliRep.deleteById(id);
	}

	@Override
	public List<Cliente> listaClientes() {
		// TODO Auto-generated method stub
		return cliRep.findAll();
	}

	@Override
	public Cliente obtenerClienteId(Integer id) {
		// TODO Auto-generated method stub
		return cliRep.findById(id).orElse(null);
	}

}
