//这个接口的意义是？

package simple_chat.server;
public interface CommandParser {
    
    public void setDataSource(DataSource ds);
    public void runCommand(ConnectedClient cc, String str);
}
