package com.idat.MayoServicioPrueba.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.idat.MayoServicioPrueba.model.Producto;


@Repository
public class ProductoRepositoryImpl implements ProductoRepository {

	private List<Producto> listaProducto=new ArrayList<>();
	
	@Override
	public void guardarProducto(Producto p) {
		// TODO Auto-generated method stub
		listaProducto.add(p);
	}

	@Override
	public void actualizarProducto(Producto p) {
		// TODO Auto-generated method stub
		Producto pro =obtenerProductoId(p.getIdProducto());
		
		pro.setDescripcion(p.getDescripcion());
		pro.setNombreProducto(p.getNombreProducto());
		pro.setPrecio(p.getPrecio());
		pro.setStock(p.getStock());

	}

	@Override
	public List<Producto> listaProductos() {
		// TODO Auto-generated method stub
		return listaProducto;
	}

	@Override
	public Producto obtenerProductoId(Integer id) {
		// TODO Auto-generated method stub
		
		Producto p = new Producto();
		for(Producto item:listaProducto) {
			if(item.getIdProducto() == id) {
				p = item;
			}
		}
		
		return p;
		
		//return listaProducto.stream().filter(p->p.getIdProducto()==id).findFirst().orElse(null);
	}

	@Override
	public void eliminarProducto(Integer id) {
		// TODO Auto-generated method stub
		Producto p = obtenerProductoId(id);
		listaProducto.remove(p);
	}

}
