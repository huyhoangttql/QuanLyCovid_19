/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Bean.CountryDataBean;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author levietdung
 */
public class StatisticsPanelController {
    
    private static final String url = "https://www.worldometers.info/coronavirus/";
    private static ArrayList<CountryDataBean> dataRecord = new ArrayList<CountryDataBean>();
    private static int vnIndex = 0;
    
    public static ArrayList<CountryDataBean> getData(){
        
        int counter = -1;
        
        try {
            Document source = Jsoup.connect(url).timeout(30*1000).get();
	    Element table = source.select("tbody").first();
	    Elements rows = table.select("tr");
	    for (Element row: rows) {
	    	Elements data = row.select("td");
                counter++;
	    	if (data.get(1).text().equals("Vietnam")) {
                    vnIndex = counter;
	    	}
                dataRecord.add(new CountryDataBean(data.get(1).text(), data.get(2).text(), data.get(3).text(), data.get(4).text(), data.get(5).text(), data.get(6).text(), data.get(8).text()));
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return dataRecord;
    }
    
    public static int getVNIndex (){
        return StatisticsPanelController.vnIndex;
    }
}
