## 打包
```
mvn clean install -D skipTests
```

## 上传jar包到服务器
```
cd target/
scp mms-discovery-eureka-1.0-SNAPSHOT.jar root@58.87.120.47:/home/downloads/runable-jar/mms-discovery-eureka-1.0-SNAPSHOT.jar
```

## 运行
```
nohup java -jar mms-discovery-eureka-1.0-SNAPSHOT.jar &
```