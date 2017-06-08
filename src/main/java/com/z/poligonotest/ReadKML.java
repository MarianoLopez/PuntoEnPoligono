/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest;

import com.z.poligonotest.Modelos.Coordinate;
import com.z.poligonotest.Modelos.Folder;
import com.z.poligonotest.Modelos.Placemark;
import com.z.poligonotest.Modelos.Polygon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;


/**
 *
 * @author 36194445
 */
public class ReadKML {
    public static void main(String args[]) throws IOException{
           Folder barrios = new ReadKML().getPlaceMarksFromKML("BarriosCiudadCORRIENTES.kml");
           Coordinate toFind = new Coordinate(new Float(-27.5009338), new Float(-58.8386009));
           System.out.println("Coor in barrio: "+barrios.getBarrioFromCoordinate(toFind));
    }
    
    /*KML (del acrónimo en inglés Keyhole Markup Language)
        es un lenguaje de marcado basado en XML para representar datos geográficos en tres dimensiones.*/
    public Folder getPlaceMarksFromKML(String resourceName)throws IOException{
        File f = new File(getClass().getClassLoader().getResource(resourceName).getFile());
        String kml = FileUtils.readFileToString(f);
        Document doc = Jsoup.parse(kml, "", Parser.xmlParser());
        List<Placemark> barrios = new ArrayList<>();
        String placemarkName;
        Polygon polygon;
        for (Element e : doc.select("Folder")) {
            for(Element place : e.select("Placemark")){
                placemarkName= place.select("name").text();
                polygon = new Polygon(place.select("coordinates").text());
                barrios.add(new Placemark(placemarkName, polygon));
            }
        }
        return new Folder(barrios);
    }
}
