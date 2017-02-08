/**
 * Project Name:ExifTester
 * File Name:PanelRunner2.java
 * Package Name:com.toner.frame
 * Date:2017年2月6日上午11:12:48
 * Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 *
*/

package com.toner.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ClassName:PanelRunner2 <br/>
 * Function: TODO ADD FUNCTION. <br/>
 * Reason:	 TODO ADD REASON. <br/>
 * Date:     2017年2月6日 上午11:12:48 <br/>
 * @author   taohy
 * @version  
 * @since    JDK 1.8
 * @see 	 
 */
public class PanelRunner2 {
	 public static void main(String[] args){
	  JFrame frame = new JFrame("Color Panels");
	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  frame.setSize(600, 100);
	  JPanel panel = new JPanel();
	  panel.setLayout(new BorderLayout());
	  panel.setPreferredSize(new Dimension(600, 100));
	  JPanel subpanel1 = new JPanel();
	  subpanel1.setBackground(Color.RED);
	  subpanel1.setPreferredSize(new Dimension(600, 20));
	  panel.add(subpanel1, BorderLayout.NORTH);
	  JPanel panelCenter = new JPanel();
	  panelCenter.setLayout(new GridLayout(1,4));
	  
	  JPanel subpanel6 = new JPanel();
	  subpanel6.setBackground(Color.ORANGE);
	  subpanel6.setPreferredSize(new Dimension(600, 100));
	  panel.add(subpanel6, BorderLayout.SOUTH);
	  frame.add(panel);
	  frame.setVisible(true);
	 }
}

