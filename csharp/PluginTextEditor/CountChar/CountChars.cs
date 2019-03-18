using System;
using System.Windows.Forms;
using Plugin;

namespace CountChars
{
    /// <summary>
    /// 文字数を表示するためのプラグイン
    /// </summary>
    public class CountChars : Plugin.IPlugin
    {

        #region IPluginメンバの実装
        public string Name
        {
            get
            {
                return "文字数取得";
            }
        }

        //RichTextBoxの文字数を表示する
        public string Run(string str)
        {
            return str.Length.ToString();
        }
        #endregion
    }

}