代码克隆地址
http://172.16.8.80:3000/JaloDeng/newgen.git
代码说明
总体文件结构
我将活动报名系统分成用户端app和后台管理端backmanager，两套代码需分开部署，这个文档只描述backmanager后台管理端的部署
图片: https://uploader.shimo.im/f/LfoP5eVZ61g2c5Ea.png

app：用户报名接口逻辑
backmanager：后台管理系统
commons：通用底层逻辑
sql：数据库表结构文件
.gitignore：Git忽略配置文件
build.gradle：Gradle配置文件
settings.gradle：Gradle配置文件

后台管理端代码目录结构
图片: https://uploader.shimo.im/f/Hmjvz2FZjf0A1jk7.png

该项目为springboot项目，可以打包成可执行jar包或war包

src/main/java
com/newgen/backmanager:
backmanagerApplication.java：启动文件入口
action文件夹：存放系统业务控制层
bean文件夹：存放实体对象类
exception文件夹：存放异常统一处理类
mapper文件夹：存放mybatis接口类
security.config文件夹：存放登陆、权限配置类
service文件夹：存放系统业务逻辑文件
src/main/resources
mybatis：存放sql执行语句文件
static：存放静态文件(基于vue构建的前端文件)
application.properties：项目配置文件(数据库配置、端口配置等)
bin文件夹: 存放项目的编译文件
build.gradle：Gradle配置文件

其他文件如：JRE System Libraries、Referenced Libraries、src为开发工具Eclipse显示项目，可以忽略
环境
Java 8
Gradle 5.4.1
Maven 3.6.1
数据库
Mysql 5.7
快速开始
克隆代码
git clone http://172.16.8.80:3000/JaloDeng/newgen.git
环境搭建
Gradle搭建
# 1.下载Gradle，命令如下
wget https://services.gradle.org/distributions/gradle-5.4.1-bin.zip

# 2.解压到 /opt/gradle 文件目录中，命令如下
unzip -d /opt/gradle gradle-5.4.1-bin.zip

# 3.编辑 /etc/profile 文件，添加以下一行代码(路径必须跟第2步路径相同)
export PATH=$PATH:/opt/gradle/gradle-5.4.1/bin

# 4.保存 /etc/profile 文件，并输入以下命令刷新
source /etc/profile

# 5.测试Gradle是否安装成功，命令如下
gradle -v

# 输出类似如下信息则安装成功
------------------------------------------------------------
Gradle 5.4.1
------------------------------------------------------------

Build time:   2019-04-26 08:14:42 UTC
Revision:     261d171646b36a6a28d5a19a69676cd098a4c19d
Maven搭建
# 1.下载Maven，命令如下
wget http://mirrors.tuna.tsinghua.edu.cn/apache/maven/maven-3/3.6.1/binaries/apache-maven-3.6.1-bin.zip

# 2.解压到 /opt/maven 文件目录中(目录位置可自定，不一定按这个)，命令如下
unzip -d /opt/maven apache-maven-3.6.1-bin.zip

# 3.编辑 /etc/profile 文件，添加以下一行代码(路径必须跟第2步路径相同)
export PATH=/opt/maven/apache-maven-3.6.1/bin:$PATH

# 4.保存 /etc/profile 文件，并输入以下命令刷新
source /etc/profile

# 5.测试Gradle是否安装成功，命令如下
mvn -v

# 输出类似如下信息则安装成功
Apache Maven 3.6.1 (d66c9c0b3152b2e69ee9bac180bb8fcc8e6af555; 2019-04-05T03:00:29+08:00)
Maven home: /opt/maven/apache-maven-3.6.1
初始化数据库
在目录打开 /sql/db.sql 数据库文件，执行该文件内容初始化数据库
项目打包运行
项目配置文件修改
编辑 backmanager/src/main/resources/application.properties，根据实际数据库地址、数据库名、账号、密码修改
图片: https://uploader.shimo.im/f/W4GA2LWmBN4scs7k.png
编译打包
进入主目录，执行以下命令
# Gradle打包命令(clean:清理旧的jar包文件，build打包命令)
gradle clean build
执行完毕后，backmanager目录下会生成build文件夹，jar包文件被存放该文件夹下
图片: https://uploader.shimo.im/f/KJfIHcGSuHsDg7g2.png
测试运行
进入 /libs 文件夹，可见jar包文件
图片: https://uploader.shimo.im/f/dV0Ri5nR1EASJdR5.png
执行以下命令
java -jar backmanager-0.0.1-SNAPSHOT.jar
输出如下信息则代表启动成功
图片: https://uploader.shimo.im/f/Hh6COlSPtywWWOvn.png