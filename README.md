# 说明
> 这是一个 spring cloud 微服务演示的 demo

# 模块
* cloud-parent

    > 这是一个微服务maven 父类,所有的微服务应该都继承这个 maven 项目,这样的好处就是统一了各个模块依赖的版本都一致

* config-server

    > 配置服务.

* eureka-server

    > 服务发现

* cloud-eureka-client-parent

    > 这是 eureka-client maven 父类,所有的 eureka-client 应该都继承这个 maven 模块

* user-service

    > 用户的微服务,这是一个 eureka-client ,这个 maven 的 pom 直接继承 cloud-eureka-client-parent

* oauth2-service

    > 授权的微服务,包涵了 zuul 的代理,对外提供oauth2-service 的端口,所有的api 微服务都要走 oauth2的代理。

* file-service

    > 文件的微服务,有文件相关的功能。