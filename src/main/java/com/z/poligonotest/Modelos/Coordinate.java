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
public class Coordinate {
    private float latitude;
    private float longitude;

    public Coordinate(float latitude, float longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

     
    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
    
    
}
