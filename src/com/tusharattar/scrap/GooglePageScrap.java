/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tusharattar.scrap;

import java.io.IOException;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Attar
 */
public class GooglePageScrap {

    public String scrap(String query, String websiteName) {
        try {
            int returnValue = 0;
            int i;

            searchint:
            for (i = 0; i <= 9; i++) {

                String baseURL = "https://www.google.co.in/search?q=" + query + "&start=" + i * 10;

                Document doc = Jsoup.connect(baseURL)
                        .userAgent("Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)")
                        .timeout(5000)
                        .get();
                Elements results = doc.getElementsByClass("g");
                int pageCounter = 0;
                for (Element result : results) {
                    boolean find = result.text().contains(websiteName);
                    pageCounter++;
                    if (find) {
                        returnValue = pageCounter;
                        break searchint;
                    }
                }
                try {
                    //delaying the process as to prevent google captha
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

            if (returnValue == 0) {
                return "Not found";
            } else {
                return "Positioned at " + (i * 10 + returnValue);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
