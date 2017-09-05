package simple_chat.client;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class signup extends JFrame implements KeyListener, ActionListener, FocusListener {
	public static final String appName = "Chat Tool - signup";
    public static final String SignupText = "Guest";
    public static final String PasswordText = "000000";
	JPanel northPanel;
	int signstate,times;
	 ClientKernel ck;
	 ChatClient cc;
	JTextField txtUsers;
	JPasswordField txtPassword;
	JButton buttonsignup, buttonCancel;
	
	public signup() {
        uiInit();
    }
    public void uiInit() {
    	setLayout(new BorderLayout());
        //创建North
        northPanel = new JPanel(new GridLayout(0,2));
        northPanel.add(new JLabel("username:"));
        northPanel.add(txtUsers = new JTextField(signup.SignupText));
        northPanel.add(new JLabel("password:"));
        northPanel.add(txtPassword = new JPasswordField(signup.PasswordText));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(buttonsignup = new JButton("Signup"));
        northPanel.add(buttonCancel = new JButton("Cancel"));
        txtUsers.addKeyListener(this);
        txtUsers.addFocusListener(this);
        txtPassword.addKeyListener(this);
        txtPassword.addFocusListener(this);
        buttonsignup.addActionListener(this);
        buttonsignup.addKeyListener(this);
        buttonCancel.addActionListener(this);
        buttonCancel.addKeyListener(this);
        this.add(northPanel, BorderLayout.NORTH);
    }
    
    public void keyPressed(KeyEvent e) {
    	// TODO Auto-generated method stub
    }
    
    public void keyReleased(KeyEvent e) {
    	// TODO Auto-generated method stub
    }
    
    public void keyTyped(KeyEvent e) {
    	// TODO Auto-generated method stub
    }
    public String getusername()
    {
    	return signup.SignupText;
    }
    public String getpassword()
    {
    	return signup.PasswordText;
    }
    public int sign() {
    	return signstate;
    }
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==txtUsers && txtUsers.getText().equals(signup.SignupText)) txtUsers.setText("");
		if(e.getSource()==txtPassword && txtPassword.getText().equals(signup.PasswordText)) txtPassword.setText("");
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==txtUsers && txtUsers.getText().equals("")) txtUsers.setText(signup.SignupText);
		if(e.getSource()==txtPassword && txtPassword.getText().equals("")) txtPassword.setText(signup.PasswordText);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==buttonsignup) {
			signstate=0;
			times=0; 
		} 
		if(e.getSource()==buttonCancel) {
			signstate=1;
			times=0;
		     }
		dispose();
	}
	
	
	//主函数
	public static void main(String args[]) {
		signup login = new signup();
		login.setTitle(login.appName);
        login.setSize(300, 140);
        login.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        login.setLocation(150,150);
        
		login.setVisible(true);
	}
}