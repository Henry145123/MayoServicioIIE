package com.idat.MayoServicioPrueba.model;

import javax.persistence.*;

@Entity
@Table(name = "Proveedores")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idProveedor;
	private String proveedor;
	private String direccion;
	
	
	@OneToOne
	@JoinColumn(name = "id_producto",nullable = false,unique=true,			 //llave foranea //jpa transforma idProducto en id_producto en la base de datos
				foreignKey = @ForeignKey(foreignKeyDefinition = "foreign key (id_producto) references Productos(id_producto)"))
	private Producto producto;
	
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getProveedor() {
		return proveedor;
	}
	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
