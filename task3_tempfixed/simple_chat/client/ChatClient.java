package simple_chat.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class ChatClient extends JFrame implements KeyListener, ActionListener, FocusListener {
    public static final String appName = "Chat Tool";
    public static final String serverText = "127.0.0.1";
    public static final String portText = "3500";
    public static final String nickText = "YourName";
    JPanel OriginalPanel, northPanel, southPanel, centerPanel, NewPanel, OnlineUserPanel;
    JTextField txtHost, txtPort, msgWindow, txtNick;
    JButton buttonConnect, buttonSend, buttonHelp,buttonWhoAmI,buttoncnick,buttonregister,buttonexit,buttonmsg,buttonstates,buttonusers;
    JScrollPane sc;
    int signup;
    String newuser,newpwd;
    signup sp;
    ClientKernel ck;
    ClientHistory historyWindow;
    private String lastMsg = "";
    /** Creates a new instance of Class */
    //构造方法(用于Ctrl+F查找的注释标签，后很多显而易见的注释同)
    public ChatClient() {
        uiInit();
        txtHost.setText("127.0.0.1");
        txtPort.setText("3500");
    }
    public void uiInit() {
    	OriginalPanel = new JPanel();
    	OriginalPanel.setLayout(new BorderLayout());
    	OriginalPanel.setSize(450, 500);
        setLayout(new BorderLayout());
        //创建North
        northPanel = new JPanel(new GridLayout(0,2));
        northPanel.add(new JLabel("Host address:"));
        northPanel.add(txtHost = new JTextField(ChatClient.serverText));
        northPanel.add(new JLabel("Port:"));
        northPanel.add(txtPort = new JTextField(ChatClient.portText));
        northPanel.add(new JLabel("Nick:"));
        northPanel.add(txtNick = new JTextField(ChatClient.nickText));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(new JLabel(""));
        northPanel.add(buttonConnect = new JButton("Connect"));
        northPanel.add(buttonHelp = new JButton("Help"));
        northPanel.add(buttonWhoAmI = new JButton("WhoAmI?"));
        northPanel.add(buttonstates = new JButton("STATS"));
        northPanel.add(buttonregister = new JButton("register"));
        northPanel.add(buttonusers = new JButton("USERS"));
        buttonConnect.addActionListener(this);
        buttonHelp.addActionListener(this);
        buttonWhoAmI.addActionListener(this);
        buttonstates.addActionListener(this);
        buttonusers.addActionListener(this);
        buttonregister.addActionListener(this);
        txtHost.addKeyListener(this);
        txtHost.addFocusListener(this);
        txtNick.addFocusListener(this);
        txtNick.addKeyListener(this);
        txtPort.addKeyListener(this);
        txtPort.addFocusListener(this);
        buttonConnect.addKeyListener(this);
        buttonHelp.addKeyListener(this);
        buttonWhoAmI.addKeyListener(this);
        buttonstates.addKeyListener(this);
        buttonusers.addKeyListener(this);
        buttonregister.addKeyListener(this);
        OriginalPanel.add(northPanel, BorderLayout.NORTH);
        //创建South
        southPanel = new JPanel();
        southPanel.add(msgWindow = new JTextField(20));
        southPanel.add(buttonSend = new JButton("Send"));
        buttonSend.addActionListener(this);
        msgWindow.addKeyListener(this);
        OriginalPanel.add(southPanel, BorderLayout.SOUTH);
        //创建Center
        historyWindow = new ClientHistory();
        sc = new JScrollPane(historyWindow);
        sc.setAutoscrolls(true);
        OriginalPanel.add(sc, BorderLayout.CENTER);
        this.add(OriginalPanel,BorderLayout.WEST);
        //右侧新边栏
        NewPanel = new JPanel();
        NewPanel.setSize(100, 500);
        NewPanel.setLayout(new BorderLayout());
        OnlineUserPanel = new JPanel(new GridLayout(0,1));
        OnlineUserPanel.add(new JLabel("Now Offline:"));
        NewPanel.add(OnlineUserPanel, BorderLayout.NORTH);
        this.add(NewPanel,BorderLayout.EAST);
        
    }
   //主函数
   public static void main(String args[]) {
        ChatClient client = new ChatClient();
        client.setTitle(client.appName);
        client.setSize(550, 500);
        client.setLocation(100,100);
        client.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.setVisible(true);
        client.msgWindow.requestFocus();
    }
    public void addMsg(String str) {
        historyWindow.addText(str);
    }
    //核心方法，建立与服务器的链接
    private void connect() {
        try {
            if(ck!=null) ck.dropMe();
            
            ck = new ClientKernel(txtHost.getText(), Integer.parseInt(txtPort.getText()));
            ck.setNick(txtNick.getText());
            if(ck.isConnected()) {
                ck.addClient(this);
                //addMsg就是封装了一个对historyWindows增加最后一行的方法。
                addMsg("<font color=\"#00ff00\">链接成功! Local Port:" + ck.getLocalPort() + "</font>");
            } else {
                addMsg("<font color=\"#ff0000\">connect failed！</font>");
            }
        } 
        catch( Exception e)
        { 
        	addMsg("<font color=\"#ff0000\">Error Occur:</font>" + e.getMessage());
        	if (e.getMessage().equals("Connection refused: connect"))
        	{
        		addMsg("<font color=\"#ff0000\">检查IP或端口输入是否有误</font>");
        	}	
        	e.printStackTrace();
        }
    }
    //核心方法，调用sendMessage向远端发送信息
    private void send() {
        send(msgWindow.getText());
        
    }
    //模拟用户输入str字符串并发送消息
    private void send(String str)
    {
    	if (ck == null) {addMsg("<font color=\"#ff0000\">你必须链接服务器</font>"); return;}
        ck.sendMessage(str);
        System.out.println("Client sent:"+str);
        //清空消息
        lastMsg = "" + str;
        msgWindow.setText("");
    }
    
    
    public void keyPressed(KeyEvent e) {
    }
    //KeyEvent.getSource()返回控件对象，代表事件的来源。只有拥有KeyListener的控件才会被识别
    public void keyReleased(KeyEvent e) {
        if(e.getSource() == msgWindow && e.getKeyCode() == KeyEvent.VK_UP) msgWindow.setText(lastMsg);
    }
    //这里仅设定了按下回车后不同按钮的行为
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() ==KeyEvent.VK_ENTER) {
        	//聊天信息回车上屏
            if(e.getSource() == msgWindow) send();
            //Nick回车当做按下"Connect处理，并将焦点移动到聊天框"
            if(e.getSource() == txtNick) { connect(); msgWindow.requestFocus(); }
            //其余只是将焦点移动到下一行
            if(e.getSource() == txtHost) txtPort.requestFocus();
            if(e.getSource() == txtPort) txtNick.requestFocus();
            
        }
    }
    //按下按钮后的操作 (为什么不放在keyPressed)
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonConnect) connect();
        if(e.getSource()==buttonSend) send();
        if(e.getSource()==buttonHelp) send("/help");
        if(e.getSource()==buttonWhoAmI) send("/whoami");
        if(e.getSource()==buttonstates) send("/stats");
        if(e.getSource()==buttonusers) send("/users");
        if(e.getSource()==buttonregister) {
        	sp=new signup();
        	sp.uiInit();
        	sp.setTitle(sp.appName);
            sp.setSize(300, 140);
            sp.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            sp.setLocation(150,150);
        	sp.setVisible(true);
        	
        	if(sp.sign()==0) {
        		newuser=sp.getName();
        		newpwd=sp.getpassword();
        	}
        	
        }
    }
    //当鼠标放上去时，自动输入框内清除原先的字段以便于输入
    public void focusGained(FocusEvent e) {
        if(e.getSource()==txtHost && txtHost.getText().equals(ChatClient.serverText)) txtHost.setText("");
        if(e.getSource()==txtPort && txtPort.getText().equals(ChatClient.portText)) txtPort.setText("");
        if(e.getSource()==txtNick && txtNick.getText().equals(ChatClient.nickText)) txtNick.setText("");
    }
    //与上面的事件对称，失去鼠标焦点时自动将原先的内容回填
    public void focusLost(FocusEvent e) {
       if(e.getSource()==txtPort && txtPort.getText().equals("")) txtPort.setText(ChatClient.portText);
       if(e.getSource()==txtHost && txtHost.getText().equals("")) txtHost.setText(ChatClient.serverText);
       if(e.getSource()==txtNick && txtNick.getText().equals("")) txtNick.setText(ChatClient.nickText);
    }
    //构造中间的消息事件框，使用html显示
    class ClientHistory extends JEditorPane {
        public ClientHistory() {
            super("text/html", "" + ChatClient.appName);
            setcharset("UTF-8");
            setEditable(false);
            setAutoscrolls(true);
        }
        //遍历消息框对应的html文件，找到"</body>"标签，在前面插入新的消息
        public void addText(String str) {
        	inserthtml("</body>","<br>" + str,true);
        }
        
        public void setcharset(String encode)
        {
        	inserthtml("<html>","<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">",false);
        }
        //将一段消息插入到特定代码段之前
        //flag = 特定代码段的标签；str = 待插入的文字；front = true在之前插入，front = false 在之后插入
        public void inserthtml(String flag,String str,Boolean front)
        {
            String html = getText();
            int end = html.lastIndexOf(flag);
            if (!front)	end += flag.length();
            String startStr = html.substring(0, end);
            String endStr = html.substring(end, html.length());
            String newHtml = startStr + str + endStr;
            setText(newHtml);
            setSelectionStart(newHtml.length()-1);
            setSelectionEnd(newHtml.length());
        }
        public void clear() {
            setText("");
        }
    }
}

