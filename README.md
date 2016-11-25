# Sample Enterprise Application

　このプロジェクトはBluemix CFランタイム "Liberty for Java" 上で稼動するEnterpriseアプリケーション(EAR)のサンプルです。

#### 構成
- SampleEnterpriseApp - EARプロジェクト
   - SampleEnterpriseAppEJB - EJBプロジェクト
   - SampleEnterpriseAppWeb - Webプロジェクト

### メニュー
1. Bluemix システム日時
 - EJBで現在時刻(UTC)を取得し、ブラウザに表示する。
1. Liberty for Java 環境変数
 - Liberty for Javaランタイムの環境変数を一覧表示する。
1. データベース検索(JPA)
 - EJBでJPAを使用したデータベース検索サンプル
1. セッションアフィニティのテスト
 - 複数画面にまたがってトランザクションを実行するテスト
1. データ永続化のテスト
 - ファイルの永続的書き込みのテスト
1. 画像認識テスト
 - VisualRecognitionをJavaで使用する際のサンプル

### 使用サービス
1. ElephantSQL - JPAを使用してDBアクセスする。
1. AutoScaling - セッションアフィニティのテストで使用
1. Session Cache - セッションアフィニティのテストで使用
1. Object Strage - データ永続化テストで使用
1. VisualRecognition - 画像認識テストで使用

