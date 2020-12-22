package com.aebd.jMetro.io;

import java.io.*;
import java.util.ArrayList;

public class Texto implements Archivable{
    
    private String nombre;
    
    public Texto(String nombre){
        this.nombre = nombre;       
    }
    
    public Texto(File archivo) throws IOException{
        this.nombre = archivo.getCanonicalPath();
    }
    
    public Texto(){
       this.nombre = "default.txt";
    }
    
    @Override
    public ArrayList<Object> leer() throws FileNotFoundException, IOException{        
    	File f = new File(nombre);    	
    	ArrayList<Object> lista = new ArrayList<Object>();
    	FileReader fr = new FileReader(f);
    	BufferedReader bw = new BufferedReader(fr);
    	String linea;
    	try{
    		
	    	while((linea = bw.readLine()) != null){
	    		lista.add(linea);
	    	}
	    	
    	}catch(IOException e){
    	
    	}finally{
     
            fr.close();     
        }  
    
    	return lista;
    }

    @Override
    public void escribir(Object o) throws FileNotFoundException, IOException {
        File f = new File(nombre); 
        try{
            FileWriter w = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            bw.append(o.toString());
            bw.newLine();
            wr.close();
            bw.close();
        }catch(IOException e){};
    }

    @Override
    public void escribir(ArrayList<Object> list) throws FileNotFoundException, IOException {
        File f = new File(nombre);
        try{
            FileWriter w = new FileWriter(f,true);
            BufferedWriter bw = new BufferedWriter(w);
            PrintWriter wr = new PrintWriter(bw);
            for(int i = 0; i < list.size(); i++){
                bw.append(list.get(i).toString());
                bw.newLine();
                wr.close();
                bw.close();
            }
        }catch(IOException e){};
 
    }         
}
