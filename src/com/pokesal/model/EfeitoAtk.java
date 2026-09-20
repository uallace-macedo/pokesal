package com.pokesal.model;

public class EfeitoAtk {
    private String nome;
    private int dano;
    private int redSpeed;
    private int redDef;
    private int rodadas;

    public EfeitoAtk(String nome, int dano, int redSpeed, int redDef, int rodadas) {
        this.nome = nome;
        this.dano = dano;
        this.redSpeed = redSpeed;
        this.redDef = redDef;
        this.rodadas = rodadas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getRedSpeed() {
        return redSpeed;
    }

    public void setRedSpeed(int redSpeed) {
        this.redSpeed = redSpeed;
    }

    public int getRedDef() {
        return redDef;
    }

    public void setRedDef(int redDef) {
        this.redDef = redDef;
    }

    public int getRodadas() {
        return rodadas;
    }

    public void setRodadas(int rodadas) {
        this.rodadas = rodadas;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "EfeitoAtk{" +
                "nome='" + nome + '\'' +
                ", dano=" + dano +
                ", redSpeed=" + redSpeed +
                ", redDef=" + redDef +
                ", rodadas=" + rodadas +
                '}';
    }
}



