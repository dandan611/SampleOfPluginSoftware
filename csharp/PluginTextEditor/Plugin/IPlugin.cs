using System;
using System.Windows.Forms;

namespace Plugin
{
    /// <summary>
    /// プラグインで実装するインターフェイス
    /// </summary>
    public interface IPlugin 
    {
        /// <summary>
        /// プラグインの名前
        /// </summary>
        string Name { get; }

        /// <summary>
        /// プラグインを実行する
        /// </summary>
        string Run(string str);

    }
}
