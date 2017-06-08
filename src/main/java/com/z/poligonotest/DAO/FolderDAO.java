/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest.DAO;

import com.z.poligonotest.Modelos.Folder;
import com.z.poligonotest.Modelos.Placemark;
import com.z.poligonotest.Modelos.Polygon;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import static org.apache.http.Consts.ISO_8859_1;
import static org.apache.http.Consts.UTF_8;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

/**
 *
 * @author 36194445
 */
public class FolderDAO {
    private static FolderDAO instance = null;
    private String resourceName;
    
    private FolderDAO(String resourceName){
        this.setResourceName(resourceName);
    }

    public String getResourceName() {
        return resourceName;
    }

    private void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }
    
    public static FolderDAO getInstance() {
      if(instance == null) {
         instance = new FolderDAO("BarriosCiudadCORRIENTES.kml");
      }
      return instance;
   }
    
    /*KML (del acrónimo en inglés Keyhole Markup Language)
        es un lenguaje de marcado basado en XML para representar datos geográficos en tres dimensiones.*/
    public Folder getFolderFromKML()throws IOException{
        File f = new File(getClass().getClassLoader().getResource(this.getResourceName()).getFile());
        String kml = FileUtils.readFileToString(f);
        Document doc = Jsoup.parse(kml, "", Parser.xmlParser());
        List<Placemark> barrios = new ArrayList<>();
        String placemarkName;
        Polygon polygon;
        for (Element e : doc.select("Folder")) {
            for(Element place : e.select("Placemark")){
                placemarkName= new String(place.select("name").text().getBytes(ISO_8859_1), UTF_8);
                polygon = new Polygon(place.select("coordinates").text());
                barrios.add(new Placemark(placemarkName, polygon));
            }
        }
        return new Folder(barrios);
    }
}
