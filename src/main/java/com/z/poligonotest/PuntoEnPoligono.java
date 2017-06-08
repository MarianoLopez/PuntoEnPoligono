/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest;

import com.z.poligonotest.DAO.EstablecimientosDAO;
import com.z.poligonotest.DAO.FolderDAO;
import com.z.poligonotest.Modelos.Coordinate;
import com.z.poligonotest.Modelos.Establecimiento;
import com.z.poligonotest.Modelos.Folder;
import java.io.IOException;
import java.util.List;


/**
 *
 * @author 36194445
 */
public class PuntoEnPoligono {
    public static void main(String args[]) throws IOException{
        Folder barrios = FolderDAO.getInstance().getFolderFromKML();
        List<Establecimiento> establecimientos = EstablecimientosDAO.getAll();
        System.out.println("Establecimientos con coordenadas: "+establecimientos.size());
        System.out.println("Barrios: "+barrios.getPlacemarks().size());
        System.out.println("Barrios asignados");
        int asignados = 0;
        for (Establecimiento establecimiento : establecimientos) {
            establecimiento.setBarrio(barrios.getBarrioFromCoordinate(new Coordinate(establecimiento.getLatitud(), establecimiento.getLongitud())));
            if(!establecimiento.getBarrio().isEmpty()){
                System.out.println(establecimiento.toString());
                asignados++;
            }
        }
        System.out.println("Cantidad barrios asignados: "+asignados);
        //prueba manual
        /*Coordinate toFind = new Coordinate(new Float(-27.5009338), new Float(-58.8386009));
        System.out.println("Coor in barrio: "+barrios.getBarrioFromCoordinate(toFind));*/
    }
}
