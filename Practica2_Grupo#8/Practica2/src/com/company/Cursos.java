package com.company;

public class Cursos {
    private int id;
    private int cod;
    private String name;

    public Cursos(int id, int cod, String name) {
        this.id = id;
        this.cod = cod;
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod() {
        return this.cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
