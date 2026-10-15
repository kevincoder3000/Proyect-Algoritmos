package entidad;

public class Alumno {

    // Atributos privados
    private int codAlumno;
    private String nombres;
    private String apellidos;
    private String dni;
    private int edad;
    private int celular;
    private int estado;
    
    private static int correlativo =  202010001;
    
    // Constructor
    public Alumno(int codAlumno, String nombres, String apellidos, String dni, 
    		int edad, int celular, int estado) 
    {	this.codAlumno =  correlativo;
		correlativo++;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.edad = edad;
		this.celular = celular;
		this.estado = 0;
	}
    // METODO GET / SET
	public int getCodAlumno() 
	{return codAlumno;}

	public void setCodAlumno(int codAlumno)
	{this.codAlumno = codAlumno;}

	public String getNombres() 
	{return nombres;}

	public void setNombres(String nombres) 
	{this.nombres = nombres;}

	public String getApellidos() 
	{return apellidos;}

	public void setApellidos(String apellidos) 
	{this.apellidos = apellidos;}

	public String getDni() 
	{return dni;}

	public void setDni(String dni) 
	{this.dni = dni;}

	public int getEdad() 
	{return edad;}

	public void setEdad(int edad) 
	{this.edad = edad;}

	public int getCelular() 
	{return celular;}

	public void setCelular(int celular) 
	{this.celular = celular;}

	public int getEstado() 
	{return estado;}

	public void setEstado(int estado) 
	{this.estado = estado;}
	
	//metodo
	public static int getCorrelativo() 
	{return correlativo;}
	
	public static void setCorrelativo(int correlativo) 
	{Alumno.correlativo=correlativo;}
    
   // RETORNO 
	public String estadoAlumno()
	{ switch (estado)
		{case 0:
			return "Registrado";
		case 1:
			return "Matriculado";
		case 2:
			return "Retirado";
		default:
			return "Desconocido";
		}
	}
    
    //fin
     
}
