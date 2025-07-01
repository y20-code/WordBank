# WordBank
一个全新的项目

### word_springboot
这是一个写后端接口的，目前采用的技术有Springboot、Mysql、Mybatis

### src
这是一个前端vue的主要代码，目前采用的技术有html,css,js,axios,vue,
### 1修正了获取旧令牌导致登录失败的 bug
  这个问题导致的根本原因就是，在管理员删除用户后，如果这个删除的这个用户 token 值还存在浏览器中，登录新的用户账号时，会出现 token 值无法自动删除，后端还是会显示该用户的用户名，
  这时就要在前端处理删除 token 值，localStorage.removeItem('token');
