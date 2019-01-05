## 部署SDK
将SDK放在/url/local/lib目录下

## 设置java.library.path路径
```
vi /etc/profile
export LD_LIBRARY_PATH=$LD_LIBRARY_PATH:/usr/local/lib
```

## 打包
```
mvn clean install -D skipTests
```

## 上传jar包到服务器
```
cd target/
scp mms-provider-face-1.0-SNAPSHOT.jar root@58.87.120.47:/home/downloads/runable-jar/mms-provider-face-1.0-SNAPSHOT.jar
```

## 运行
```
java -jar mms-provider-face-1.0-SNAPSHOT.jar
```