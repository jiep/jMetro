package com.aebd.jMetro.graphs;
import java.util.LinkedList;

import com.aebd.jMetro.misc.Maths;


public abstract class AlgoritmosGrafos {
		
	public static class CosteMin {
		private int vertice, coste;

		public CosteMin() {
			super();
		}
		
		public CosteMin(int v, int c) {
			vertice = v;
			coste = c;
		}
		
		public int getVertice(){
			return vertice;
		}
		
		public int getCoste(){
			return coste;
		}
	}

	// Clase interna auxiliar, representa una arista y su coste
	public static class Arista {
		int v1, v2, coste;

		public Arista() {
			super();
		}
		
		public Arista(int a, int b, int c) {
			v1 = a;
			v2 = b;
			coste = c;
		}
	}
	
	public static void tratar(int i) {};

	/**
	 * Devuelve un conjunto de aristas que forma un arbol de recubrimiento
	 * de coste minimo del grafo g
	 * @return un array con las aristas del arbol de recubrimiento de coste 
	 *         minimo
	 */
	public static Arista[] arbolDeRecubrimiento(GrafoCostes g) {
		Arista[] aristas = new Arista[g.vertices() - 1];
		boolean[] conectados = new boolean[g.vertices()];
		CosteMin[] costesBajos = new CosteMin[g.vertices()];

		// Se toma el vertice 0 como primer vertice del arbol de 
		// recubrimiento y se calculan las aristas de coste minimo
		// desde el vertice 0 a cada uno de los otros
		for (int i = 0; i < conectados.length; i++) {
			conectados[i] = false;
			costesBajos[i] = new CosteMin(0, g.coste(0, i));
		}
		conectados[0] = true;

		// Se completa el arbol de recubrimiento seleccionando en
		// cada iteracion la arista de coste minimo entre los vertices
		// conectados y los no conectados.
		for (int i = 1; i < g.vertices(); i++) {
			int minimo = Integer.MAX_VALUE;
			int vertMin = -1;
			for (int j = 2; j < g.vertices(); j++) {
				if ((!conectados[j]) && (costesBajos[j].coste) < minimo) {
					minimo = costesBajos[j].coste;
					vertMin = j;
				}
			}

			// Se incluye la arista seleccionada en el arbol de
			// recubrimiento de coste minimo
			aristas[i - 1] = new Arista();
			aristas[i - 1].v1 = vertMin;
			aristas[i - 1].v2 =  costesBajos[vertMin].vertice;
			aristas[i - 1].coste = costesBajos[vertMin].coste;
			conectados[vertMin]  = true;
			
			// Se recalculan las aristas de coste minimo entre los vertices
			// conectados y los no conectados teniendo en cuenta el vertice
			// recien conectado
			for (int j = 1; j < g.vertices(); j++) {
				if ((!conectados[j]) && (g.coste(vertMin, j) < costesBajos[j].coste)) {
					costesBajos[j] = new CosteMin(vertMin, g.coste(vertMin, j));
				}
			}	
		}

		return aristas;
	}

	/**
	 * Calcula el coste y vertice responsable de cada camino de coste minimo
	 * deste fuente a cada vertice de g
	 * @return un array con los costes de los caminos de la fuente a cada
	 *         vertice
	 */
	public static CosteMin[] costesDesdeFuente(GrafoCostes g, int fuente) {
		CosteMin[] caminos = new CosteMin[g.vertices()];
		boolean[] tratados = new boolean[g.vertices()];

		// Inicializar el conjunto de vertices tratados con la fuente y
		// calcular el coste directo desde la fuente a cada vertice
		for (int i = 0; i < g.vertices(); i++) {
			tratados[i] = false;
			caminos[i] = new CosteMin();
			caminos[i].vertice = (g.conectados(fuente, i)) ? fuente : -1;
			caminos[i].coste = g.coste(fuente, i);
		}

		// A la fuente se le asigna un coste directo cero 
		caminos[fuente].vertice = fuente;
		caminos[fuente].coste = 0;
		tratados[fuente] = true;

		// Se calculan los costes minimos desde fuente a 
		// todos los demas vertices
		for (int j = 0; j < g.vertices() - 1; j++) {
			//Se determina el nuevo vertice pendiente de coste
			//minimo desde Fuente
			int costeMinimo, costeAux, vertCosteMin;
			costeMinimo = Integer.MAX_VALUE;
			vertCosteMin = -1;

			for (int i = 0; i < g.vertices(); i++) {
				if (!tratados[i])
					if (caminos[i].coste <= costeMinimo) {
						costeMinimo = caminos[i].coste;
						vertCosteMin = i;
					}
			}

			// Se añade el nuevo vertice de coste minimo al conjunto de
			// los tratados y se actualizan los costes de los caminos en
			// funcion del nuevo vertice
			tratados[vertCosteMin] = true;
			for (int i = 0; i < g.vertices(); i++) {
				if (!tratados[i]) {
					if ((Integer.MAX_VALUE - costeMinimo) > g.coste(vertCosteMin, i))
						costeAux = costeMinimo + g.coste(vertCosteMin, i);
					else
						costeAux = Integer.MAX_VALUE;

					if (caminos[i].coste > costeAux) {
						caminos[i].coste = costeAux;
						caminos[i].vertice = vertCosteMin;
					}
				}
			}
		}

		return caminos;
	}

	/**
	 * Recorre en profundidad los vertices de g accesibles desde v,
	 * tratandolos y marcandolos como visitados.
	 */
	private void avanzarEnProfundidad(
		Grafo g,
		int v,
		boolean[] visitados) {

		// El vertice v se marca como visitado	
		visitados[v] = true;

		//Se trata el vertice
		tratar(v);

		// Se examinan los vertices adyacentes a v para
		// continuar el recorrido.
		for (int i = 0; i < g.vertices(); i++)
			if ((v != i) && (!visitados[i]) && (g.conectados(v, i)))
				avanzarEnProfundidad(g, i, visitados);
	}

	/**
	 * Recorre un grafo en profundidad
	 * @param g, grafo a recorrer
	 */
	public void profundidad(Grafo g) {
		boolean visitados[] = new boolean[g.vertices()];

		// Se inicializa visitados, que se pondra a true a medida que 
		// se visiten los vertices.
		for (int i = 0; i < g.vertices(); i++)
			visitados[i] = false;

		// El recorrido se relanza en cada vertice no visitado
		// hasta que lo esten todos.
		for (int i = 0; i < g.vertices(); i++)
			if (!visitados[i])
				avanzarEnProfundidad(g, i, visitados);
	}

	/**
	 * Recorre un grafo en amplitud
	 * @param g, grafo a recorrer
	 */
	public static void amplitud(Grafo g) {
		// Ls lista enCurso se usa como una cola capaz de mantener
		// todos los vertices de G
		LinkedList<Integer> enCurso = new LinkedList<Integer>();
		boolean visitados[] = new boolean[g.vertices()];
		int v; // vertice actual

		// Se inicializa visitados, que se pondra a true a medida que 
		// se visiten los vertices.
		for (int i = 0; i < g.vertices(); i++)
			visitados[i] = false;

		// El recorrido en amplitud se inicia en cada vertice
		// aun no visitado.
		for (int i = 0; i < g.vertices(); i++)
			if (!visitados[i]) {
				// Se pone en la cola el vertice de partida
				// y se marca como visitado.
				enCurso.addLast(new Integer(i));
				visitados[i] = true;

				while (!enCurso.isEmpty()) {
					// Se toma el vertice que esta en el frente
					// de la cola y se trata.
					v = ((Integer) enCurso.removeFirst()).intValue();
					// tratar
					tratar(v);

					// Todos los vertices adyacentes a v no visitados
					// se incorporran a la cola y se marcan.
					for (int j = 0; j < g.vertices(); j++) {
						if ((v != j)
							&& (g.conectados(v, j) && (!visitados[j]))) {
							enCurso.addLast(new Integer(j));
							visitados[j] = true;
						}
					}
				}
			}
	}
	
	public static int[][] floyd(GrafoCostes g, int[][] path){
		
		int n = g.vertices();
	 	int[][] ans = new int[n][n];
	 
	 	Maths.copy(ans, g.getCostes());
	
	 	for (int k=0; k<n;k++) {
	 		for (int i=0; i<n; i++) {
	     		for (int j=0; j<n;j++) {
	       			if (ans[i][k]+ans[k][j] < ans[i][j]) {
	       				ans[i][j] = ans[i][k]+ans[k][j];
	       				path[i][j] = path[k][j];
	       			}
	       		}
	   		}
	 	}

		return ans;
	}	
	
	public static LinkedList<Integer> rPath(int i, int j, int[][] path){
		LinkedList<Integer> recorrido = new LinkedList<Integer>();
		recorrido.addFirst(j);
		 
	 	while (path[i][j] != i) {
			recorrido.addFirst(path[i][j]);
	 		j = path[i][j];
	 	}
	 	
	 	recorrido.addFirst(i);
	 	
	 	return recorrido;
	}
	
	public static int[][] calculePath(int [][] ady){
		
		int[][] path = new int[ady.length][ady.length];
		
		for (int i=0; i<ady.length; i++)
	 		for (int j=0; j<ady.length; j++)
	 			if (ady[i][j] == Maths.getINFINITO())
	 				path[i][j] = -1;
	 			else
	 				path[i][j] = i;
		
		for (int i=0; i<ady.length; i++)
	 		path[i][i] = i;
		
		
		return path;
	}
		
		
	

}
