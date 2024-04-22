package kiku;
public class Tarjeta 

{
protected String numeroTarjeta;
protected String tipoTarjeta;

public void ValidarTarjeta() 
{
System.out.println("Tarjeta validada correctameente");	
}

//get y set

public String getNumeroTarjeta() {
	return numeroTarjeta;
}

public void setNumeroTarjeta(String numeroTarjeta) {
	this.numeroTarjeta = numeroTarjeta;
}

public String getTipoTarjeta() {
	return tipoTarjeta;
}

public void setTipoTarjeta(String tipoTarjeta) {
	this.tipoTarjeta = tipoTarjeta;
}


}
