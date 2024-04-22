package kiku;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CuentaBancaria 

{
	protected String numeroCuenta;
	protected double saldo;
	
	public static ArrayList <Cliente> Usuarios = new ArrayList<Cliente>();
	
	  public static ArrayList <Cliente> cargarArrayListDesdeArchivo() {
	        String nombreArchivo = "registro.txt";
	        String rutaDirectorio = "C:\\Users\\luque\\eclipse-workspace\\Cajero_automatico\\Sources";
	        

	        try (BufferedReader reader = new BufferedReader(new FileReader(rutaDirectorio + "/" + nombreArchivo))) {
	            String linea;
	            while ((linea = reader.readLine()) != null) {
	                // obtener atributos enteros 
	                String[] partes = linea.split(",");
	                int id = Integer.parseInt(partes[0]);
	                int clave = Integer.parseInt(partes[1]);
	                double saldo = Double.parseDouble(partes[2]);
	                // crar y agregar objeto
	                Usuarios.add(new Cliente(id, clave,saldo));
	            }
	            System.out.println("Usuarios cargados correctamente desde el archivo " + nombreArchivo);
	        } catch (Exception e) {
	            System.err.println("Error al cargar desde el archivo: " + e.getMessage());
	        }

	        return Usuarios;
	    }
	
	
	public CuentaBancaria(String numeroCuenta, double saldo) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		
	}
	
	public CuentaBancaria()
	{
		
		
	}
	
	
	public void Retirar(int clave,double monto) 
	{   Scanner leer = new Scanner(System.in);
	
		for (Cliente cliente : Usuarios) {
		
				if (cliente.getClave()==clave)
				{	
					cliente.setSaldo(cliente.getSaldo()-monto); 
					
					System.out.println("saldo modificdo a: "+cliente.getSaldo());
				}
			}}

	
	//get y set 
	
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
}
