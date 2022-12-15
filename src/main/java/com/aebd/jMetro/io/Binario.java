package com.aebd.jMetro.io;

import java.io.*;
import java.util.ArrayList;

public class Binario implements Archivable {

    private String nombre;

    public Binario(String nombre) {
        this.nombre = nombre;
    }

    public Binario() {
        this.nombre = "default.dat";
    }

    @Override
    public ArrayList<Object> leer() throws FileNotFoundException, IOException {
        ArrayList<Object> lista = new ArrayList<Object>();
        /*
         * try{
         * ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nombre));
         * lista = (ArrayList<Object>) ois.readObject();
         * ois.close();
         * }catch(EOFException e){
         * 
         * }catch(Exception e){
         * 
         * }
         */
        return lista;
    }

    @Override
    public void escribir(Object o) throws FileNotFoundException, IOException {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre));
            oos.writeObject(o);
            oos.flush();
            oos.close();
        } catch (EOFException e) {

        } catch (Exception e) {

        }
    }

    @Override
    public void escribir(ArrayList<Object> list) throws FileNotFoundException, IOException {
        ;
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nombre));
            oos.writeObject(list);
            oos.flush();
            oos.close();
        } catch (IOException e) {

        }
    }
}