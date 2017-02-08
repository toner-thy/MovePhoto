/**
 * Project Name:ExifTester
 * File Name:MovePhoto.java
 * Package Name:com.toner.test
 * Date:2017年2月5日下午4:21:23
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.photo;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import com.toner.photo.vo.Photo;

/**
 * ClassName:MovePhoto <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月5日 下午4:21:23 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class MovePhoto {
	
	public static List<Photo> list = new ArrayList<Photo>();

	//递归查询文件夹下文件
	public static void recursiveFile(File file) throws Exception{
		if(file.isDirectory()){
			File[] files = file.listFiles();
       	 	for(File f : files){
       	 		recursiveFile(f);
       	 	}
        } else {
        	if(!file.getName().endsWith(".mp4")){
        		list.add(ExifTester.getImageExifInfo(file));
        	}
        }
	}
	
	//递归删除文件夹下的文件
	public static void deleteDir(String path)
	{
		File file = new File(path);
		if (file.exists())
		{
			if (file.isDirectory())
			{
				File[] files = file.listFiles();
				for (File subFile : files)
				{
					if (subFile.isDirectory())
						deleteDir(subFile.getPath());
					else
						subFile.delete();
				}
			}
			file.delete();
		}
	}
	
	public static void movePhoto(String[] args) throws Exception {
		if(args.length<2){
			System.out.println("参数输入错误");
			return;
		}
		System.out.println("开始执行...");
		Date startDate = new Date();
//        File file = new File("D:\\应用宝照片备份\\20170204");  
//        File directory = new File("D:\\应用宝照片备份\\test"); 
        File file = new File(args[0]);  
        File directory = new File(args[1]); 
        recursiveFile(file);
        if(!directory.exists()){
        	directory.mkdirs();
        }else {
        	System.out.println("删除存在的目录："+directory.getAbsolutePath());
        	deleteDir(directory.getAbsolutePath());
        }
        System.out.println("******************文件复制开始*******************");
        for (Photo photo : list) {
        	String newPhotoPath = "";
			if (StringUtils.isNotEmpty(photo.getAdmName())) {
				File admNameDirectory = new File(directory.getAbsolutePath() + "\\" + photo.getAdmName());
				if(!admNameDirectory.exists()){
					admNameDirectory.mkdirs();
				}
				newPhotoPath = admNameDirectory.getAbsolutePath()+"\\"+photo.getPhotoName();
				FileUtils.copyFile(new File(photo.getOriginalPath())
						, new File(newPhotoPath));
			} else {
				File newDirectory = new File(directory.getAbsolutePath() + "\\other");
				if(!newDirectory.exists()){
					newDirectory.mkdirs();
				}
				newPhotoPath = newDirectory.getAbsolutePath()+"\\"+photo.getPhotoName();
				FileUtils.copyFile(new File(photo.getOriginalPath())
						, new File(newPhotoPath));
			}
			System.out.println("复制文件："+photo.getOriginalPath());
		}
        System.out.println("******************文件复制结束*******************");
        Date endDate = new Date();
        long time = endDate.getTime()-startDate.getTime();
        System.out.println("共耗时："+time + "毫秒。");
	}

	public void test() {
		
		for (int i = 0; i < 8000; i++) {
            System.out.println(i);
		}
	}
}

