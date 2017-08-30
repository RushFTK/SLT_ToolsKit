using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chat_CSharp_Server
{
    /// <summary>管理程序的启动</summary>
    static class Start
    {  
        /// <summary>指示应用程序是否打开程序控制台</summary>
        public static bool show_console;
        /// <summary>指示应用程序是否打开图形用户界面</summary>
        public static bool show_gui;
        
        /// <summary>
        /// 应用程序的主入口点。
        /// </summary>
        [STAThread]
        static void Main(string[] args)
        {
            show_judger(args);
            if (!show_console)
            {
                // TODO:控制台窗体隐藏的调用
            }
            if (show_gui)
            {
                Application.EnableVisualStyles();
                Application.SetCompatibleTextRenderingDefault(false);
                Application.Run(new Form1());
            }
            
        }


        /// <summary>读取开启程序的参数</summary>
        /// <param name="args">main函数的参数列表</param>
        static void show_judger(string[] args) 
        {
#if DEBUG
            show_console = true; show_gui = false;  return;
#endif
            /// <summary>是否读取到console关键词</summary>
            bool get_console = false;
            /// <summary>是否读取到nogui关键词</summary>
            bool get_gui = false;
            if (args.Length != 0)
            {
                for (int i = 0;i < args.Length;i++)
                {
                    if (args[i] == "-console")  get_console = true;
                    if (args[i] == "-gui")    get_gui = true;
                }
            }
            show_console = get_console;
            show_gui = get_gui;
        }
    }
}
