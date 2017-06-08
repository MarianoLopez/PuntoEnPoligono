/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.z.poligonotest.DAO;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.z.poligonotest.Modelos.Establecimiento;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 *
 * @author 36194445
 */
public class EstablecimientosDAO {
     public static List<Establecimiento> getAll() throws IOException{
        List<Establecimiento> establecimientos = new ArrayList<>();
        String url = "http://mic.mec.gob.ar:8080/APIv1/establecimientos?departamentos=9";//establecimientos de corrientes capital
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.addHeader("Content-Type", "application/json;charset=UTF-8");
        try{
            HttpResponse response = client.execute(request);
            System.out.println("Response Code : "+ response.getStatusLine().getStatusCode());
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {result.append(line);}
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(result.toString());
            actualObj.forEach((node) -> {
                if(!node.get("geo").isNull()){
                    establecimientos.add(new Establecimiento(Integer.parseInt(node.get("cue").toString()),
                        Integer.parseInt(node.get("anexo").toString()),
                        Float.parseFloat(node.get("geo").get("latitud").toString()),
                        Float.parseFloat(node.get("geo").get("longitud").toString())));
                }
            });
        }catch(UnknownHostException e){
            System.out.println(e.toString());
        }
        
        return establecimientos;
    }
}
