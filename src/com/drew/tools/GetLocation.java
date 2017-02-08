/**
 * Project Name:ExifTester
 * File Name:GetLocation.java
 * Package Name:com.drew.tools
 * Date:2017年2月5日上午9:34:35
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.drew.tools;

import java.net.URL;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:GetLocation <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月5日 上午9:34:35 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class GetLocation {  
    public static void main(String[] args) {  
        // lat 39.97646       
        //log 116.3039   
//    	String add = getAdd("116.3039", "39.97646");  
        String add = getAdd(convert10Byloglat("104° 5' 29.35\"")+"", convert10Byloglat("30° 42' 21.92\"")+"");  
        JSONObject jsonObject = JSONObject.fromObject(add);  
        JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("addrList"));  
        JSONObject j_2 = JSONObject.fromObject(jsonArray.get(0));  
        String allAdd = j_2.getString("admName");  
        String arr[] = allAdd.split(",");  
        System.out.println("省："+arr[0]+"\n市："+arr[1]+"\n区："+arr[2]);  
    }  
      
    public static String getAdd(String log, String lat ){  
        //lat 小  log  大  
        //参数解释: 纬度,经度 type 001 (100代表道路，010代表POI，001代表门址，111可以同时显示前三项)  
        String urlString = "http://gc.ditu.aliyun.com/regeocoding?l="+lat+","+log+"&type=010";  
        String res = "";     
        try {     
            URL url = new URL(urlString);    
            java.net.HttpURLConnection conn = (java.net.HttpURLConnection)url.openConnection();    
            conn.setDoOutput(true);    
            conn.setRequestMethod("POST");    
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(conn.getInputStream(),"UTF-8"));    
            String line;    
           while ((line = in.readLine()) != null) {    
               res += line+"\n";    
         }    
            in.close();    
        } catch (Exception e) {    
            System.out.println("error in wapaction,and e is " + e.getMessage());    
        }   
        System.out.println(res);  
        return res;    
    }  
      
    
//    	String degrees = "104° 5' 29.35\"";
//    	String lat = "30° 42' 21.92";
//    	例：57°55'56.6" =57+55/60+56.6/3600=57.9323888888888
    //把经纬度转换成十进制
    public static Float convert10Byloglat(String loaction){
    	String x = loaction.split(" ")[0];
    	String y = loaction.split(" ")[1];
    	String z = loaction.split(" ")[2];
    	String x1 = x.split("°")[0];
    	String y1 = y.split("'")[0];
    	String z1 = z.split("\"")[0];
    	Float degrees =  Float.valueOf(x1) + Float.valueOf(y1)/60 + Float.valueOf(z1)/3600;
//    	System.out.println(x1 + "===" + y1 + "===" + z1);
//    	System.out.println(degrees);
    	return degrees;
    }
}  

