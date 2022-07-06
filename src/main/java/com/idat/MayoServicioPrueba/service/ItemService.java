package com.idat.MayoServicioPrueba.service;

import java.util.List;

import com.idat.MayoServicioPrueba.model.Item;

public interface ItemService {

	void guardarItem(Item i);
	void actualizarItem(Item i);
	void eliminarItem(Integer id);
	List<Item> listaItems();
	Item obtenerItemId(Integer id);
}
