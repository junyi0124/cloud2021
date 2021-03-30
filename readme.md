# 准备环境

# 使用
```cmd
## start eureka server cluster
java -Dserver_port=7001 -Dinstance_host=eureka7001.com -Dregister_host=eureka7002.com:7002 -jar eureka_server.jar
java -Dserver_port=7002 -Dinstance_host=eureka7002.com -Dregister_host=eureka7001.com:7001 -jar eureka_server.jar


## 
java -Dserver_port=8001 -Dinstance_id=payment8001 -jar cloud_payment.jar
java -Dserver_port=8002 -Dinstance_id=payment8002 -jar cloud_payment.jar
java -Dserver_port=8003 -Dinstance_id=payment8003 -jar cloud_payment.jar

```