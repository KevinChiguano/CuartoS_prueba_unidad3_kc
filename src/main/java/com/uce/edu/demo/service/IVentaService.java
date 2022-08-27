package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Reporte;

public interface IVentaService {
	
	public void realizarVenta(List<Producto> producto, String cedula, String numeroVenta, Integer cantidad);
	public List<Reporte> buscarReporte(LocalDateTime fecha, String categoria, Integer cantidad);

}
