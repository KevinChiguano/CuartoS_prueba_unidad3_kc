package com.uce.edu.demo.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.repository.modelo.Venta;

public interface IVentaRepo {
	
	public void insertar(Venta venta);
	
	public List<Reporte> buscarReporte(LocalDateTime fecha, String categoria, Integer cantidad);
	

}
