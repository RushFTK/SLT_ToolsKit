namespace Chat_CSharp
{
    partial class Main_Form
    {
        /// <summary>
        /// 必需的设计器变量。
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 清理所有正在使用的资源。
        /// </summary>
        /// <param name="disposing">如果应释放托管资源，为 true；否则为 false。</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows 窗体设计器生成的代码

        /// <summary>
        /// 设计器支持所需的方法 - 不要修改
        /// 使用代码编辑器修改此方法的内容。
        /// </summary>
        private void InitializeComponent()
        {
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.list_online_users = new System.Windows.Forms.ListBox();
            this.textBox2 = new System.Windows.Forms.TextBox();
            this.button1 = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.system_state_label = new System.Windows.Forms.ToolStripStatusLabel();
            this.list_friends = new System.Windows.Forms.ListBox();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.system_state_label});
            this.statusStrip1.Location = new System.Drawing.Point(0, 319);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(433, 22);
            this.statusStrip1.TabIndex = 12;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // list_online_users
            // 
            this.list_online_users.FormattingEnabled = true;
            this.list_online_users.ItemHeight = 12;
            this.list_online_users.Location = new System.Drawing.Point(333, 40);
            this.list_online_users.Name = "list_online_users";
            this.list_online_users.Size = new System.Drawing.Size(75, 124);
            this.list_online_users.TabIndex = 10;
            // 
            // textBox2
            // 
            this.textBox2.Location = new System.Drawing.Point(12, 39);
            this.textBox2.Multiline = true;
            this.textBox2.Name = "textBox2";
            this.textBox2.ReadOnly = true;
            this.textBox2.Size = new System.Drawing.Size(301, 241);
            this.textBox2.TabIndex = 9;
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(333, 284);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(75, 23);
            this.button1.TabIndex = 8;
            this.button1.Text = "发送(&S)";
            this.button1.UseVisualStyleBackColor = true;
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(12, 286);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(301, 21);
            this.textBox1.TabIndex = 7;
            // 
            // menuStrip1
            // 
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(433, 24);
            this.menuStrip1.TabIndex = 11;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // system_state_label
            // 
            this.system_state_label.Name = "system_state_label";
            this.system_state_label.Size = new System.Drawing.Size(76, 17);
            this.system_state_label.Text = "State:未链接";
            // 
            // list_friends
            // 
            this.list_friends.FormattingEnabled = true;
            this.list_friends.ItemHeight = 12;
            this.list_friends.Location = new System.Drawing.Point(333, 168);
            this.list_friends.Name = "list_friends";
            this.list_friends.Size = new System.Drawing.Size(75, 112);
            this.list_friends.TabIndex = 13;
            // 
            // Main_Form
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(433, 341);
            this.Controls.Add(this.list_friends);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.list_online_users);
            this.Controls.Add(this.textBox2);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.menuStrip1);
            this.Name = "Main_Form";
            this.Text = "Simple_Chat++";
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ListBox list_online_users;
        private System.Windows.Forms.TextBox textBox2;
        private System.Windows.Forms.Button button1;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripStatusLabel system_state_label;
        private System.Windows.Forms.ListBox list_friends;
    }
}

