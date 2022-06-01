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

import com.idat.MayoServicioPrueba.model.Item;
import com.idat.MayoServicioPrueba.service.ItemService;



@RestController
@RequestMapping("/item/v1")
public class ItemRestController {
	@Autowired
	private ItemService itmServ;
	
	
	@RequestMapping("/listar")
	public @ResponseBody ResponseEntity<Collection<Item>>  listar(){
		
		 return new ResponseEntity<Collection<Item>>( itmServ.listaItems(),HttpStatus.OK);
	}
	
	@RequestMapping(path="/guardar",method=RequestMethod.POST)
	public ResponseEntity<Void> guardar(@RequestBody Item item) {
		itmServ.guardarItem(item);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	
	
	@RequestMapping(path="/borrar/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		Item i = itmServ.obtenerItemId(id);
		if(i!=null) {
			itmServ.eliminarItem(id);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/buscar/{id}",method=RequestMethod.GET)
	public ResponseEntity<Item> buscarPorId(@PathVariable Integer id){
		Item i =itmServ.obtenerItemId(id);
		if(i!=null) {
			return new ResponseEntity<Item>(i,HttpStatus.OK);
		}
		return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(path="/editar",method=RequestMethod.PUT)
	public ResponseEntity<Void> actualizar(@RequestBody Item i){
		
		Item itm=itmServ.obtenerItemId(i.getIdItem());		
		if(itm!=null) {
			itmServ.actualizarItem(i);
			return new ResponseEntity<Void>(HttpStatus.OK); 
		}		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	

}
