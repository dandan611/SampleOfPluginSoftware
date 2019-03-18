using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Plugin;

namespace MainConsoleApp
{
    public class PluginHost
    {
        static void Main(string[] args)
        {

            //インストールされているプラグインを調べる
            PluginInfo[] pis = Plugin.PluginInfo.FindPlugins();

            //すべてのプラグインクラスのインスタンスを作成する
            Plugin.IPlugin[] plugins = new Plugin.IPlugin[pis.Length];
            for (int i = 0; i < plugins.Length; i++)
                plugins[i] = pis[i].CreateInstance();

            //有効なプラグインを表示し、使用するプラグインを選ばせる
            int number = -1;
            do
            {
                for (int i = 0; i < plugins.Length; i++)
                    Console.WriteLine("{0}:{1}", i, plugins[i].Name);
                Console.WriteLine(
                    "使用するプラグインの番号を入力してください。:");
                try
                {
                    number = int.Parse(Console.ReadLine());
                }
                catch
                {
                    Console.WriteLine("数字を入力してください。");
                }
            } while (number < 0 || number >= pis.Length);
            Console.WriteLine(plugins[number].Name + " を使用します。");

            //プラグインに渡す文字列の入力を促す
            Console.WriteLine("文字列を入力してください。:");
            string str = Console.ReadLine();

            //プラグインのRunメソッドを呼び出して結果を取得する
            string result = plugins[number].Run(str);

            //結果の表示
            Console.WriteLine("結果:");
            Console.WriteLine(result);

            Console.ReadLine();
        }

    }
}
