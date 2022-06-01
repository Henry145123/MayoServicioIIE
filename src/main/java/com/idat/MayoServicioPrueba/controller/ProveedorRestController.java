package com.idat.MayoServicioPrueba.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idat.MayoServicioPrueba.model.Proveedor;
import com.idat.MayoServicioPrueba.service.ProveedorService;





@RestController
@RequestMapping("/proveedor/v1")
public class ProveedorRestController {
	@Autowired
	private ProveedorService proServ;
	
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<Collection<Proveedor>>  listar(){
		
		 return new ResponseEntity<Collection<Proveedor>>( proServ.listaProveedores(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar",method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Proveedor proveedor) {
		proServ.guardarProveedor(proveedor);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(path="/borrar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Proveedor p = proServ.obtenerProveedorId(id);
		if(p!=null) {
			proServ.eliminarProveedor(id);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/buscar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Proveedor> buscarPorId(@PathVariable Integer id){
		Proveedor p =proServ.obtenerProveedorId(id);
		if(p!=null) {
			return new ResponseEntity<Proveedor>(p,HttpStatus.OK);
		}
		return new ResponseEntity<Proveedor>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar",method=RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Proveedor p){
		
		Proveedor pro=proServ.obtenerProveedorId(p.getIdProveedor());		
		if(pro!=null) {
				proServ.actualizarProveedor(p);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
}
