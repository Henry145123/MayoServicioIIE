package com.idat.MayoServicioPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Proveedor;
import com.idat.MayoServicioPrueba.repository.ProveedorRepository;

@Service
public class ProveedorServiceImpl implements ProveedorService {

	@Autowired
	private ProveedorRepository proRep;
	
	@Override
	public void guardarProveedor(Proveedor p) {
		// TODO Auto-generated method stub
		proRep.save(p);
	}

	@Override
	public void actualizarProveedor(Proveedor p) {
		// TODO Auto-generated method stub
		proRep.saveAndFlush(p);
	}

	@Override
	public void eliminarProveedor(Integer id) {
		// TODO Auto-generated method stub
		proRep.deleteById(id);
	}

	@Override
	public List<Proveedor> listaProveedores() {
		// TODO Auto-generated method stub
		return proRep.findAll();
	}

	@Override
	public Proveedor obtenerProveedorId(Integer id) {
		// TODO Auto-generated method stub
		return proRep.findById(id).orElse(null);
	}

}
