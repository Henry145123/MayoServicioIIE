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

import com.idat.MayoServicioPrueba.model.Cliente;
import com.idat.MayoServicioPrueba.service.ClienteService;





@RestController
@RequestMapping("/cliente/v1")
public class ClienteRestController {
	@Autowired
	private ClienteService cliServ;
	
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<Collection<Cliente>>  listar(){
		
		 return new ResponseEntity<Collection<Cliente>>( cliServ.listaClientes(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar",method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Cliente cliente) {
		cliServ.guardarCliente(cliente);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(path="/borrar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Cliente c = cliServ.obtenerClienteId(id);
		if(c!=null) {
			cliServ.eliminarCliente(id);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/buscar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id){
		Cliente c =cliServ.obtenerClienteId(id);
		if(c!=null) {
			return new ResponseEntity<Cliente>(c,HttpStatus.OK);
		}
		return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar",method=RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Cliente c){
		
		Cliente cli=cliServ.obtenerClienteId(c.getIdCliente());		
		if(cli!=null) {
			cliServ.actualizarCliente(c);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	
	
}
