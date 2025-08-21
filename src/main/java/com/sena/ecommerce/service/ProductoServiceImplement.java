package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce.model.Producto;
import com.sena.ecommerce.repository.IProductoRepository;

@Service
public class ProductoServiceImplement implements IProductoService {

	@Autowired
	private IProductoRepository productorepository;

	

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productorepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub
		return productorepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		productorepository.save(producto);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productorepository.deleteById(id);
	}

	@Override
	public List<Producto> findALL() {
		// TODO Auto-generated method stub
		return productorepository.findAll();
	}

}