## 安装

	# 下载代码
	https://github.com/thoughtbit/easycms.git
	# 进入easycms目录
	cd easycms
	# 清理
	mvn clean
	# 编译
	mvn compile
	# 修改数据库配置文件
		1、 把 src/main/resources/db.properties 拷贝到 CMS目录下
		2、 修改db.properties里的超级管理员的email，和数据库连接的相关信息
	# 安装
	mvn exec:java -Dexec.mainClass="com.easycms.Install"
	# 运行
	mvn jetty:run
	# 后台地址
	http://127.0.0.1:8080/admin
