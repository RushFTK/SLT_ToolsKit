using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace chat_csharp_server
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

            if (!show_console)
            {
                // TODOs:控制台窗体隐藏的调用
            }
            if (show_gui)
            {
                Application.EnableVisualStyles();
                Application.SetCompatibleTextRenderingDefault(false);
                Application.Run(new Form1());
            }
        }

        /// <summary>读取开启程序的参数</summary>
        /// <param name="args"></param>
        static void show_judger(string[] args)
        {
            if )
#if DEBUG
            //show_console = true; show_console = false;
#endif
        }
    }
}
