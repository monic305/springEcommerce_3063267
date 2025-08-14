package com.sena.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sena.ecommerce.SpringEcommerce3063267Application;
import com.sena.ecommerce.model.Orden;
import com.sena.ecommerce.model.Usuario;

@Service
public class OrdenServiceImplement implements IOrdenService{

    private final SpringEcommerce3063267Application springEcommerce3063267Application;
	
	@Autowired
	private IOrdenRepository ordenRepository;

    OrdenServiceImplement(SpringEcommerce3063267Application springEcommerce3063267Application) {
        this.springEcommerce3063267Application = springEcommerce3063267Application;
    }

	@Override
	public Orden save() {
		// TODO Auto-generated method stub
		return ordenRepository.save(orden);
	}

	@Override
	public Optional<Orden> get(Integer id) {
		// TODO Auto-generated method stub
		return ordenRepository.findById(id);
	}

	@Override
	public List<Orden> findALL() {
		// TODO Auto-generated method stub
		return ordenRepository.findALL();
	}

	@Override
	public List<Orden> findByUsuario() {
		// TODO Auto-generated method stub
		return orden.findByUsuario();
	}


	@Override
	public String generarNumeroOrden() {
		int numero = 0;
		
		String numeroConcatenado = "";
		
		List<Orden> ordenes =findAll();
		
		List<Integer> numeros = new ArrayList<Integer>();
		
		//funciones de java8
		// una variable anonima
		ordenes.stream().forEach(o -> numeros.add(Integer.parseInt(o.getNumero())));
		
		//validacion
		if (ordenes.isEmpty()) {
			numero = 1;
		}else {
			numero = numeros.stream().max(Integer::compare).get();
			numero++;
		}
		
		if (numero <10) {
			numeroConcatenado = "T000000000" + String.valueOf(numero);
		}else if (numero < 100) {
			numeroConcatenado = "T00000000" + String.valueOf(numero);
		}else if (numero < 1000) {
			numeroConcatenado = "T0000000" + String.valueOf(numero);
		}
		
		return numeroConcatenado;
	}

}
