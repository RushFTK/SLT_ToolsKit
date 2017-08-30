using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chat_CSharp_Server.Manager
{
    /// <summary>
    /// 管理接入服务器的用户
    /// </summary>
    public class User
    {
        private static int unknown_id = -1;
        /// <summary>用户的数字id，便于存储</summary>
        private int id;
        public string username { get; private set; }
        public List<User> friendlist { get; private set; }

        User()
        {
            id = unknown_id;
            username = null;
            friendlist = null;
        }

        User(string target_username)
        {
            // TODO:读取文件对应特征字段的内容
            // 读取管理用户的文件，找到username = target_username之项，将对应参数加入到中
            throw new NotImplementedException();
        }

        /// <summary>为新用户分配一个空闲的ID</summary>
        /// <returns>分配的新id值</returns>
        static int alloc_newid()
        {
            /// TODO:读取管理用户的文件信息，找到空闲未用的ID，返回该值。
            throw new NotImplementedException();
        }

        //static bool 
    }
    class User_manager
    {
        /// <summary>当前服务器在线的用户</summary>
        public List<User> online_user { get; private set; }
    }
}
