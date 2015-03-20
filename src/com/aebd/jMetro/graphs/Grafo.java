package com.aebd.jMetro.graphs;
/**
 * Implementaci�n de un grafo simple formado por v�rtices que son n�meros
 * enteros positivos y arcos que los conectan.
 */

public class Grafo {
	ClaseGrafo clase;	// ORIENTADO/NoORIENTADO
	int nV;				// n�mero de v�rtices
	int adyacencia[][]; // matriz de adyacencia

	public Grafo(ClaseGrafo claseGrafo, int n) {
		clase = claseGrafo;
		nV    = n;
		adyacencia = new int[n][n];
		for (int i = 0; i < nV; i++){
			for (int j = 0; j < nV; j++)
				adyacencia[i][j] = 1;
		}
	}

	/**
	 * Establece un arco o arista entre el v�rtice i y el j.
	 * Si el grafo es orientado i es el extremo inicial del arco.
	 */
	public void conectar(int i, int j) {
		adyacencia[i][j] = 1;
		if (clase == ClaseGrafo.NoORIENTADO) adyacencia[j][i] = 1;
	}
	
	/**
	 * Elimina el arco o arista que haya entre el v�rice i y el j.
	 * Si el grafo es orientado i es el extremo inicial del arco.
	 * Si el arco o arista a eliminar no existen no ocurre nada.
	 */
	public void desconectar(int i, int j) {
		adyacencia[i][j] = 0;
		if (clase == ClaseGrafo.NoORIENTADO) adyacencia[j][i] = 0;
	}
	
	/**
	 * Devuelve true si existe un arco o arista entre el v�rtice
 	 * i y el j, y fase si no.
	 * Si el grafo es orientado i es el extremo inicial del arco.
	 */
	public boolean conectados(int i, int j) {
		return adyacencia[i][j] == 1;
	}
	
	/**
	 * Devuelve el n�mero de v�rtices del grafo.
	 * @return
	 */
	public int vertices() {
		return nV;
	}
	
	
	public int[][] getAdy(){
		return adyacencia;
	}
}
