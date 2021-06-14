package com.company;

public class AsignarAlumnos {
    private ALUMNOS IdAlumnos;
    private Cursos IdCursos;

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

    public AsignarAlumnos(ALUMNOS IdAlumnos, Cursos IdCursos){
        this.IdAlumnos = IdAlumnos;
        this.IdCursos = IdCursos;

    }
}
