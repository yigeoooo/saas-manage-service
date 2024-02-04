# 使用一个包含 Java 环境的基础镜像
FROM openjdk:8-jdk-alpine

# 将你的 Java 应用程序的 .jar 文件复制到镜像中
COPY target/saas-manage-service.jar saas-manage-service.jar

# 暴露应用运行时所需的端口
EXPOSE 80

# 定义容器启动时执行的命令
ENTRYPOINT ["java", "-jar", "hospital.jar"]

