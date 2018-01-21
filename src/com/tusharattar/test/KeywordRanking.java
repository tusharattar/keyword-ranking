/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tusharattar.test;

import com.tusharattar.scrap.GooglePageScrap;

/**
 *
 * @author Attar
 */
public class KeywordRanking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //enter the keyword to be found
        String keyword = "tusharattar";

        //enter the website e.g. tusharattar.com
        String url = "tusharattar.com";

        GooglePageScrap gScrap = new GooglePageScrap();
        String result = gScrap.scrap(keyword, url);

        //print the result
        System.out.println("Result: " + result);
    }
}
