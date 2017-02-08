package com.toner.swing;  
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import org.apache.commons.lang.StringUtils;

import com.toner.photo.MovePhoto;
import com.toner.util.ConsoleTextArea;  

public class MovePhotoWindow implements ActionListener {  
    
	JFrame frame = new JFrame("toner-照片按地区格式化");// 框架布局  
    JTabbedPane tabPane = new JTabbedPane();// 选项卡布局  
    Container con = new Container();//  
    JPanel jpanel1 = new JPanel();
    JPanel jpanel2 = new JPanel();
    JLabel label1 = new JLabel("待格式化文件目录");  
    JLabel label2 = new JLabel("输出目录");  
    JTextField text1 = new JTextField();// TextField 目录的路径  
    JTextField text2 = new JTextField();// 文件的路径  
    JButton button1 = new JButton("请选择");// 选择  
    JButton button2 = new JButton("请选择");// 选择  
    JFileChooser jfc = new JFileChooser();// 文件选择器  
    JButton button3 = new JButton("确定");//
    JButton button4 = new JButton("清空");//
//    JTextArea txaDisplay;
    ConsoleTextArea consoleTextArea;
    
    MovePhotoWindow() throws IOException {  
        jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘  
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();  
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();  
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置  
        frame.setSize(600, 400);// 设定窗口大小  
        frame.setResizable(false);
        frame.setContentPane(tabPane);// 设置布局  
        
        con.setLayout(new BorderLayout());
        jpanel1.setLayout(new GridLayout(2, 3));
        
        button1.addActionListener(this); // 添加事件处理  
        button2.addActionListener(this); // 添加事件处理  
        jpanel1.add(label1);  
        jpanel1.add(text1);  
        jpanel1.add(button1);  
        jpanel1.add(label2);  
        jpanel1.add(text2);  
        jpanel1.add(button2);  
        frame.setVisible(true);// 窗口可见  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序  
        
        
        consoleTextArea = new ConsoleTextArea(); 
        consoleTextArea.setTabSize(4);  
        consoleTextArea.setFont(new Font("标楷体", Font.BOLD, 16));
        consoleTextArea.setLineWrap(true);// 激活自动换行功能  
        consoleTextArea.setWrapStyleWord(true);// 激活断行不断字功能 
        consoleTextArea.setBackground(Color.pink); 
        JScrollPane scroll = new JScrollPane(consoleTextArea);
        //分别设置水平和垂直滚动条自动出现 
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
      	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        
      	button3.addActionListener(this); // 添加事件处理  
      	button4.addActionListener(this); // 添加事件处理  
      	jpanel2.add(button3, BorderLayout.CENTER);
      	jpanel2.add(button4, BorderLayout.CENTER);
      	jpanel1.setPreferredSize(new Dimension(600, 50));
      	jpanel2.setPreferredSize(new Dimension(600, 100));
      	scroll.setPreferredSize(new Dimension(600, 250));
        con.add(jpanel1, BorderLayout.NORTH);  
        con.add(jpanel2, BorderLayout.CENTER);  
        con.add(scroll, BorderLayout.SOUTH);  
        tabPane.add("面板1", con);// 添加布局1  
    }  
    /** 
     * 时间监听的方法 
     */  
    @SuppressWarnings("static-access")
	public void actionPerformed(ActionEvent e) {  
        if (e.getSource().equals(button1)) {// 判断触发方法的按钮是哪个  
            jfc.setFileSelectionMode(1);// 设定只能选择到文件夹  
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;  
            } else {  
                File f = jfc.getSelectedFile();// f为选择到的目录  
                text1.setText(f.getAbsolutePath());  
            }  
        }  
        // 绑定到选择文件，先择文件事件  
        if (e.getSource().equals(button2)) {  
        	jfc.setFileSelectionMode(1);//设定只能选择到文件夹  
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;// 撤销则返回  
            } else {  
                File f = jfc.getSelectedFile();// f为选择到的文件  
                text2.setText(f.getAbsolutePath());  
            }  
        }  
        if (e.getSource().equals(button3)) {  
        	MovePhoto movePhoto = new MovePhoto();
        	if(StringUtils.isNotEmpty(text1.getText()) && 
        			StringUtils.isNotEmpty(text2.getText())){
        		String args[] ={text1.getText(),text2.getText()};
        		try {
        			movePhoto.movePhoto(args);
        		} catch (Exception e1) {
        			e1.printStackTrace();
        		}
        	} else {
        		consoleTextArea.setText("请输入路径");
        	}
        }  
        if (e.getSource().equals(button4)) {  
        	consoleTextArea.setText(null);
        }  
    }  
    
    public static void main(String[] args) {  
        try {
			new MovePhotoWindow();
		} catch (IOException e) {
			e.printStackTrace();
		}  
    }  
}  