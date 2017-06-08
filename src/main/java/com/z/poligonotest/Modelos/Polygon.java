/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest.Modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 36194445
 */
public class Polygon {
    private Region region;

    public Polygon(String coordinates) {
        setRegion(coordinates);
    }
 
    public Region getRegion(){
        return this.region;
    }
    private void setRegion(Region region){
        this.region = region;
    }
    
    private void setRegion(String s){
        String a[] = s.replace(",0", ",").split(",");
        List<Coordinate> coors = new ArrayList<>();
        for(int i=0;i<a.length;i=i+2){
            coors.add(new Coordinate(Float.parseFloat(a[i+1]), Float.parseFloat(a[i])));
        }
        this.setRegion(new Region(coors));
    }
    
    public boolean coordinateInRegion(Coordinate coord) {
        /*System.out.println("Coor: "+coord.getLatitude()+", "+coord.getLongitude());
        for (Coordinate cor : region.getBoundary()) {
            System.out.println(cor.getLatitude()+", "+cor.getLongitude());
        }*/
        /*https://stackoverflow.com/questions/12083093/how-to-define-if-a-determinate-point-is-inside-a-region-lat-long*/
        int i, j;
        boolean isInside = false;
        //create an array of coordinates from the region boundary list
        Coordinate[] verts = this.getRegion().getBoundary().toArray(new Coordinate[this.getRegion().getBoundary().size()]);
        int sides = verts.length;
        for (i = 0, j = sides - 1; i < sides; j = i++) {
            //verifying if your coordinate is inside your region
            if (
                (
                 (
                  (verts[i].getLongitude() <= coord.getLongitude()) && (coord.getLongitude() < verts[j].getLongitude())
                 ) || (
                  (verts[j].getLongitude() <= coord.getLongitude()) && (coord.getLongitude() < verts[i].getLongitude())
                 )
                ) &&
                (coord.getLatitude() < (verts[j].getLatitude() - verts[i].getLatitude()) * (coord.getLongitude() - verts[i].getLongitude()) / (verts[j].getLongitude() - verts[i].getLongitude()) + verts[i].getLatitude())
               ) {
                isInside = !isInside;
            }
        }
        return isInside;
    }
    
}
