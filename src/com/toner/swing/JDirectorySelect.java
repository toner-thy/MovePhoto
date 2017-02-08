package com.toner.swing;  
import java.awt.Container;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;  
public class JDirectorySelect implements ActionListener {  
    
	JFrame frame = new JFrame("toner-Example");// 框架布局  
    JTabbedPane tabPane = new JTabbedPane();// 选项卡布局  
    Container con = new Container();//  
    JLabel label1 = new JLabel("文件目录");  
    JLabel label2 = new JLabel("选择文件");  
    JTextField text1 = new JTextField();// TextField 目录的路径  
    JTextField text2 = new JTextField();// 文件的路径  
    JButton button1 = new JButton("请选择");// 选择  
    JButton button2 = new JButton("请选择");// 选择  
    JFileChooser jfc = new JFileChooser();// 文件选择器  
    JButton button3 = new JButton("确定");// 
    
    JDirectorySelect() {  
        jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘  
        double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();  
        double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();  
        frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置  
        frame.setSize(500, 400);// 设定窗口大小  
        frame.setContentPane(tabPane);// 设置布局  
        
//        JTextArea txaDisplay = new JTextArea(10,30); 
//        txaDisplay.setTabSize(4);  
//        txaDisplay.setFont(new Font("标楷体", Font.BOLD, 16));
//        txaDisplay.setLineWrap(true);// 激活自动换行功能  
//        txaDisplay.setWrapStyleWord(true);// 激活断行不断字功能 
//        txaDisplay.setBackground(Color.pink); 
//        JScrollPane scroll = new JScrollPane(txaDisplay);
//        //分别设置水平和垂直滚动条自动出现 
//        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
//        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        
        label1.setBounds(10, 10, 70, 20);  
        text1.setBounds(75, 10, 280, 20);  
        button1.setBounds(380, 10, 80, 20);  
        label2.setBounds(10, 35, 70, 20);  
        text2.setBounds(75, 35, 280, 20);  
        button2.setBounds(380, 35, 80, 20);  
        button3.setBounds(30, 60, 60, 20);  
        button1.addActionListener(this); // 添加事件处理  
        button2.addActionListener(this); // 添加事件处理  
        button3.addActionListener(this); // 添加事件处理  
        con.add(label1);  
        con.add(text1);  
        con.add(button1);  
        con.add(label2);  
        con.add(text2);  
        con.add(button2);  
        con.add(button3); 
        frame.setVisible(true);// 窗口可见  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序  
        tabPane.add("1面板", con);// 添加布局1  
    }  
    /** 
     * 时间监听的方法 
     */  
    public void actionPerformed(ActionEvent e) {  
        // TODO Auto-generated method stub  
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
            jfc.setFileSelectionMode(0);// 设定只能选择到文件  
            int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句  
            if (state == 1) {  
                return;// 撤销则返回  
            } else {  
                File f = jfc.getSelectedFile();// f为选择到的文件  
                text2.setText(f.getAbsolutePath());  
            }  
        }  
        if (e.getSource().equals(button3)) {  
            // 弹出对话框可以改变里面的参数具体得靠大家自己去看，时间很短  
            JOptionPane.showMessageDialog(null, "弹出对话框的实例，欢迎您-漆艾琳！", "提示", 2);  
        }  
    }  
    public static void main(String[] args) {  
        new JDirectorySelect();  
    }  
}  