package arreglos;

import java.util.ArrayList;

import entidad.Retiro;

public class ArregloRetiro {

	private ArrayList<Retiro> retiros;

	public ArregloRetiro() {
		retiros = new ArrayList<Retiro>();
	}

	// Adiciona un retiro evitando repetir la matr�cula
	public boolean adicionar(Retiro retiro) 
	{if (buscarPorMatricula(retiro.getNumMatricula()) != null) 
		{return false;}
		retiros.add(retiro);
		return true;
	}

	// Retorna la cantidad de retiros
	public int tamanio() 
	{return retiros.size();}

	// Retorna un retiro seg�n su posici�n
	public Retiro obtener(int posicion) 
	{return retiros.get(posicion);}

	// Busca por n�mero de retiro
	public Retiro buscar(int numRetiro) 
	{for (Retiro retiro : retiros) 
		{if (retiro.getNumRetiro() == numRetiro) 
		{return retiro;}
		}
		return null;
	}

	// Busca por n�mero de matr�cula
	public Retiro buscarPorMatricula(int numMatricula) 
	{for (Retiro retiro : retiros) 
		{if (retiro.getNumMatricula() == numMatricula) 
			{return retiro;}
		}
		return null;
	}

	// Elimina f�sicamente un retiro
	public void eliminar(Retiro retiro)
	{retiros.remove(retiro);}
}