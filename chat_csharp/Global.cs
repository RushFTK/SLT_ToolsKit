using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Sockets;
using System.Text;
using System.Threading.Tasks;

namespace Chat_CSharp
{
    static class Global
    {
        /// <summary>当前与服务器进行的Socket链接</summary>
        public static Socket current { get; set; }
    }
}
