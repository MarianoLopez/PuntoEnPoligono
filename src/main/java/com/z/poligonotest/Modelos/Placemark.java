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
public class Placemark {
    private String name;
    private Polygon polygon;

    public Placemark(String name, Polygon polygon) {
        this.name = name;
        this.polygon = polygon;
    }
    
    public Polygon getPolygon() {
        return polygon;
    }
    
    public void setPolygon(Polygon polygon) {
        this.polygon = polygon;
    }
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    
}
