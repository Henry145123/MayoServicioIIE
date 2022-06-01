package com.idat.MayoServicioPrueba.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.MayoServicioPrueba.model.Item;
import com.idat.MayoServicioPrueba.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itmRep;
	
	@Override
	public void guardarItem(Item i) {
		// TODO Auto-generated method stub
		itmRep.save(i);
	}

	@Override
	public void actualizarItem(Item i) {
		// TODO Auto-generated method stub
		itmRep.saveAndFlush(i);
	}

	@Override
	public void eliminarItem(Integer id) {
		// TODO Auto-generated method stub
		itmRep.deleteById(id);
	}

	@Override
	public List<Item> listaItems() {
		// TODO Auto-generated method stub
		return itmRep.findAll();
	}

	@Override
	public Item obtenerItemId(Integer id) {
		// TODO Auto-generated method stub
		return itmRep.findById(id).orElse(null);
	}

}
