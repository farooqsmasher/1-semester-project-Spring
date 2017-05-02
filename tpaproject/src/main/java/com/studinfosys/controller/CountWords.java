package com.studinfosys.controller;

import java.io.BufferedReader;
import java.io.FileReader;

public class CountWords {

    public static void main (String args[]) throws Exception {

       System.out.println ("Counting Words");       
       FileReader fr = new FileReader ("e:\\it login.txt");        
       BufferedReader br = new BufferedReader (fr);     
       String line = br.readLine ();
       int count1 = 0;
       while (line != null) {
          String []parts = line.split(" ");
          for( String w : parts)
          {
            count1++;        
          }
          line = br.readLine();
       }         
       System.out.println(count1);
    }
}