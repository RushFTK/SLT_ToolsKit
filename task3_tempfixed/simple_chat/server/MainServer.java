package simple_chat.server;
import java.net.*;
import java.io.*;
public class MainServer extends Thread {
    public static final String DISCONNECTED = "Software caused connection abort";
    public static final String DISCONNECTED_CLIENT = "Socket closed";
    public static final String PORT_USED_ERROR = "Address already in use: JVM_Bind";
    public static long uptime = 0; 
    public static long connects = 0;
    public static final char MSGENDCHAR = 0xff;
    int port = 1984;
    int clients = 8;
    private boolean newPort = true;
    //服务器打开时，占用端口的socket.
    private ServerSocket sSock;
    //临时变量
    private Socket sock;
    public ConnectionKeeper ck;
    public static DataSource ds;
    public static CommandParser cp;
    public MainServer(int port) {
        this.port = port;
        ck = new ConnectionKeeper(MainServer.cp);
        MainServer.uptime = System.currentTimeMillis();
        start();
    }
    public void run() {
        while(true) {
            try {
                sSock = new ServerSocket(port);
                if(newPort) {
                    System.out.println("Server Listening at port: " + sSock.getLocalPort());
                    newPort = false;
                }
                //socket.accept:获取接收到的链接。
                sock = sSock.accept();
                ck.add(sock);
                //TODOs:分析为什么要把建立的socket给关上？虽然有while(true)，但没有运行到这里。
                sSock.close();
            } catch(Exception e) {
                String message = e.getMessage();
                if(message.startsWith(MainServer.PORT_USED_ERROR)) {
                    System.out.println("Port " + port + " is already used, Attempting to use " + (port+=1));
                    newPort = true;
                } else {
                    e.printStackTrace();
                    System.exit(1);
                }
            }
        }
    }
    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch(Exception e) {}
    }
    public static void main(String arg[]) {
        int port = 0;
        MainServer ms;
        MainServer.ds = new FileDataSource();
        MainServer.cp = new BroadcastCommandParser();
        MainServer.cp.setDataSource(MainServer.ds);
        if(arg.length!=1) {
            ms = new MainServer(3500);
            System.out.println("Usage: java jchat.server.MainServer <port>\nAttempting to use default port 3500");
        } else {
            try {
                //运行Server时第一个参数作为自定义的端口号
                //TODOs:增加格式限定等
                port = Integer.parseInt(arg[0]);
            } catch(NumberFormatException nfe) {
                System.out.println("Attempting to use default port 3500");
                port = 3500;
            } finally {
                ms = new MainServer(port);
            }
        }
    }
}
