package com.company;

public class Notas {
    private ALUMNOS IdAlumnos;
    private Cursos IdCursos;
    private double Nota;

    public Notas(ALUMNOS IdAlumnos, Cursos IdCursos, double Nota){
        this.IdAlumnos = IdAlumnos;
        this.IdCursos = IdCursos;
        this.Nota = Nota;

    }

    public ALUMNOS getIdAlumnos() {
        return IdAlumnos;
    }

    public void setIdAlumnos(ALUMNOS idAlumnos) {
        IdAlumnos = idAlumnos;
    }

    public Cursos getIdCursos() {
        return IdCursos;
    }

    public void setIdCursos(Cursos idCursos) {
        IdCursos = idCursos;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }

}
