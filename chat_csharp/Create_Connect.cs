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
    public partial class Form_CreateConnection : Form
    {
        public Form_CreateConnection()
        {
            InitializeComponent();
        }

        /// <summary>检查当前控件的Text是否为空，如果是，令errorprovide产生错误信息，并返回错误</summary>
        /// <param name="target">待检测的目标</param>
        /// <returns></returns>
        private bool text_ifnull(Control target)
        {
            if (target.Text.Length == 0)
            {
                errorprovider.SetError(target, "该字段不能为空");
                return true;
            }
            return false;
        }

        private void button_connect_Click(object sender, EventArgs e)
        {
            #region 检查字段有效性
            errorprovider.Clear();
            //空字段检查
            if (text_ifnull(textbox_username)  || 
                text_ifnull(textbox_ipaddress) ||
                text_ifnull(textbox_port))
            {
                
                MessageBox.Show(this,"输入有误，存在字段不为空","错误",MessageBoxButtons.OK,MessageBoxIcon.Error);
                return;
            }
            #endregion

        }


    }
}
