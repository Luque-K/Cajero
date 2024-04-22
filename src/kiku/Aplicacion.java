package kiku;

import java.util.Scanner;
public class Aplicacion {

	public static void main(String[] args) {
		
	//crear objetos
		Scanner leer = new Scanner(System.in);
		Cliente cliente1= new Cliente();
		Tarjeta tarjeta1 = new Tarjeta();
		CuentaBancaria banco1 = new CuentaBancaria();
		Cajero cajero1 = new Cajero();
		ArchivoManager prueba = new ArchivoManager();
	//	
		banco1.Usuarios = banco1.cargarArrayListDesdeArchivo();

		byte opc;
		for(int i=1;i==1;) 
		{
		System.out.println("¿Que desea hecer?");
		System.out.println("Presione 1 para registrar nuevo usuario en banco");
		System.out.println("Presione 2 para entrar al cajero");
		System.out.println("Presione 3 para salir del banco");
		opc=leer.nextByte();
		switch(opc) 
		{
		case 1: System.out.print("Ingrese su id: ");
		cliente1.Regristrar(leer.nextInt()); break;
		case 2: cliente1.IngresarTarjeta();
		;tarjeta1.ValidarTarjeta();
		;System.out.println("Ingrese su clave"); 
		int clave = leer.nextInt(); 
		if(cliente1.buscar(clave)) 
		{cliente1.SeleccionarOperacion(clave);}
		else {break;}
		; break;
		case 3: i=2; break;
		default: System.out.println("opcion no valida");
		}
		}
		prueba.guardarArrayListEnArchivo(cliente1.Usuarios);
		}
	}
