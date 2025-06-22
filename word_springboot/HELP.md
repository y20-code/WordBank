## 写了一个用户的禁用和开启的接口

- URL:http://localhost:8080/user/1/active?active=true
  - userId =1 (路径变量)
  - active = true (查询参数,Boolean类型)

- Method:PUT

```java
@PutMapping("user/{userId}/active")
public Result activeUser(@PathVariable Long userId, @RequestParam Boolean active){
    userService.updateActive(userId,active);
    return Result.success("更新成功");
}
```

1. @PathVariable 注解

   #### 含义

   - **@PathVariable 是 Spring MVC 提供的一个注解，用于从 URL 的路径变量中提取值**。
   - 它将 URL 路径中的占位符（用 {} 定义）映射到方法参数。
   - 常用于 RESTful API 中，表示资源标识符（如 ID）。

2. @RequestParam 注解

   #### 含义

   - **@RequestParam 是 Spring MVC 提供的一个注解，用于从 HTTP 请求的参数（通常是查询字符串或表单数据）中提取值**。
   - 它将请求中的参数（如 ?key=value）映射到方法参数。
   - 常用于过滤、排序或配置性参数。



## 规范了返回日期时间

```java
@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
private LocalDateTime createdAt;
```

1. @JsonFormat

   #### 含义

   - **@JsonFormat 是 Jackson 库提供的一个注解，用于控制 Java 对象在序列化（转为 JSON）或反序列化（从 JSON 转为 Java 对象）时的格式**。
   - 它通常用于格式化日期、时间或枚举类型，确保 JSON 表示符合特定格式。
   - 常用于与 @RequestBody 或 @ResponseBody 配合使用。
