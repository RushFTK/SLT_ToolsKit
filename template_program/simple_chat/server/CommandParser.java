package simple_chat.server;
//该接口的目的？
public interface CommandParser {
    
    public void setDataSource(DataSource ds);
    public void runCommand(ConnectedClient cc, String str);
}
