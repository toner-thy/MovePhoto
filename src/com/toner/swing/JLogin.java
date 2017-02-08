package com.toner.swing;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JLogin{
	public JFrame jf = new JFrame("地址工具集成界面");
	public Container con = jf.getContentPane();
	public Toolkit toolkit = Toolkit.getDefaultToolkit();
	public Dimension sc = toolkit.getScreenSize();
	public JLabel name1 = new JLabel("用户名");
	public JLabel pass1 = new JLabel("密码");
	public JTextField textName = new JTextField();
	public JPasswordField textPs = new JPasswordField();
	public JButton button1 = new JButton("登陆");
	public JButton button2 = new JButton("重置");
	public Font font1 = new Font("宋体",1,14);
	public Font font2 = new Font("宋体",0,12);
	public JLogin(){
		con.setLayout(null);
		jf.setSize(sc.width/3,sc.height*10/25);
		jf.setLocation(sc.width/3,sc.height/4);
		jf.setResizable(false);
		ImageIcon im = new ImageIcon(""); //登录按钮背景
		jf.setIconImage(im.getImage());
		name1.setLocation(80,30);
		name1.setSize(100, 100);
		name1.setFont(font1);
		name1.setForeground(Color.white);
		pass1.setLocation(80,90);
		pass1.setSize(100,100);
		pass1.setForeground(Color.white);
		pass1.setFont(font1);
		textName.setSize(140, 20);
		textName.setLocation(170, 70);
		textPs.setSize(140, 20);
		textPs.setLocation(170, 130);
		textPs.setEchoChar('*');
		button1.setSize(90,25);
		button1.setLocation(80,180 );
		button1.setIcon(im);
		button1.setFont(font2);
		
		button1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				execute();
			}
		});
		
		
		button2.setSize(90,25);
		button2.setLocation(220, 180);
		button2.setIcon(im);
		button2.setFont(font2);
		ImageIcon bgim = new ImageIcon("image/timg.jpg");//背景图案
		JLabel bg = new JLabel(bgim); 
		Container laycon = jf.getLayeredPane();
		bg.setSize(jf.getSize().width,jf.getSize().height);
		bgim.setImage(bgim.getImage().getScaledInstance(bg.getSize().width,bg.getSize().height,Image.SCALE_DEFAULT));
		laycon.add(bg,new Integer(Integer.MIN_VALUE));
		con.add(name1);
		con.add(pass1);
		con.add(textName);
		con.add(textPs);
		con.add(button1);
		con.add(button2);
		con.setBackground(Color.black);
		con.add(bg);
		jf.setResizable(false);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void execute(){
		System.out.println(111);
	}
	
	public static void main(String args[]){
		new JLogin();
	}
}