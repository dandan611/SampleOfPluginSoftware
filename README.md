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

<img src="/csharp/PluginTextEditor/Doc/Plugin System(C#).png" width="500">

<img src="/csharp/PluginTextEditor/Doc/Plugin System(C#)_deployment.png" width="500">

### 参考記事

* http://dobon.net/vb/dotnet/programing/plugin.html

## Java の実装

* プラグイン用にインターフェイスを定義する
* 定義されたインターフェースを実装したプラグインをjarで作成する
* Jarファイルには、プラグインクラス名を記したマニフェストファイルを作成する
* プラグインを読み込んで利用するホストアプリケーションを作成する

### 参考記事

* https://codezine.jp/article/detail/1271

##　個人的な所感

* -

以上。
