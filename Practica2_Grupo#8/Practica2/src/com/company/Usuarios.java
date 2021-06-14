package com.company;

import java.util.Vector;

public class Usuarios {
    private String usuario;
    private String contraseña;


    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    public static Vector mostrar(){
        return ListaUsuario.mostrar();
    }

    public static int Verificar(String usuario){
        Vector lista = mostrar();
        Usuarios obj;
        for (int i = 0; i < lista.size(); i++){
           if (lista.size() <= 8) {
               obj = (Usuarios) lista.elementAt(i);
               if (obj.getUsuario().equalsIgnoreCase(usuario)) {
                   return i;
               }
           }else {
               return 1;
           }
        }
        return -1;
    }

    public static int VerificarC(String contraseña){
        Vector lista = mostrar();
        Usuarios obj;
        for (int i = 0; i < lista.size(); i++){
            obj = (Usuarios) lista.elementAt(i);
            if (obj.getUsuario().equalsIgnoreCase(contraseña)){
                return i;
            }

        }
        return -1;
    }

    public static int VerificarL(String usuario,String contraseña){
        Vector lista = mostrar();
        Usuarios obj;
        for (int i = 0; i < lista.size(); i++){
            obj = (Usuarios) lista.elementAt(i);
            if (obj.getUsuario().equalsIgnoreCase(usuario) && obj.getContraseña().equalsIgnoreCase(contraseña)){
                return i;
            }

        }
        return -1;
    }


}
