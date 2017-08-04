using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chat_CSharp
{
    public partial class Main_Form : Form
    {
        public Main_Form()
        {
            InitializeComponent();
        }

        //更新类界面元素的信息
        /// <summary> 更新窗口右下侧状态栏的信息 </summary>
        /// <param name="message">需要更新的信息</param>
        public void update_state(string message)
        {
            this.system_state_label.Text = message;
        }
        /// <summary>根据给定的用户信息和好友信息，更新界面对应的userlist和friendlist的内容</summary>
        /// <param name="Users">在线用户信息列表</param>
        /// <param name="Friends">在线好友信息列表</param>
        public void update_userlist(List<string>Users, List<string>Friends)
        {
            // TODO:验证该部分代码正确性
            //更新用户信息部分
            this.list_online_users.BeginUpdate();
            if (Users != null)
            {
                for (int i = 0; i < Users.Count; i++) 
                {
                    this.list_online_users.Items.Add(Users[i]);
                }
            }
            this.list_online_users.EndUpdate();
            // TODO:仿照上面部分对Friends进行维护
        }
        
    }
}
