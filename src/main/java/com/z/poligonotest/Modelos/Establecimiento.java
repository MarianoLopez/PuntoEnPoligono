/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest.Modelos;

/**
 *
 * @author 36194445
 */
public class Establecimiento {
    private int cue, anexo;
    private float latitud,longitud;
    private String barrio;

    public Establecimiento(int cue, int anexo, float latitud, float longitud) {
        this.cue = cue;
        this.anexo = anexo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return this.getCue()+"-"+this.getAnexo()+", Barrio: "+this.getBarrio();
    }
    
    
    
    public int getCue() {
        return cue;
    }

    public void setCue(int cue) {
        this.cue = cue;
    }

    public int getAnexo() {
        return anexo;
    }

    public void setAnexo(int anexo) {
        this.anexo = anexo;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }
    
    
}
