/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest.Modelos;

import java.util.List;

/**
 *
 * @author 36194445
 */
public class Folder {
    private List<Placemark> placemarks;

    public Folder(List<Placemark> placemarks) {
        this.setPlacemarks(placemarks);
    }
    
    public String getBarrioFromCoordinate(Coordinate coor){
        String barrio = "";
        for (Placemark placemark : placemarks) {
            if(placemark.getPolygon().coordinateInRegion(coor)){
                barrio = placemark.getName();
                break;
            }
        }
        return barrio;
    }

    
    public List<Placemark> getPlacemarks() {
        return placemarks;
    }

    private void setPlacemarks(List<Placemark> placemarks) {
        this.placemarks = placemarks;
    }
    
    
}
