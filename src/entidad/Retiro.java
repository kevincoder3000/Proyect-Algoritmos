package entidad;

public class Retiro {

	//Atributos privados
	private int numRetiro;
	private int numMatricula;
	private String fecha;
	private String hora;
	
	private static int correlativo = 200001;
	
	//Constructor
	public Retiro(int numRetiro, int numMatricula, String fecha, String hora) 
	{	this.numRetiro = correlativo;
		correlativo++;
		this.numMatricula = numMatricula;
		this.fecha = fecha;
		this.hora = hora;}

	//METODO
	public int getNumRetiro() 
	{return numRetiro;}

	public void setNumRetiro(int numRetiro)
	{this.numRetiro = numRetiro;}

	public int getNumMatricula() 
	{return numMatricula;}

	public void setNumMatricula(int numMatricula) 
	{this.numMatricula = numMatricula;}

	public String getFecha()
	{return fecha;}

	public void setFecha(String fecha) 
	{this.fecha = fecha;}

	public String getHora() 
	{return hora;}

	public void setHora(String hora) 
	{this.hora = hora;}
	
	public static int getCorrelativo() 
	{return correlativo;}
	
	public static void setCorrelativo(int correlativo) 
	{Retiro.correlativo=correlativo;}
	
	
	//fin
	
}
