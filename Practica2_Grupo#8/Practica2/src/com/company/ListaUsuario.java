package com.company;

import java.util.Vector;

public class ListaUsuario {
    private static Vector<Usuarios> datos = new Vector<Usuarios>(5);

    public static void agregar(Usuarios obj){
            datos.addElement(obj);

    }
    public static void eliminar(int pos){
        datos.removeElementAt(pos);
    }
    public static Vector mostrar(){
        return datos;

    }
}
