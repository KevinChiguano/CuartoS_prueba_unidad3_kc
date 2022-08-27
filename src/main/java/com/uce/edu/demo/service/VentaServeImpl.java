package com.uce.edu.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.IVentaRepo;
import com.uce.edu.demo.repository.modelo.DetalleVenta;
import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.repository.modelo.Venta;

@Service
public class VentaServeImpl implements IVentaService {
	
	@Autowired
	private IProductoRepo productoRepo;
	
	@Autowired
	private IVentaRepo ventaRepo;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarVenta(List<Producto> producto, String cedula, String numeroVenta,Integer cantidad) {
		// TODO Auto-generated method stub
		
		List<DetalleVenta> detalles = new ArrayList<>();
		
		Venta venta = new Venta();
		venta.setCedula(cedula);
		venta.setFecha(LocalDateTime.now());
		venta.setNumero(numeroVenta);
		
		BigDecimal total = new BigDecimal(0);
		
		for(Producto prod : producto) {
			DetalleVenta detalle = new DetalleVenta();
			Producto pro1 = this.productoRepo.buscarCodigoBarra(prod.getCodigoBarra());
			
			
			pro1.setStock(pro1.getStock()-cantidad);
			
			if(pro1.getStock() <=0) {
				throw new RuntimeException();
			}
			
			this.productoRepo.actualizar(pro1);
			
			detalle.setCantidad(cantidad);
			detalle.setPrecioUnitario(pro1.getPrecio());
			detalle.setSubtotal(pro1.getPrecio().multiply(new BigDecimal(cantidad)));
			detalle.setProducto(pro1);
			
			total = total.add(new BigDecimal(10));
			detalles.add(detalle);
			
		}
		
		
		
		venta.setTotalVenta(total);
		venta.setDetalles(detalles);
		
		this.ventaRepo.insertar(venta);

	}

	@Override
	public List<Reporte> buscarReporte(LocalDateTime fecha, String categoria, Integer cantidad) {
		// TODO Auto-generated method stub
		return this.ventaRepo.buscarReporte(fecha, categoria, cantidad);
	}

}
