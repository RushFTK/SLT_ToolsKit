namespace Chat_CSharp
{
    partial class Form_CreateConnection
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.components = new System.ComponentModel.Container();
            this.textbox_username = new System.Windows.Forms.TextBox();
            this.label_username = new System.Windows.Forms.Label();
            this.label_ip = new System.Windows.Forms.Label();
            this.textbox_ipaddress = new System.Windows.Forms.TextBox();
            this.label_port = new System.Windows.Forms.Label();
            this.textbox_port = new System.Windows.Forms.TextBox();
            this.button_connect = new System.Windows.Forms.Button();
            this.errorprovider = new System.Windows.Forms.ErrorProvider(this.components);
            ((System.ComponentModel.ISupportInitialize)(this.errorprovider)).BeginInit();
            this.SuspendLayout();
            // 
            // textbox_username
            // 
            this.textbox_username.Location = new System.Drawing.Point(71, 12);
            this.textbox_username.Name = "textbox_username";
            this.textbox_username.Size = new System.Drawing.Size(189, 21);
            this.textbox_username.TabIndex = 0;
            this.textbox_username.Text = "guest";
            // 
            // label_username
            // 
            this.label_username.AutoSize = true;
            this.label_username.Location = new System.Drawing.Point(12, 15);
            this.label_username.Name = "label_username";
            this.label_username.Size = new System.Drawing.Size(41, 12);
            this.label_username.TabIndex = 1;
            this.label_username.Text = "用户名";
            // 
            // label_ip
            // 
            this.label_ip.AutoSize = true;
            this.label_ip.Location = new System.Drawing.Point(12, 42);
            this.label_ip.Name = "label_ip";
            this.label_ip.Size = new System.Drawing.Size(41, 12);
            this.label_ip.TabIndex = 2;
            this.label_ip.Text = "IP地址";
            // 
            // textbox_ipaddress
            // 
            this.textbox_ipaddress.Location = new System.Drawing.Point(71, 39);
            this.textbox_ipaddress.Name = "textbox_ipaddress";
            this.textbox_ipaddress.Size = new System.Drawing.Size(89, 21);
            this.textbox_ipaddress.TabIndex = 3;
            this.textbox_ipaddress.Text = "127.0.0.1";
            // 
            // label_port
            // 
            this.label_port.AutoSize = true;
            this.label_port.Location = new System.Drawing.Point(178, 42);
            this.label_port.Name = "label_port";
            this.label_port.Size = new System.Drawing.Size(11, 12);
            this.label_port.TabIndex = 4;
            this.label_port.Text = ":";
            // 
            // textbox_port
            // 
            this.textbox_port.Location = new System.Drawing.Point(195, 39);
            this.textbox_port.Name = "textbox_port";
            this.textbox_port.Size = new System.Drawing.Size(65, 21);
            this.textbox_port.TabIndex = 5;
            this.textbox_port.Text = "3500";
            // 
            // button_connect
            // 
            this.button_connect.Location = new System.Drawing.Point(99, 72);
            this.button_connect.Name = "button_connect";
            this.button_connect.Size = new System.Drawing.Size(75, 23);
            this.button_connect.TabIndex = 6;
            this.button_connect.Text = "链接(&C)";
            this.button_connect.UseVisualStyleBackColor = true;
            this.button_connect.Click += new System.EventHandler(this.button_connect_Click);
            // 
            // errorprovider
            // 
            this.errorprovider.ContainerControl = this;
            // 
            // Form_CreateConnection
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(289, 107);
            this.Controls.Add(this.button_connect);
            this.Controls.Add(this.textbox_port);
            this.Controls.Add(this.label_port);
            this.Controls.Add(this.textbox_ipaddress);
            this.Controls.Add(this.label_ip);
            this.Controls.Add(this.label_username);
            this.Controls.Add(this.textbox_username);
            this.Name = "Form_CreateConnection";
            this.Text = "建立链接";
            ((System.ComponentModel.ISupportInitialize)(this.errorprovider)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox textbox_username;
        private System.Windows.Forms.Label label_username;
        private System.Windows.Forms.Label label_ip;
        private System.Windows.Forms.TextBox textbox_ipaddress;
        private System.Windows.Forms.Label label_port;
        private System.Windows.Forms.TextBox textbox_port;
        private System.Windows.Forms.Button button_connect;
        private System.Windows.Forms.ErrorProvider errorprovider;
    }
}