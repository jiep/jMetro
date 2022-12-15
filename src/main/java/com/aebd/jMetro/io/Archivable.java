package com.aebd.jMetro.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface Archivable {

    public ArrayList<Object> leer() throws FileNotFoundException, IOException;

    public void escribir(Object o) throws FileNotFoundException, IOException;

    public void escribir(ArrayList<Object> list) throws FileNotFoundException, IOException;

}
