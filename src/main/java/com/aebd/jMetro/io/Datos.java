package com.aebd.jMetro.io;

import com.aebd.jMetro.graphs.GrafoCostes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Datos {

	public static void cargar(Texto t, GrafoCostes g) {
		ArrayList<Object> lista = new ArrayList<Object>();
		try {

			lista = t.leer();

		} catch (IOException e) {

		}

		int a[] = new int[3];

		for (int i = 0; i < lista.size(); i++) {
			a = deStringAint((String) lista.get(i));
			g.conectar(a[0], a[1], a[2]);
		}
	}

	public static void cargar(InputStream t, GrafoCostes g) throws IOException {
		ArrayList<Object> lista = new ArrayList<Object>();
		String linea;
		BufferedReader br = new BufferedReader(new InputStreamReader(t));
		try {

			while ((linea = br.readLine()) != null) {
				lista.add(linea);
			}

		} catch (Exception e) {

		} finally {

			br.close();

		}

		int a[] = new int[3];

		for (int i = 0; i < lista.size(); i++) {
			a = deStringAint((String) lista.get(i));
			g.conectar(a[0], a[1], a[2]);
		}
	}

	private static int[] deStringAint(String a) {

		String[] s = a.split(" ");

		int[] i = new int[3];

		for (int j = 0; j < i.length; j++) {
			i[j] = Integer.parseInt(s[j]);
		}

		return i;
	}

}
