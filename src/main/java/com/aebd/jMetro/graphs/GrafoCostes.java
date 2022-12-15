package com.aebd.jMetro.graphs;

/**
 * Implementacion de un grafo simple de costes formado por vertices que son
 * numeros
 * enteros positivos y arcos que los conectan con coste positivo.
 */
public class GrafoCostes extends Grafo {
	// Matriz para representar los costes.
	int costes[][];

	public GrafoCostes(ClaseGrafo claseGrafo, int n) {
		super(claseGrafo, n);
		costes = new int[n][n];
		for (int i = 0; i < nV; i++) {
			for (int j = 0; j < nV; j++)
				costes[i][j] = Integer.MAX_VALUE;
		}
	}

	/**
	 * Establece un arco o arista de coste "coste" entre el vertice i y el j.
	 * Si el grafo es orientado i es el extremo inicial del arco. Si ya
	 * existia la conexion, se actualiza su coste.
	 */
	public void conectar(int i, int j, int coste) {
		super.conectar(i, j);
		costes[i][j] = coste;
		if (clase == ClaseGrafo.NoORIENTADO)
			costes[j][i] = coste;
	}

	/**
	 * Devuelve el coste del arco o arista (i,j), si los vetices i y j
	 * estan conectados. Si no lo estan, devuelve Integer.MAX_VALUE.
	 */
	public int coste(int i, int j) {
		if (conectados(i, j))
			return costes[i][j];
		else
			return Integer.MAX_VALUE; // "infinito"
	}

	public int[][] getCostes() {
		return costes;
	}
}
