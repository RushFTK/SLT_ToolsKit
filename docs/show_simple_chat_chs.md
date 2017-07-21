[返回首页](https://rushftk.github.io/SLT_ToolsKit/index_chs)  
_最后更新日期，2017-07-19_  
# show_simple_chat  
这里将说明教师给予的**实验三示例程序**的运行情况及结构说明  
## Menu
1. [运行时](#runtime)  
2. [结构分析](#analyze)  

## Runtime  
下面将说明运行时程序的各种表现。  
### 成功运行时  
![server_sucessuful](pics/show_template_chat/server_sucessful.png "服务器端成功运行时")  
运行Server目录下的`MainServer.java`，其为控制台应用程序，运行成功如上图所示。可以看到被设置的默认工作路径以及运行的端口。**除非终止程序，否则服务器端将一直进行运行。**  
![client_sucessuful](pics/show_template_chat/clinet_sucessful.png "客户端成功运行时")  
运行Client目录下的`ChatClient.java`，其为JPanel生成的图形界面程序，在服务器已经运行的情况下，输入合法的Nickname，运行成功如上图所示。可以看到，在一个客户端上使用下面的对话框与send发送消息，存在回显，另一个客户端也可以看到  

### 错误  
![server_portused](pics/show_template_chat/server_portused.png "服务器端口被占用")  
如果在默认的3500端口被占用的情况下运行服务器端(例如：运行一个服务器后再运行`MainServer.java`)，那么程序将**自动**使用下一个端口。  
![server_nolog](pics/show_template_chat/server_nolog.png "服务器没有日志记录")  
可以看到，服务器没有任何的日志记录。(甚至包括用户的登入，登出等)，可以通过users文件看到，应当允许用户设置登录的用户名和密码(但这个功能没有被使用)。  
![client_noserver](pics/show_template_chat/client_noserver.png "客户端port设置不正确")  
如果客户端输入的port是一个没有开服务器的端口，那么客户端gui将**没有任何反应**。后台抛出异常提示拒绝连接，之后输出"Drop Me!!"  
![client_nonickname](pics/show_template_chat/client_nonickname.png "客户端nickname设置不正确")  
同样的，客户端设置不正确时，gui同样没有任何反应，后台输出"Drop Me!!"。  

### 启示  
因此，通过运行时的程序表现，程序的缺陷如下：  
1.  补充：增加一个窗口，用户必须通过注册账号，并使用用户名和密码进入聊天界面，防止仿冒登录。  
2.  修正：当进行不正确的输入时，客户端的gui应当进行提示。  
3.  修正：对客户端的登录行为甚至聊天信息，服务器存在日志等信息记录。(可选加密)  
4.  界面友好性：增加帮助按钮，简要介绍用户程序使用方法。  
5.  界面友好性：服务器端异步的支持输入指令，或者增加gui模式。  

对于2，一个可能的方案是：客户端gui增加一个`Label`，当出现异常时：`label.text = exception.message`  

## Analyze
下面对示例程序的结构进行分析。  
