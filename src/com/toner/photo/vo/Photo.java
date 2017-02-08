/**
 * Project Name:ExifTester
 * File Name:Photo.java
 * Package Name:com.toner.test.vo
 * Date:2017年2月5日下午4:23:57
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.photo.vo;
/**
 * ClassName:Photo <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月5日 下午4:23:57 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class Photo {

	private String createDate;
	private String photoName;
	private String photoSize;
	private String address;
	private String admCode;
	private String admName;
	private String name;
	private String originalPath;
	
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getPhotoSize() {
		return photoSize;
	}
	public void setPhotoSize(String photoSize) {
		this.photoSize = photoSize;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdmCode() {
		return admCode;
	}
	public void setAdmCode(String admCode) {
		this.admCode = admCode;
	}
	public String getAdmName() {
		return admName;
	}
	public void setAdmName(String admName) {
		this.admName = admName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOriginalPath() {
		return originalPath;
	}
	public void setOriginalPath(String originalPath) {
		this.originalPath = originalPath;
	}
	
}

