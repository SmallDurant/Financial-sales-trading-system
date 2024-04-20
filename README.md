# Financial-sales-trading-system
基于恒生JRESCloud和HUI框架用于解决金融机构销售基金的基金交易系统



hundsun/

│

├── hundsun-api #所有的接口声明统一下载该文件中

├── hundsun-common # 存放工具类或常量等

│——├──config# 存放配置类

│——├──components# 存放第三方组件

│——├──constant# 存放常量类

│——├──enumeration# 存放枚举类

│——├──exception# 存放异常类，统一继承BaseException

│——└── result# 存放自定义返回类型，后端返回统一格式结果

├──hundsun-pojo

│——├──dto# 数据传输类

│——├──entity# 实体类

│——├──query# 数据查询类

│——└──vo# value object 值对象 

├── hundsun-user # 用户服务模块相关代码的实现 端口8081

├── hundsun-authentication# 身份验证服务相关代码的实现 端口8082

├── hundsun-fund# 基金服务相关代码实现 端口8083

├── hundsun-questionnaire # 问卷服务相关代码实现 端口8084

├── hundsun-transaction # 交易服务相关代码实现 端口8085

├── hundsun-log # 日志服务相关代码实现 端口8086

├── hundsun-liquidation# 清算服务相关代码实现 端口8087

├── hundsun-reporting # 查询服务相关代码实现 端口8088

├── hundsun-gateway # gateway接口 端口8090

├── .gitignore

├── pom.xml #Maven依赖管理

└── README.md
