package com.aebd.jMetro.metro;

import java.io.IOException;
import java.util.LinkedList;

import com.aebd.jMetro.graphs.AlgoritmosGrafos;
import com.aebd.jMetro.graphs.ClaseGrafo;
import com.aebd.jMetro.graphs.GrafoCostes;
import com.aebd.jMetro.io.Datos;
import com.aebd.jMetro.misc.GetResource;
import com.aebd.jMetro.misc.Maths;

public class Metro {

	private static final int NUM_EST = 276;

	private static Estacion[] estaciones = new Estacion[NUM_EST];

	private static GrafoCostes distancia = new GrafoCostes(ClaseGrafo.NoORIENTADO, NUM_EST);

	// private GrafoCostes tiempo;

	private static Metro INSTANCE = new Metro();

	private Metro() {

		inicializarEstaciones();
		Maths.inicializarMatriz(distancia.getCostes());

		try {
			cargarDistancias();
		} catch (IOException e) {
		}

		// cargarTiempos();
		/* Queda por añadir los tiempos entre cada estación */

	}

	private static void inicializarEstaciones() {

		estaciones[0] = new Estacion("Abrantes");
		estaciones[1] = new Estacion("Acacias");
		estaciones[2] = new Estacion("Aeropuerto T1-T2-T3");
		estaciones[3] = new Estacion("Aeropuerto T4");
		estaciones[4] = new Estacion("Alameda de Osuna");
		estaciones[5] = new Estacion("Alcorcón Central");
		estaciones[6] = new Estacion("Alfonso XIII");
		estaciones[7] = new Estacion("Almendrales");
		estaciones[8] = new Estacion("Alonso Cano");
		estaciones[9] = new Estacion("Alonso de Mendoza");
		estaciones[10] = new Estacion("Alonso Martinez");
		estaciones[11] = new Estacion("Alsacia");
		estaciones[12] = new Estacion("Alto de Extremadura");
		estaciones[13] = new Estacion("Alto del Arenal");
		estaciones[14] = new Estacion("Aluche");
		estaciones[15] = new Estacion("Alvarado");
		estaciones[16] = new Estacion("Álvarez de Villaamil");
		estaciones[17] = new Estacion("Antón Martín");
		estaciones[18] = new Estacion("Antonio Machado");
		estaciones[19] = new Estacion("Antonio Saura");
		estaciones[20] = new Estacion("Arganda del Rey");
		estaciones[21] = new Estacion("Arganzuela-Planetario");
		estaciones[22] = new Estacion("Arguelles");
		estaciones[23] = new Estacion("Arroyo Culebro");
		estaciones[24] = new Estacion("Artilleros");
		estaciones[25] = new Estacion("Arturo Soria");
		estaciones[26] = new Estacion("Ascao");
		estaciones[27] = new Estacion("Atocha");
		estaciones[28] = new Estacion("Atocha Renfe");
		estaciones[29] = new Estacion("Avenida de América");
		estaciones[30] = new Estacion("Avenida de Europa");
		estaciones[31] = new Estacion("Avenida de Guadalajara");
		estaciones[32] = new Estacion("Avenida de la Ilustración");
		estaciones[33] = new Estacion("Avenida de la Paz");
		estaciones[34] = new Estacion("Aviación Española");
		estaciones[35] = new Estacion("Bambú");
		estaciones[36] = new Estacion("Banco de España");
		estaciones[37] = new Estacion("Barajas");
		estaciones[38] = new Estacion("Barrio de la Concepción");
		estaciones[39] = new Estacion("Barrio del Pilar");
		estaciones[40] = new Estacion("Barrio del Puerto");
		estaciones[41] = new Estacion("Batán");
		estaciones[42] = new Estacion("Baunatal");
		estaciones[43] = new Estacion("Begoña");
		estaciones[44] = new Estacion("Bélgica");
		estaciones[45] = new Estacion("Berna");
		estaciones[46] = new Estacion("Bilbao");
		estaciones[47] = new Estacion("Blasco Ibáñez");
		estaciones[48] = new Estacion("Boadilla Centro");
		estaciones[49] = new Estacion("Buenos Aires");
		estaciones[50] = new Estacion("Callao");
		estaciones[51] = new Estacion("Campamento");
		estaciones[52] = new Estacion("Campo de las Naciones");
		estaciones[53] = new Estacion("Campus de Somosaguas");
		estaciones[54] = new Estacion("Canal");
		estaciones[55] = new Estacion("Canillas");
		estaciones[56] = new Estacion("Canillejas");
		estaciones[57] = new Estacion("Cantabria");
		estaciones[58] = new Estacion("Carabanchel");
		estaciones[59] = new Estacion("Carabanchel Alto");
		estaciones[60] = new Estacion("Carpetana");
		estaciones[61] = new Estacion("Cartagena");
		estaciones[62] = new Estacion("Casa de Campo");
		estaciones[63] = new Estacion("Casa del Reloj");
		estaciones[64] = new Estacion("Chamartin");
		estaciones[65] = new Estacion("Chueca");
		estaciones[66] = new Estacion("Ciudad de la Imagen");
		estaciones[67] = new Estacion("Ciudad de los Ángeles");
		estaciones[68] = new Estacion("Ciudad del Cine");
		estaciones[69] = new Estacion("Ciudad Lineal");
		estaciones[70] = new Estacion("Ciudad Universitaria");
		estaciones[71] = new Estacion("Cocheras");
		estaciones[72] = new Estacion("Colombia");
		estaciones[73] = new Estacion("Colón");
		estaciones[74] = new Estacion("Colonia de los Ángeles");
		estaciones[75] = new Estacion("Colonia Jardín");
		estaciones[76] = new Estacion("Concha Espina");
		estaciones[77] = new Estacion("Conde de Casal");
		estaciones[78] = new Estacion("Congosto");
		estaciones[79] = new Estacion("Conservatorio");
		estaciones[80] = new Estacion("Coslada Central");
		estaciones[81] = new Estacion("Cruz del Rayo");
		estaciones[82] = new Estacion("Cuatro Caminos");
		estaciones[83] = new Estacion("Cuatro Vientos");
		estaciones[84] = new Estacion("Cuzco");
		estaciones[85] = new Estacion("Delicias");
		estaciones[86] = new Estacion("Diego de León");
		estaciones[87] = new Estacion("Dos Castillas");
		estaciones[88] = new Estacion("Duque de Pastrana");
		estaciones[89] = new Estacion("El Bercial");
		estaciones[90] = new Estacion("El Capricho");
		estaciones[91] = new Estacion("El Carmen");
		estaciones[92] = new Estacion("El Carrascal");
		estaciones[93] = new Estacion("El Casar");
		estaciones[94] = new Estacion("Embajadores");
		estaciones[95] = new Estacion("Empalme");
		estaciones[96] = new Estacion("Esperanza");
		estaciones[97] = new Estacion("Estación de Aravaca");
		estaciones[98] = new Estacion("Estadio Olímpico");
		estaciones[99] = new Estacion("Estrecho");
		estaciones[100] = new Estacion("Estrella");
		estaciones[101] = new Estacion("Eugenia de Montijo");
		estaciones[102] = new Estacion("Ferial de Boadilla");
		estaciones[103] = new Estacion("Francos Rodríguez");
		estaciones[104] = new Estacion("Fuencarral");
		estaciones[105] = new Estacion("Fuenlabrada Central");
		estaciones[106] = new Estacion("Fuente de la Mora");
		estaciones[107] = new Estacion("García Noblejas");
		estaciones[108] = new Estacion("Getafe Central");
		estaciones[109] = new Estacion("Goya");
		estaciones[110] = new Estacion("Gran Vía");
		estaciones[111] = new Estacion("Gregorio Marañón");
		estaciones[112] = new Estacion("Guzmán el Bueno");
		estaciones[113] = new Estacion("Henares");
		estaciones[114] = new Estacion("Herrera Oria");
		estaciones[115] = new Estacion("Hortaleza");
		estaciones[116] = new Estacion("Hospital 12 de Octubre");
		estaciones[117] = new Estacion("Hospital de Fuenlabrada");
		estaciones[118] = new Estacion("Hospital de Móstoles");
		estaciones[119] = new Estacion("Hospital del Henares");
		estaciones[120] = new Estacion("Hospital Infanta Sofía");
		estaciones[121] = new Estacion("Hospital Severo Ochoa");
		estaciones[122] = new Estacion("Ibiza");
		estaciones[123] = new Estacion("Iglesia");
		estaciones[124] = new Estacion("Infante Don Luis");
		estaciones[125] = new Estacion("Islas Filipinas");
		estaciones[126] = new Estacion("Jarama");
		estaciones[127] = new Estacion("Joaquín Vilumbrales");
		estaciones[128] = new Estacion("José Isbert");
		estaciones[129] = new Estacion("Juan de la Cierva");
		estaciones[130] = new Estacion("Julián Besteiro");
		estaciones[131] = new Estacion("La Almudena");
		estaciones[132] = new Estacion("La Elipa");
		estaciones[133] = new Estacion("La Fortuna");
		estaciones[134] = new Estacion("La Gavia");
		estaciones[135] = new Estacion("La Granja");
		estaciones[136] = new Estacion("La Latina");
		estaciones[137] = new Estacion("La Moraleja");
		estaciones[138] = new Estacion("La Peseta");
		estaciones[139] = new Estacion("La Poveda");
		estaciones[140] = new Estacion("La Rambla");
		estaciones[141] = new Estacion("Lacoma");
		estaciones[142] = new Estacion("Lago");
		estaciones[143] = new Estacion("Laguna");
		estaciones[144] = new Estacion("Las Musas");
		estaciones[145] = new Estacion("Las Rosas");
		estaciones[146] = new Estacion("Las Suertes");
		estaciones[147] = new Estacion("Las Tablas");
		estaciones[148] = new Estacion("Lavapies");
		estaciones[149] = new Estacion("Leganés Central");
		estaciones[150] = new Estacion("Legazpi");
		estaciones[151] = new Estacion("Lista");
		estaciones[152] = new Estacion("Loranca");
		estaciones[153] = new Estacion("Los Espartales");
		estaciones[154] = new Estacion("Lucero");
		estaciones[155] = new Estacion("Manoteras");
		estaciones[156] = new Estacion("Manuel Becerra");
		estaciones[157] = new Estacion("Manuel de Falla");
		estaciones[158] = new Estacion("Manuela Malasaña");
		estaciones[159] = new Estacion("Mar de Cristal");
		estaciones[160] = new Estacion("María Tudor");
		estaciones[161] = new Estacion("Marqués de la Valdavia");
		estaciones[162] = new Estacion("Marqués de Vadillo");
		estaciones[163] = new Estacion("Méndez Álvaro");
		estaciones[164] = new Estacion("Menéndez Pelayo");
		estaciones[165] = new Estacion("Metropolitano");
		estaciones[166] = new Estacion("Miguel Hernández");
		estaciones[167] = new Estacion("Mirasierra");
		estaciones[168] = new Estacion("Moncloa");
		estaciones[169] = new Estacion("Montecarmelo");
		estaciones[170] = new Estacion("Montepríncipe");
		estaciones[171] = new Estacion("Móstoles Central");
		estaciones[172] = new Estacion("Noviciado");
		estaciones[173] = new Estacion("Nueva Numancia");
		estaciones[174] = new Estacion("Nuevo Mundo");
		estaciones[175] = new Estacion("Nuevos Ministerios");
		estaciones[176] = new Estacion("Nuñez de Balboa");
		estaciones[177] = new Estacion("O'Donell");
		estaciones[178] = new Estacion("Opañel");
		estaciones[179] = new Estacion("Ópera");
		estaciones[180] = new Estacion("Oporto");
		estaciones[181] = new Estacion("Pacifico");
		estaciones[182] = new Estacion("Palas de Rey");
		estaciones[183] = new Estacion("Palos de la Frontera");
		estaciones[184] = new Estacion("Pan Bendito");
		estaciones[185] = new Estacion("Parque de las Avenidas");
		estaciones[186] = new Estacion("Parque de los Estados");
		estaciones[187] = new Estacion("Parque de Santa María");
		estaciones[188] = new Estacion("Parque Europa");
		estaciones[189] = new Estacion("Parque Lisboa");
		estaciones[190] = new Estacion("Parque Oeste");
		estaciones[191] = new Estacion("Pavones");
		estaciones[192] = new Estacion("Peñagrande");
		estaciones[193] = new Estacion("Pinar de Chamartín");
		estaciones[194] = new Estacion("Pinar del Rey");
		estaciones[195] = new Estacion("Pío XII");
		estaciones[196] = new Estacion("Piramides");
		estaciones[197] = new Estacion("Pitis");
		estaciones[198] = new Estacion("Plaza de Castilla");
		estaciones[199] = new Estacion("Plaza de España");
		estaciones[200] = new Estacion("Plaza Elíptica");
		estaciones[201] = new Estacion("Portazgo");
		estaciones[202] = new Estacion("Pozuelo Oeste");
		estaciones[203] = new Estacion("Pradillo");
		estaciones[204] = new Estacion("Prado de la Vega");
		estaciones[205] = new Estacion("Prado del Espino");
		estaciones[206] = new Estacion("Prado del Rey");
		estaciones[207] = new Estacion("Príncipe de Vergara");
		estaciones[208] = new Estacion("Príncipe Pío");
		estaciones[209] = new Estacion("Prosperidad");
		estaciones[210] = new Estacion("Pueblo Nuevo");
		estaciones[211] = new Estacion("Puente de Vallecas");
		estaciones[212] = new Estacion("Puerta de Arganda");
		estaciones[213] = new Estacion("Puerta de Boadilla");
		estaciones[214] = new Estacion("Puerta de Toledo");
		estaciones[215] = new Estacion("Puerta del Ángel");
		estaciones[216] = new Estacion("Puerta del Sur");
		estaciones[217] = new Estacion("Quevedo");
		estaciones[218] = new Estacion("Quintana");
		estaciones[219] = new Estacion("República Argentina");
		estaciones[220] = new Estacion("Retamares");
		estaciones[221] = new Estacion("Retiro");
		estaciones[222] = new Estacion("Reyes Católicos");
		estaciones[223] = new Estacion("Ríos Rosas");
		estaciones[224] = new Estacion("Rivas Futura");
		estaciones[225] = new Estacion("Rivas-Urbanizaciones");
		estaciones[226] = new Estacion("Rivas Vaciamadrid");
		estaciones[227] = new Estacion("Ronda de la Comunicación");
		estaciones[228] = new Estacion("Rubén Darío");
		estaciones[229] = new Estacion("Sáinz de Baranda");
		estaciones[230] = new Estacion("San Bernardo");
		estaciones[231] = new Estacion("San Blas");
		estaciones[232] = new Estacion("San Cipriano");
		estaciones[233] = new Estacion("San Cristóbal");
		estaciones[234] = new Estacion("San Fermín-Orcasur");
		estaciones[235] = new Estacion("San Fernando");
		estaciones[236] = new Estacion("San Francisco");
		estaciones[237] = new Estacion("San Lorenzo");
		estaciones[238] = new Estacion("San Nicasio");
		estaciones[239] = new Estacion("Santiago Bernabéu");
		estaciones[240] = new Estacion("Santo Domingo");
		estaciones[241] = new Estacion("Serrano");
		estaciones[242] = new Estacion("Sevilla");
		estaciones[243] = new Estacion("Sierra de Guadalupe");
		estaciones[244] = new Estacion("Siglo XXI");
		estaciones[245] = new Estacion("Simancas");
		estaciones[246] = new Estacion("Sol");
		estaciones[247] = new Estacion("Somosaguas Centro");
		estaciones[248] = new Estacion("Somosaguas Sur");
		estaciones[249] = new Estacion("Suanzes");
		estaciones[250] = new Estacion("Tetuán");
		estaciones[251] = new Estacion("Tirso de Molina");
		estaciones[252] = new Estacion("Torre Arias");
		estaciones[253] = new Estacion("Tres Olivos");
		estaciones[254] = new Estacion("Tribunal");
		estaciones[255] = new Estacion("Universidad Rey Juan Carlos");
		estaciones[256] = new Estacion("Urgel");
		estaciones[257] = new Estacion("Usera");
		estaciones[258] = new Estacion("Valdeacederas");
		estaciones[259] = new Estacion("Valdebernardo");
		estaciones[260] = new Estacion("Valdecarros");
		estaciones[261] = new Estacion("Valdezarza");
		estaciones[262] = new Estacion("Velázquez");
		estaciones[263] = new Estacion("Ventas");
		estaciones[264] = new Estacion("Ventilla");
		estaciones[265] = new Estacion("Ventorro del Cano");
		estaciones[266] = new Estacion("Ventura Rodriguez");
		estaciones[267] = new Estacion("Vicálvaro");
		estaciones[268] = new Estacion("Villa de Vallecas");
		estaciones[269] = new Estacion("Villaverde Alto");
		estaciones[270] = new Estacion("Villaverde Bajo-Cruce");
		estaciones[271] = new Estacion("Vinateros");
		estaciones[272] = new Estacion("Virgen del Cortijo");
		estaciones[273] = new Estacion("Vista Alegre");
		estaciones[274] = new Estacion("Arroyofresno");
		estaciones[275] = new Estacion("Paco de Lucía");
	}

	private static void cargarDistancias() throws IOException {

		GetResource d = new GetResource();

		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl01.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl02.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl03.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl04.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl05.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl06.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl07.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl08.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl09.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl10.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl11.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl12.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl13.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl14.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl15.dbs"), distancia);
		Datos.cargar(d.getResource("/com/aebd/jMetro/files/dl16.dbs"), distancia);
	}

	/*
	 * En "dist" devuelve la distancia entre inicio y fin"
	 */
	public LinkedList<String> rutaMinima(int inicio, int fin) {

		int[][] path = AlgoritmosGrafos.calculePath(distancia.getCostes());

		AlgoritmosGrafos.floyd(distancia, path);

		LinkedList<Integer> l = AlgoritmosGrafos.rPath(inicio, fin, path);

		LinkedList<String> a = new LinkedList<String>();

		for (int i = 0; i < l.size(); i++) {
			a.addLast(estaciones[l.get(i)].getNombre());
		}

		return a;

	}

	public int getDistancia(int inicio, int fin) {

		int[][] path = AlgoritmosGrafos.calculePath(distancia.getCostes());

		int[][] shortpath = AlgoritmosGrafos.floyd(distancia, path);

		return shortpath[inicio][fin];
	}

	/*
	 * private void cargarTiempos(){
	 * // Queda por implementar
	 * }
	 */

	public int getNumEstaciones() {
		return NUM_EST;
	}

	public static Metro getInstance() {
		return INSTANCE;
	}

	public Estacion[] getEstaciones() {
		return estaciones;
	}

	public String[] getNombreEstaciones() {
		String a[] = new String[NUM_EST];
		for (int i = 0; i < NUM_EST; i++) {
			a[i] = getEstaciones()[i].getNombre();
		}

		return a;
	}

}
