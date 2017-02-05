package com.aebd.jMetro.misc;

public class Maths {
	
	private final static int INFINITO = 1000000;
	
	public static void copy(int[][] a, int[][] b) {

	 	for (int i=0;i<a.length;i++)
	   		for (int j=0;j<a[0].length;j++)
	     		a[i][j] = b[i][j];
	}
	
	
	public static int min(int a, int b) {
	 	if (a < b) 
	   		return a;
	 	else       
	   		return b;
	}
	
	public static void inicializarMatriz(int[][] matriz){
		for(int i = 0; i < matriz.length; i++){
			for(int j = 0; j < matriz.length; j++){
				matriz[i][j] = INFINITO;
			}
		}
	}
	
	public static int getINFINITO() {
		return INFINITO;
	}

}
