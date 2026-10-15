package arreglos;

import java.util.ArrayList;

import entidad.Retiro;

public class ArregloRetiro {

	private ArrayList<Retiro> retiros;

	public ArregloRetiro() {
		retiros = new ArrayList<Retiro>();
	}

	// Adiciona un retiro evitando repetir la matrícula
	public boolean adicionar(Retiro retiro) 
	{if (buscarPorMatricula(retiro.getNumMatricula()) != null) 
		{return false;}
		retiros.add(retiro);
		return true;
	}

	// Retorna la cantidad de retiros
	public int tamaño() 
	{return retiros.size();}

	// Retorna un retiro según su posición
	public Retiro obtener(int posicion) 
	{return retiros.get(posicion);}

	// Busca por número de retiro
	public Retiro buscar(int numRetiro) 
	{for (Retiro retiro : retiros) 
		{if (retiro.getNumRetiro() == numRetiro) 
		{return retiro;}
		}
		return null;
	}

	// Busca por número de matrícula
	public Retiro buscarPorMatricula(int numMatricula) 
	{for (Retiro retiro : retiros) 
		{if (retiro.getNumMatricula() == numMatricula) 
			{return retiro;}
		}
		return null;
	}

	// Elimina físicamente un retiro
	public void eliminar(Retiro retiro)
	{retiros.remove(retiro);}
}