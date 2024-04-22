package kiku;

import java.util.Scanner;

public class Cliente extends CuentaBancaria {

	protected int id;
	
	
	protected int  clave;
	public Cliente(String numeroCuenta, double saldo, int id, int clave) {
		super(numeroCuenta, saldo);
		this.id = id;
		this.clave=clave;
	}
	public Cliente(){}
	
	public Cliente(int id, int clave, double saldo) {
		
		this.id = id;
		this.clave = clave;
		this.saldo=saldo;
	}
	
	Scanner leer = new Scanner(System.in);
	
	
	// Registro
	
	public void Regristrar(int id)
	{
		Scanner leer = new Scanner(System.in);
		 
		Cliente objper = new Cliente();
	    
	    // Verificar si la identificación ya existe en la lista
	    boolean existe = false;
	    for (Cliente persona : Usuarios) {
	        if (persona.getId()==id) {
	            System.out.println("La identificación ya existe.");
	            existe = true;
	            break;
	        }
	    }

	    if (!existe) {
	        objper.setId(id);
	        
	        
	        objper.setId(id);

	        System.out.print("Ingrese su clave: ");
	        objper.setClave(leer.nextInt());
	        
	        Usuarios.add(objper);
	        System.out.println("Usuario creado correctamente.");
	       
	    }
	}
	//
	public String toString() {
		return id + "," + clave + ","+saldo;
		
	}
	
	// depositar cuenta 
	
	public void Depositar(int clave,double monto) 
	{   Scanner leer = new Scanner(System.in);
	
		for (Cliente cliente : Usuarios) {
		
				if (cliente.getClave()==clave)
				{	
					cliente.setSaldo(cliente.getSaldo()+monto); 
					
					System.out.println("Retiro hecho con exito");
					System.out.println("Su saldo es de "+cliente.getSaldo());
				}
			}}

	
	//retirar dinero
	public void Retirar(int clave,double monto) 
	{   Scanner leer = new Scanner(System.in);
	
		for (Cliente cliente : Usuarios) {
		
				if (cliente.getClave()==clave)
				{	
					cliente.setSaldo(cliente.getSaldo()-monto); 
					
					System.out.println("Retiro hecho con exito");
					System.out.println("Su saldo es de: "+cliente.getSaldo());
				}
			}}
	
	//prueba

		public void mostrar()
		{for(int i=0; i < Usuarios.size(); i++)
		{
			System.out.println(Usuarios.get(i)); 		
		}}

	//ingrsar tarjeta
		
		public void IngresarTarjeta() 
		{	
		String textoEsperado = "insertar";
	    String entradaUsuario;
	    do 
	    {
	    	System.out.println("Ingrese su tarjeta");	
	    	System.out.println("Escribe '" + textoEsperado + "' para continuar:");
	        entradaUsuario = leer.nextLine();
	    } while (!entradaUsuario.equalsIgnoreCase(textoEsperado));

			
		}
	//ingresar clave
			
		
		public void IngresarClave() 
		{	
		clave= leer.nextInt();
		}
		
	//Buscar usuario
		
		public boolean buscar(int clave)
		{
			boolean e = false;
		    for (Cliente persona : Usuarios) {
		        
		        if (persona.getClave()==clave) {
		            System.out.println("Sesion iniciada:");
		            System.out.println("Identificación: " + persona.getId());
		            System.out.println("El saldo es de " + persona.getSaldo());
		            System.out.println("Presione cualquier tecla para continuar");
		        	String a = leer.next();
		       e=true;
		        }
		        else {System.out.println("La clave no coincide con ningun usuario");}   
		    }
			return e;
		}
		
	//Que hacer en el cajero
		ArchivoManager prueba = new ArchivoManager();
		public void SeleccionarOperacion(int clave) 
		{
			for (int a=1;a==1;)
			{
				System.out.println("¿Qué acción desea hacer?");
				System.out.println("1.Consultar saldo.");
				System.out.println("2.Realizar retiro.");
				System.out.println("3.Depositar en cuenta.");
				System.out.println("4. Transferir fondos");
				System.out.println("5. Salir de cajero");
				int opcion = leer.nextInt();
				
				switch(opcion) 
				
				{
				case 1: ConsultarSaldo(clave, 0.0); break;
				
				case 2: System.out.println("Digite la cantidad de dinero que quiere retirar");Retirar(clave, leer.nextDouble());
				prueba.guardarTransacciones(Usuarios);break;
				
				case 3: System.out.println("Digite la cantidad de dinero que quiere depositar");Depositar(clave,leer.nextDouble()); 
				prueba.guardarTransacciones(Usuarios);break;
				
				case 4: System.out.println("Escriba el id de la persona a la que quiere depositar");Trans(leer.nextInt(), 0.0, clave);
				prueba.guardarTransacciones(Usuarios);break;
				
				case 5: a=2; break;
				
	//f pruebas
				
				case 6: mostrar(); break;
				
				case 7: buscar(clave); break;
				
				default: System.out.println("Valor inválido");
				}}
			
		}
		
		//consultar saldo de usuario
		
		public void ConsultarSaldo(int clave,double monto) 
		{   Scanner leer = new Scanner(System.in);
		
			for (Cliente cliente : Usuarios) {
					if (cliente.getClave()==clave)
					{	
						cliente.setSaldo(cliente.getSaldo()+monto); 
						
						System.out.println("El saldo es de "+cliente.getSaldo());
					}
				}}
		
		// depositar a otro usuario
		
		public void Trans(int id,double monto, int clave) 
		{   Scanner leer = new Scanner(System.in);
			System.out.println("Escriba el monto que quiere transferir");
			monto = leer.nextDouble();
			for (Cliente cliente : Usuarios) 
		{
			
					if (cliente.getId()==id)
					{	
						cliente.setSaldo(cliente.getSaldo()+monto); 
						
						System.out.println("Transferencia hecha con exito");
					}
				}
			for (Cliente cliente : Usuarios)
			{
				
				if (cliente.getClave()==clave)
				{	
					cliente.setSaldo(cliente.getSaldo()-monto); 
					
					System.out.println("Su saldo es de: "+cliente.getSaldo());
				}
			}
		}
		

		//get y set
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}

		public int getClave() {
			return clave;
		}

		public void setClave(int clave) {
			this.clave = clave;
		}



}
