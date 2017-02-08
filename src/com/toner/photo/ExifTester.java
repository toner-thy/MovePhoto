/**
 * Project Name:ExifTester
 * File Name:ExifTester.java
 * Package Name:com.toner.test
 * Date:2017年2月5日上午9:14:04
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.photo;

import java.io.File;

import org.apache.commons.lang.StringUtils;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.tools.GetLocation;
import com.toner.photo.vo.Photo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * ClassName:ExifTester <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月5日 上午9:14:04 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
/** 
 * 测试用于读取图片的EXIF信息 
 * @author Winter Lau 
 */  
public class ExifTester {  
	
	public static Integer count = 0;
	
	public static void recursiveFile(File file) throws Exception{
		if(file.isDirectory()){
			File[] files = file.listFiles();
       	 	for(File f : files){
       	 		recursiveFile(f);
       	 	}
        } else {
        	if(!file.getName().endsWith(".mp4")){
//        		System.out.println(file.getAbsolutePath());
	        	getImageExifInfo(file);
	        	count++;
        	}
        }
	}
	
    public static void main(String[] args) throws Exception {  
         File file = new File("D:\\应用宝照片备份");  
//         File file = new File("c:\\1.jpg");  
         recursiveFile(file);
//         getImageExifInfo(file);
         System.out.println(count);
     }
     public static Photo getImageExifInfo(File jpegFile) throws Exception {
    	 Photo photo = new Photo();
//       Metadata metadata = JpegMetadataReader.readMetadata(jpegFile);  
    	 Metadata metadata = ImageMetadataReader.readMetadata(jpegFile);
         String Longitude = "";
         String Latitude = "";
         String createDate = "";
         String fileSize = "";
         String fileName = "";
         for (Directory directory : metadata.getDirectories()) {
             for (Tag tag : directory.getTags()) {
//            	 System.out.println(tag);
                 if(tag.toString().contains("[Exif SubIFD] Date/Time Digitized - ")){
                	 String strTag = tag.toString();
                	 createDate = strTag.substring(strTag.indexOf("-") + 2);
                 }
                 if(tag.toString().contains("[File] File Size - ")){
                	 String strTag = tag.toString();
                	 fileSize = strTag.substring(strTag.indexOf("-") + 2);
                 }
                 if(tag.toString().contains("[File] File Name - ")){
                	 String strTag = tag.toString();
                	 fileName = strTag.substring(strTag.indexOf("-") + 2);
                 }
                 if(tag.toString().contains("[GPS] GPS Longitude - ")){
                	 String LongitudeTag = tag.toString();
                	 Longitude = LongitudeTag.substring(LongitudeTag.indexOf("-") + 2);
                 }
                 if(tag.toString().contains("[GPS] GPS Latitude - ")){
            		 String LatitudeTag = tag.toString();
            		 Latitude = LatitudeTag.substring(LatitudeTag.indexOf("-") + 2);
            	 }
             }
             if (directory.hasErrors()) {
                 for (String error : directory.getErrors()) {
                     System.err.println("ERROR: " + error);
                 }
             }
         }
         String address = "";
         if(StringUtils.isNotEmpty(Longitude) && StringUtils.isNotEmpty(Latitude)){
        	 address = GetLocation.getAdd(GetLocation.convert10Byloglat(Longitude)+""
        			 , GetLocation.convert10Byloglat(Latitude)+"");
         }
         
         if(StringUtils.isNotEmpty(address)){
        	 JSONObject jsonObject = JSONObject.fromObject(address);  
             JSONArray jsonArray = JSONArray.fromObject(jsonObject.getString("addrList"));  
             JSONObject j_2 = JSONObject.fromObject(jsonArray.get(0));  
             String admName = j_2.getString("admName");  
             String admCode = j_2.getString("admCode");  
             String name = j_2.getString("name");  
             photo.setAdmCode(admCode);
             photo.setAdmName(admName);
             photo.setName(name);
         }
         photo.setCreateDate(createDate);
         photo.setAddress(address);
         photo.setPhotoName(fileName);
         photo.setPhotoSize(fileSize);
         photo.setOriginalPath(jpegFile.getAbsolutePath());
//         System.out.println("***************************");
//         System.out.println(createDate);
//    	 System.out.println(fileName);
//    	 System.out.println(fileSize);
//    	 System.out.println(address);
//         System.out.println("***************************");
         return photo;
     }  
}  

