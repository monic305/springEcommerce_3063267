package com.sena.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.ecommerce.model.Orden;
import com.sena.ecommerce.model.Usuario;
import com.sena.ecommerce.repository.IOrdenRepository;

@Service
public class ProductoServiceImplement implements IOrdenService {

	@Autowired
	private IOrdenRepository ordenrepository;

	@Override
	public Orden save(Orden orden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Orden> findById(Integer id) {
		// TODO Auto-generated method stub
		return ordenrepository.findById(id);
	}

	@Override
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return ordenrepository.findAll();
	}

	@Override
	public List<Orden> findByUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return ordenrepository.findByUsuario(usuario);
	}

	@Override
	public String generarNumeroOrden() {
		int numero = 0;
		String numeroConcatenado = "";
		List<Orden> ordenes = findAll();

		List<Integer> numeros = new ArrayList<Integer>();

		// funciones de java8
		// variable anonima
		ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));

		// validacion
		if (ordenes.isEmpty()) {
			numero = 1;

		} else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;

		}

		if (numero < 10) {
			numeroConcatenado = "T000000000" + String.valueOf(numero);
		} else if (numero < 100) {
			numeroConcatenado = "T00000000" + String.valueOf(numero);

		} else if (numero < 100) {
			numeroConcatenado = "T0000000" + String.valueOf(numero);

		}

		return numeroConcatenado;
	}

}