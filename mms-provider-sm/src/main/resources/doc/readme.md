## 打包
```
mvn clean install -D skipTests
```

## 上传jar包到服务器
```
cd target/
scp mms-provider-sm-1.0-SNAPSHOT.jar root@58.87.120.47:/home/downloads/runable-jar/mms-provider-sm-1.0-SNAPSHOT.jar
```

## 运行
```
java -jar mms-provider-sm-1.0-SNAPSHOT.jar
```