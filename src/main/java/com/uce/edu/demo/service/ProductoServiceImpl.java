package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IProductoRepo;
import com.uce.edu.demo.repository.modelo.Producto;

@Service
public class ProductoServiceImpl implements IProductoService {

	@Autowired
	private IProductoRepo productoRepo;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		
		Producto prod = this.productoRepo.buscarCodigoBarra(producto.getCodigoBarra());
		
		if(prod == null) {
			this.productoRepo.insertar(producto);
		}else {
			prod.setStock(prod.getStock()+producto.getStock());
			this.productoRepo.actualizar(prod);
		}
		
		
	}

}
