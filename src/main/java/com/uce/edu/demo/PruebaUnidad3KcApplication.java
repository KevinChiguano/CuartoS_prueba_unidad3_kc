package com.uce.edu.demo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uce.edu.demo.repository.modelo.Producto;
import com.uce.edu.demo.repository.modelo.Reporte;
import com.uce.edu.demo.repository.modelo.Venta;
import com.uce.edu.demo.service.IProductoService;
import com.uce.edu.demo.service.IVentaService;

@SpringBootApplication
public class PruebaUnidad3KcApplication implements CommandLineRunner{
	
	private static final Logger LOG = LogManager.getLogger(PruebaUnidad3KcApplication.class);

	@Autowired
	private IProductoService productoService;
	
	@Autowired
	private IVentaService ventaService;
	
	public static void main(String[] args) {
		SpringApplication.run(PruebaUnidad3KcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Producto producto = new Producto();
		producto.setCategoria("A");
		producto.setCodigoBarra("123");
		producto.setNombre("Pan");
		producto.setPrecio(new BigDecimal(2));
		producto.setStock(50);
		
		this.productoService.insertar(producto);
		
		Producto producto2 = new Producto();
		producto2.setCodigoBarra("123");
		
		List<Producto> productos = new ArrayList<>();
		productos.add(producto2);
		
		this.ventaService.realizarVenta(productos,"123456", "000001", 1);
		
		//this.ventaService.buscarReporte(LocalDateTime.now(), "A", 20).forEach(Reporte ->LOG.info(Reporte));
		
	}

}
