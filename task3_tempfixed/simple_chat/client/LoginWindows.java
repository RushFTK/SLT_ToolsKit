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

public class LoginWindows extends JFrame implements KeyListener, ActionListener, FocusListener {
	public static final String appName = "Chat Tool - Login";
    public static final String LoginText = "Guest";
    public static final String PasswordText = "000000";
	JPanel northPanel;
	JTextField txtUsers;
	JPasswordField txtPassword;
	JButton buttonLogin, buttonCancel;
	
	public LoginWindows() {
        uiInit();
    }
    public void uiInit() {
    	setLayout(new BorderLayout());
        //创建North
        northPanel = new JPanel(new GridLayout(0,2));
        northPanel.add(new JLabel("username:"));
        northPanel.add(txtUsers = new JTextField(LoginWindows.LoginText));
        northPanel.add(new JLabel("password:"));
        northPanel.add(txtPassword = new JPasswordField(LoginWindows.PasswordText));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(buttonLogin = new JButton("Login"));
        northPanel.add(buttonCancel = new JButton("Cancel"));
        txtUsers.addKeyListener(this);
        txtUsers.addFocusListener(this);
        txtPassword.addKeyListener(this);
        txtPassword.addFocusListener(this);
        buttonLogin.addActionListener(this);
        buttonLogin.addKeyListener(this);
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
	@Override
	public void focusGained(FocusEvent e) {
		if(e.getSource()==txtUsers && txtUsers.getText().equals(LoginWindows.LoginText)) txtUsers.setText("");
		if(e.getSource()==txtPassword && txtPassword.getText().equals(LoginWindows.PasswordText)) txtPassword.setText("");
	}
	@Override
	public void focusLost(FocusEvent e) {
		if(e.getSource()==txtUsers && txtUsers.getText().equals("")) txtUsers.setText(LoginWindows.LoginText);
		if(e.getSource()==txtPassword && txtPassword.getText().equals("")) txtPassword.setText(LoginWindows.PasswordText);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//主函数
	public static void main(String args[]) {
		LoginWindows login = new LoginWindows();
		login.setTitle(login.appName);
        login.setSize(300, 140);
        login.setLocation(150,150);
		login.setVisible(true);
	}
}