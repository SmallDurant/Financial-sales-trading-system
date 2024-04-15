# Financial-sales-trading-system
基于恒生JRESCloud和HUI框架用于解决金融机构销售基金的基金交易系统



[service-name]-api/ 

|-- src/

|   |-- main/ 

|       |-- java/

|           |-- com.example.[service-name]api/

|               |-- dto/               *# 数据传输对象*

|               |-- service/           *# 服务接口定义* 

|-- pom.xml                             *# Maven依赖管理* 



[service-name]-provider/ 

|-- src/

|   |-- main/

|       |-- java/ 

|           |-- com.example.[service-name]provider/

|               |-- service/           *# 服务接口实现* 

|               |-- repository/        *# 数据库操作* 

|               |-- entity/            *# 实体类定义* 

|-- pom.xml                             *# Maven依赖管理*



 [service-name]-consumer/ 

|-- src/

|   |-- main/

|       |-- java/

|           |-- com.example.[service-name]consumer/

|               |-- controller/        *# REST API 控制器* 

|-- pom.xml                             *# Maven依赖管理*
