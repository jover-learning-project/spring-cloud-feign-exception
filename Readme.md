# Spring-cloud-feign-exception

- provider(uid-service) port: 10000
- consumer(user-service) port: 9000

## Usage

先进入deploy启动nacos
```shell script
cd deploy
docker-compose up
```

启动 provider(uid-service) 与 consumer(user-service)。

curl访问方式:
```shell script
curl 'localhost:9000?datacenterId=10&machineId=1' # 正常 返回999
curl 'localhost:9000?datacenterId=100&machineId=1' # 业务异常 返回0
curl 'localhost:9000' # 参数异常 返回1
```
