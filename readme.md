说明:
本项目提供rest接口服务
1.使用技术
spring-boot,spring-cloud,mybatis

2.查看接口
启动服务后,浏览器查看http://localhost:8802/swagger-ui.html(端口改成启动服务端口)

3.get或set报错
安装lombok插件,https://blog.csdn.net/zhglance/article/details/54931430

4.项目结构说明:
carloan-api-model:提供对外接口实体
carloan-common:提供公共工具
carloan-config-center:配置中心,其它服务配置都在此
carloan-feign:提供各服务的feign和断路器hystrix
carloan-register-center:注册中心
carloan-service:单独可部署的服务
carloan-web:前端接口服务
5.启动错误:APPLICATION FAILED TO START
将working directory设置为$MODULE_DIR$

6.端口说明:
9001:carloan-register-center 注册中心
8001:carloan-service-quartzjob 定时器服务
8002:carloan-service-shiro 认证权限服务
8003:carloan-service-workflow 工作流服务
8011:carloan-service-activity 工作流工具服务
8888:carloan-config 配置中心服务
10001:carloan-web 前端接口服务
7.启动顺序
先启动注册中心和配置中心,再启动各业务服务,再启动carloan-web服务
8.接口健康状况查看
http://localhost:10001/hystrix
9.activity
web设计器地址:http://172.24.132.107:10000/activiti-explorer  账号:kermit
表说明:https://blog.csdn.net/u012373815/article/details/52092218
10.bytetcc文档
tcc-service-consumer demo说明
consumer服务里顺序调用了provider01和provider02服务的接口,任意接口异常都可以回滚(手动写回滚代码)调用过的接口
例如:provider02接口异常,可以回滚provider01和consumer执行的方法
https://github.com/liuyangming/ByteTCC
https://my.oschina.net/fileoptions/blog/899991?utm_source=tool.lu
http://ifeve.com/tcc/


