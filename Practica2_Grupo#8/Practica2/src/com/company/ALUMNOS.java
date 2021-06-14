package com.company;

public class ALUMNOS {
    private int id_alumno;
    private int carne_alumno;
    private String nombre_alumno;
    private String fechaNac_alumno;
    private String genero_alumno;
    private int dia;
    private int mes;
    private int año;


    // Encapsular = Ctrl + Alt + Shift + E
// Metodo Constructor = Ctrl + BarraEspaciadora

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public ALUMNOS(int id_alumno, int carne_alumno, String nombre_alumno, String fechaNac_alumno, String genero_alumno, int dia, int mes, int año) {
        this.id_alumno = id_alumno;
        this.carne_alumno = carne_alumno;
        this.nombre_alumno = nombre_alumno;
        this.fechaNac_alumno = fechaNac_alumno;
        this.genero_alumno = genero_alumno;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getCarne_alumno() {
        return carne_alumno;
    }

    public void setCarne_alumno(int carne_alumno) {
        this.carne_alumno = carne_alumno;
    }

    public String getNombre_alumno() {
        return nombre_alumno;
    }

    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    public String getFechaNac_alumno() {
        return fechaNac_alumno;
    }

    public void setFechaNac_alumno(String fechaNac_alumno) {
        this.fechaNac_alumno = fechaNac_alumno;
    }

    public String getGenero_alumno() {
        return genero_alumno;
    }

    public void setGenero_alumno(String genero_alumno) {
        this.genero_alumno = genero_alumno;
    }


}