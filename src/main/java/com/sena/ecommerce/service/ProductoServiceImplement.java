package com.sena.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.ecommerce.model.Producto;
import com.sena.ecommerce.repository.IProductoRepository;

@Service
public class ProductoServiceImplement implements IProductoService{
	
	private IProductoRepository productoRepository;

	@Override
	public Producto save() {
		// TODO Auto-generated method stub
		return productoRepository.save(producto);
	}

	@Override
	public Optional<Producto> get(Integer id) {
		// TODO Auto-generated method stub
		return productoRepository.findById(id);
	}

	@Override
	public void update(Producto producto) {
		// TODO Auto-generated method stub
		productoRepository.save(producto);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);

	}

	@Override
	public List<producto> findALL() {
		// TODO Auto-generated method stub
		return null;
	}

}
