package com.company;

class Profesores {

    String nombre;
    int id_prof;
    int rp_prof;
    String fn_prof;
    String fc_prof;
    String g;

    public Profesores(String nombre,int id_prof,int rp_prof,String fn_prof,String fc_prof,String g) {
        this.nombre = nombre;
        this.id_prof = id_prof;
        this.rp_prof = rp_prof;
        this.fn_prof = fn_prof;
        this.fc_prof = fc_prof;
        this.g = g;
    }

    public String getnombre() {
        return nombre;
    }


    public void setnombre(String nombre) {

        this.nombre = nombre;
    }

    public int getid_prof() {
        return id_prof;
    }

    public void setid_prof(int id_prof) {
        this.id_prof = id_prof;
    }

    public int getrp_prof() {
        return rp_prof;
    }

    public void setrp_prof(int rp_prof) {
        this.rp_prof = rp_prof;
    }

    public String getfn_prof() {
        return fn_prof;
    }

    public void setfn_prof(String fn_prof) {
        this.fn_prof = fn_prof;
    }

    public String getfc_prof() {
        return fc_prof;
    }

    public void setfc_prof(String fc_prof) {
        this.fc_prof = fc_prof;
    }

    public String getg() {
        return g;
    }

    public void setg(String g) {
        this.g = g;
    }


    public void ImpFicha(){
        System.out.println("Ficha del Profesor");
        System.out.println("Nombre: " + nombre);
        System.out.println("ID: " + id_prof);
        System.out.println("Registro Personal: " + rp_prof);
        System.out.println("Fecha de naciemnto: " + fn_prof);
        System.out.println("Fecha de Contratación: " + fc_prof);
        System.out.println("Genero: " + g);
    }
}
