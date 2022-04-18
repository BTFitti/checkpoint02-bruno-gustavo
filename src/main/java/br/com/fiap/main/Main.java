package br.com.fiap.main;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.dao.impl.CarroAcessorioDAOImpl;
import br.com.fiap.entity.Acessorio;
import br.com.fiap.entity.Carro;
import br.com.fiap.entity.CarroAcessorio;
import br.com.fiap.entity.Modelo;
import br.com.fiap.service.impl.AcessorioServiceImpl;
import br.com.fiap.service.impl.CarroAcessorioServiceImpl;
import br.com.fiap.service.impl.CarroServiceImpl;
import br.com.fiap.service.impl.ModeloServiceImpl;

public class Main {

	
	
	
	public static void main(String[]args) {
		
		AcessorioServiceImpl acessorioService = AcessorioServiceImpl.getInstance();
		CarroServiceImpl carroService = CarroServiceImpl.getInstance();
		ModeloServiceImpl modeloService = ModeloServiceImpl.getInstance();
		CarroAcessorioServiceImpl carroacessorioService = CarroAcessorioServiceImpl.getInstance();
		
	
		Modelo modelo = new Modelo("Mazda RX7");
		Acessorio acessorio1 = new Acessorio("Volante");
		Acessorio acessorio2 = new Acessorio("Freio de mão");


		modeloService.cadastrar(modelo);
		acessorioService.cadastrar(acessorio1);
		acessorioService.cadastrar(acessorio2);
		
		
		
		Carro carro = new Carro ("423BR12","Vermelho","123WQS921SKD123Z2",  modelo);
		carro.setModelo(modelo);
		carroService.cadastrar(carro);
		
		CarroAcessorio acessorioCarro1 = new CarroAcessorio(carro, acessorio1);
		CarroAcessorio acessorioCarro2 = new CarroAcessorio(carro, acessorio2);
		
		carroacessorioService.cadastrar(acessorioCarro1);
		carroacessorioService.cadastrar(acessorioCarro2);
		
		
	}
}
