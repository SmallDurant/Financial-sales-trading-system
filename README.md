# Financial-sales-trading-system
基于恒生JRESCloud和HUI框架用于解决金融机构销售基金的基金交易系统



hundsun/

│

├── hundsun-api #所有的接口声明统一下载该文件中

├── hundsun-common # 存放工具类或常量等

​        ├──constant

​        ├──enumeration

​        ├──exception

​        ├──result

├── hundsun-pojo#

​        ├──dto

​        ├──entity

​        ├──vo

├── hundsun-user-provider # 用户服务模块相关代码的实现 端口8081

├── hundsun-user-consumer # 用户服务controller接口 端口8082

├── hundsun-authentication-provider # 身份验证服务相关代码的实现 端口8083

├── hundsun-authentication-consumer # 身份验证服务controller接口 端口8084

├── hundsun-fund-consumer # 基金服务controller接口 端口8085

├── hundsun-fund-provider# 基金服务相关代码实现 端口8086

├── hundsun-questionnaire-provider # 问卷服务相关代码实现 端口8087

├── hundsun-questionnaire-consumer # 问卷服务controller接口 端口8088

├── hundsun-transaction-provider # 交易服务相关代码实现 端口8089

├── hundsun-transaction-consumer # 交易模块controller接口 端口8090

├── hundsun-logging-provider # 日志服务相关代码实现 端口8091

├── hundsun-logging-consumer # 日志服务controller接口 端口8092

├── hundsun-clearing-provider # 清算服务相关代码实现 端口8093

├── hundsun-clearing-consumer # 清算服务controller接口 端口8094

├── hundsun-reporting-provider # 查询服务相关代码实现 端口8095

├── hundsun-reporting-consumer # 查询服务controller接口 端口8096

├── .gitignore

├── pom.xml #Maven依赖管理

└── README.md
