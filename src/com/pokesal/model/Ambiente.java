package com.pokesal.model;

public class Ambiente {

    private String ambienteNome;
    private TipoElemento tipoElemento;
    private double aumentaAtk;
    private double aumentaDef;
    private double aumentaSpd;

    public Ambiente (String ambienteNome, TipoElemento tipoElemento, double aumentaAtk, double aumentaDef, double aumentaSpd){
        this.ambienteNome = ambienteNome;
        this.tipoElemento = tipoElemento;
        this.aumentaAtk = aumentaAtk;
        this.aumentaDef = aumentaDef;
        this.aumentaSpd = aumentaSpd;
    }

    public String getNome() {
        return ambienteNome;
    }

    public void setNome(String ambienteNome) {
        this.ambienteNome = ambienteNome;
    }

    public TipoElemento getTipoElemento() {
        return tipoElemento;
    }

    public void setTipoElemento(TipoElemento tipoElemento) {
        this.tipoElemento = tipoElemento;
    }

    public double getAumentaAtk() {
        return aumentaAtk;
    }

    public void setAumentaAtk(double aumentaAtk) {
        this.aumentaAtk = aumentaAtk;
    }

    public double getAumentaDef() {
        return aumentaDef;
    }

    public void setAumentaDef(double aumentaDef) {
        this.aumentaDef = aumentaDef;
    }

    public double getAumentaSpd() {
        return aumentaSpd;
    }

    public void setAumentaSpd(double aumentaSpd) {
        this.aumentaSpd = aumentaSpd;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Ambiente{" +
                "nome do ambiente='" + ambienteNome + '\'' +
                ", tipoElemento=" + tipoElemento +
                ", aumentaAtk=" + aumentaAtk +
                ", aumentaDef=" + aumentaDef +
                ", aumentaSpd=" + aumentaSpd +
                '}';
    }
}
 

