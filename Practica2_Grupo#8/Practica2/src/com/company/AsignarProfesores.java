package com.company;

public class AsignarProfesores {
    private Profesores IdProfesores;
    private Cursos IdCursos;

    public Profesores getIdProfesores() {
        return IdProfesores;
    }

    public void setIdProfesores(Profesores idProfesores) {
        IdProfesores = idProfesores;
    }

    public Cursos getIdCursos() {
        return IdCursos;
    }

    public void setIdCursos(Cursos idCursos) {
        IdCursos = idCursos;
    }

    public AsignarProfesores(Profesores IdProfesores, Cursos IdCursos){
        this.IdProfesores = IdProfesores;
        this.IdCursos = IdCursos;

    }
}