# 前言
报名系统项目后端代码采用springboot、mybatis框架，前端采用Vue + Element-Ui

## 环境
- [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) 
- [Gradle](https://gradle.org/) 
- [Maven](http://maven.apache.org/) 
- [Mysql 5.7](https://www.mysql.com/) 

## 项目结构
```
├── app                                    -- 手机端用户报名项目
│   ├── src/main/java                         -- 类文件
│        ├── com/newgen/app                    -- 包名
│             ├── action                         -- 接口层(controller)文件
│             ├── bean                           -- 持久化对象文件
│             ├── handler                        -- 项目配置统一处理文件
│             ├── mapper                         -- mybatis数据库操作接口文件
│             ├── service                        -- 逻辑层(service)文件
│             ├── util                           -- 工具类文件
│             └── AppApplication.java            -- 项目启动入口文件
│   ├── src/main/resources                    -- 资源文件
│             ├── mybatis                        -- 逻辑层(service)文件
│             ├── static                         -- 资源静态文件
│             └── application.properties         -- springboot项目配置文件
│   └── build.gradle                          -- Gradle配置文件
├── backmanager                            -- 后台管理系统项目
│   ├── src/main/java                         -- 类文件
│        ├── com/newgen/backmanager            -- 包名
│             ├── action                         -- 接口层(controller)文件
│             ├── bean                           -- 持久化对象文件
│             ├── exception                      -- 异常处理文件
│             ├── mapper                         -- mybatis数据库操作接口文件
│             ├── security/config                -- springsecurity配置文件
│             ├── service                        -- 逻辑层(service)文件
│             └── BackmanagerApplication.java    -- 项目启动入口文件
│   ├── src/main/resources               -- 资源文件
│             ├── mybatis                   -- 逻辑层(service)文件
│             ├── static                    -- 资源静态文件
│             └── application.properties    -- springboot项目配置文件
│   └── build.gradle                     -- Gradle配置文件
├── commons                              -- 通用底层项目
│   ├── src/main/java                         -- 类文件
│        ├── com/newgen/commons                -- 包名
│             ├── action                         -- 接口层(controller)文件
│             ├── bean                           -- 持久化对象文件
│             ├── config                         -- 通用配置文件
│             ├── mapper                         -- mybatis数据库操作接口文件
│             ├── model                          -- 通用对象文件
│             ├── service                        -- 逻辑层(service)文件
│             └── CommonsApplication.java        -- 项目启动入口文件
│   ├── src/main/resources               -- 资源文件
│             ├── mybatis                   -- 逻辑层(service)文件
│             └── application.properties    -- springboot项目配置文件
│   └── build.gradle                     -- Gradle配置文件
├── sql                                  -- 数据库文件夹
│   └── db.sql                              -- 数据表和初始数据
├── readme.md                            -- readme文档入口
├── build.gradle                         -- Gradle配置文件
└── settings.gradle                      -- Gradle配置文件
```

## 环境搭建

### 安装Gradle
```
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
```

### 安装Maven

```
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
```

## 初始化数据库
使用数据库 Mysql 5.7 执行 `/sql/db.sql`文件中内容初始化数据库

## 打包运行

### 修改项目数据库连接配置
编辑 `application.properties` 根据实际数据库地址、数据库名、账号、密码修改

### 打包
进入根目录，执行命令 `gradle clean build` 打包，打包成功后会在app和backmanager目录下生成build文件夹

### 运行
进入 `backmanager/build/libs` 目录下，执行 `java -jar backmanager-0.0.1-SNAPSHOT.jar` 运行


# 如果要开发可导入IDE(Eclipse或Idea)
  (1) 在根目录下进入CMD命令行工具输入 `gradle eclipse` 或 `gradle idea` 导入相应依赖包<br>
  (2) 导入Eclipse或者Idea进行开发
  
