package arreglos;

import java.util.ArrayList;
import entidad.Alumno;

public class ArregloAlumno {

	// Arreglo que almacena los objetos de tipo Alumno
	private ArrayList<Alumno> alumnos;

	// Constructor
	public ArregloAlumno() {
		alumnos = new ArrayList<Alumno>();
	}

	// Adiciona un alumno solamente si el DNI no está repetido
	public boolean adicionar(Alumno alumno) 
	{	if (buscarDni(alumno.getDni()) == null) 
			{alumnos.add(alumno);
			return true;}
		return false;
	}

	// Retorna la cantidad de alumnos
	public int tamaño() 
	{return alumnos.size();	}

	// Retorna un alumno según su posición
	public Alumno obtener(int posicion) 
	{return alumnos.get(posicion);}

	// Busca un alumno por su código
	public Alumno buscar(int codAlumno) 
	{	for (Alumno alumno : alumnos) 
			{if (alumno.getCodAlumno() == codAlumno) 
				{return alumno;}}
		return null;
	}

	// Busca un alumno por su DNI
	public Alumno buscarDni(String dni) 
	{	for (Alumno alumno : alumnos) 
			{if (alumno.getDni().equals(dni)) 
				{return alumno;	}}
		return null;
	}

	// Elimina un alumno
	public void eliminar(Alumno alumno) {
		alumnos.remove(alumno);
	}
}