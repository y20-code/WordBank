# 1. 选择一个包含 Java 运行环境的基础镜像
# OpenJDK 是一个很好的选择，slim 版本体积更小
# 使用一个具体的版本标签，而不是 latest，以确保构建的可重复性
FROM openjdk:17-jdk-slim

# 2. 设置工作目录
# 容器内所有后续操作都将在此目录下进行
WORKDIR /usr/local/java

# 3. 将构建好的 JAR 包复制到工作目录
# 第一个参数是宿主机（上下文）中的文件路径，第二个参数是容器内的路径
# 这里我们将 JAR 包重命名为 app.jar 以方便引用
COPY /usr/local/java/word.jar app.jar

# 4. 声明容器对外暴露的端口
# 这只是一个元数据声明，实际端口映射在 `docker run` 时指定
# 假设你的 Spring Boot 应用默认使用 8080 端口
EXPOSE 8080

# 5. 定义容器启动时执行的命令
# 使用 exec 格式（JSON 数组）是推荐的做法，可以正确处理信号
ENTRYPOINT ["java", "-jar", "app.jar"]