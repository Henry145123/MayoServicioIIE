package com.idat.MayoServicioPrueba.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	private String cliente;
	private String celular;
	
	@ManyToMany(mappedBy = "clientes", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private List<Producto> productos= new ArrayList<>();
	
	//mappedBy va en la tabla Padre
	@OneToMany(mappedBy ="cliente" )
	private List<Item> items = new ArrayList<>();	
	
		
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
	
}
