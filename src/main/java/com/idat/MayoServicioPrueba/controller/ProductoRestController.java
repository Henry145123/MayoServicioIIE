package com.idat.MayoServicioPrueba.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.idat.MayoServicioPrueba.model.Producto;
import com.idat.MayoServicioPrueba.service.ProductoService;



@RestController
@RequestMapping("/producto")
public class ProductoRestController {
	@Autowired
	private ProductoService proServ;
	
	@GetMapping("/listar")
	public ResponseEntity<?> listar(){
		Collection<Producto> listaProductos = proServ.listaProductos();
		return new ResponseEntity<>(listaProductos,HttpStatus.OK);
	}
	
	@GetMapping("/buscar/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Integer id){
		Producto p =proServ.obtenerProductoId(id);
		if(p!=null) {
			return new ResponseEntity<>(p,HttpStatus.OK);
		}
		return new ResponseEntity<>("No se encontro el Producto",HttpStatus.NOT_FOUND);
		
	}
	
	@PostMapping("/agregar")
	public ResponseEntity<?> agregar(@RequestBody Producto p){
		proServ.guardarProducto(p);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	

	
	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Integer id){
		Producto p = proServ.obtenerProductoId(id);
		if(p!=null) {
			proServ.eliminarProducto(id);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/editar/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Integer id,@RequestBody Producto p){
		
		
		Producto pro=proServ.obtenerProductoId(id);		
		if(pro!=null) {
	
				p.setIdProducto(id);//d
				proServ.actualizarProducto(p);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);

	}
	
}
