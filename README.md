# SampleOfPluginSoftware

## 基本的な実装方法

* インターフェースを定義する
* 定義したインターフェースを実装したプラグイン、ホストアプリケーションを作成する

## 基本的な利用方法

* プラグインは何がしかの実行形式ファイルにする
* ホストアプリケーションはそのファイルを特定の場所に格納して利用する

## CSharp の実装

### 実装方法

* インターフェースを定義したdllを作成する
* 定義されたインターフェースを実装したプラグインをdllで作成する
* プラグインを読み込んで利用するホストアプリケーションを作成する

<img src="./csharp/PluginTextEditor/Doc/PluginSystem(CS).png" width="500">

<img src="./csharp/PluginTextEditor/Doc/PluginSystem(CS)_deployment.png" width="500">

### 参考記事

* http://dobon.net/vb/dotnet/programing/plugin.html

## Java の実装

* プラグイン用にインターフェイスを定義する
* 定義されたインターフェースを実装したプラグインをjarで作成する
* Jarファイルには、プラグインクラス名を記したマニフェストファイルを作成する
* プラグインを読み込んで利用するホストアプリケーションを作成する

<img src="./java/Doc/Class_Plugin System(java).png" width="500">

<img src="./java/Doc/Deployment_Plugin System(java).png" width="500">

### 参考記事

* https://codezine.jp/article/detail/1271

## 個人的な所感

* C#やJavaなどで実装する場合はどういうプラグインを作るれるようにするかを含めたインターフェースの定義が必須になる
* IDEのようなものを実現したいならVisualStudioやEclipseのプラグイン開発のインターフェースを参考にすると良さそう
  * https://docs.microsoft.com/ja-jp/visualstudio/extensibility/starting-to-develop-visual-studio-extensions?view=vs-2017
  * https://gihyo.jp/dev/serial/01/eclipse-plugin/0001
* 記載していないが、Pythonなどのインターフェースが存在しない言語では多重継承を利用して実装するみたい
* デスクトップアプリの場合、基本的なUIの構成やデザインは現状変わっていない
  * メニュー
  * ツールバー
  * ツールウィンドウ

## ToDo

* それぞれの典型的なIDEの実装サンプル(VisualStudio,Eclipse)を作成する

以上。
