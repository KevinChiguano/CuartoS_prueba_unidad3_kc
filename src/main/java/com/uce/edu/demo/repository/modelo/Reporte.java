package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;

public class Reporte {

	private String codigoBarra;
	private String nombreProducto;
	private Integer cantidad;
	private BigDecimal precioUnitario;
	private BigDecimal subtotal;

	public Reporte(String codigoBarra, String nombreProducto, Integer cantidad, BigDecimal precioUnitario,
			BigDecimal subtotal) {
		
		this.codigoBarra = codigoBarra;
		this.nombreProducto = nombreProducto;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
		this.subtotal = subtotal;
	}
	
	public Reporte() {
		
	}

	@Override
	public String toString() {
		return "Reporte [codigoBarra=" + codigoBarra + ", nombreProducto=" + nombreProducto + ", cantidad=" + cantidad
				+ ", precioUnitario=" + precioUnitario + ", subtotal=" + subtotal + "]";
	}
	
	

}
