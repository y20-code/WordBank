<template>
                <!-- 用户列表 -->
            <div class="table-section">
                <div class="table-header">
                    <h3 class="table-title">用户列表</h3>
                    <div class="table-actions">
                        <button class="btn btn-primary" @click="addUser">添加用户</button>
                        <button class="btn btn-default" @click = "aaa">导出</button>
                    </div>
                </div>
                <table class="user-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>用户名</th>
                            <th>角色</th>
                            <th>邮箱</th>
                            <th>注册时间</th>
                            <th>状态</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="user in users" :key="user.username">
                            <td>{{ user.userId }}</td>
                            <td>{{ user.username }}</td>
                            <td>
                                <span class="role-tag" :class="` role-${user.role}`">{{ getRoleName(user.role) }}</span>
                            </td>
                            <td>{{ user.email }}</td>
                            <td>{{ user.createdAt }}</td>
                            <td><span class="status-tag " :class="{'status-active':user.active,'status-inactive':!user.active}">{{ user.active? '正常' : '禁用'}}</span></td>
                            <td>
                                <div class="action-buttons">
                                    <button class="btn btn-small btn-default">编辑</button>
                                    <button class="btn btn-small btn-default" @click="DAU(user)">禁用</button>
                                    <button class="btn btn-small btn-default">删除</button>
                                </div>
                            </td>
                        </tr>
                    </tbody>
                </table>

                <!-- 分页 -->
                <div class="pagination">
                    <button>上一页</button>
                    <button class="active">1</button>
                    <button>2</button>
                    <button>3</button>
                    <button>下一页</button>
                </div>
            </div>
</template>

<script setup>
    import { ref,onMounted } from 'vue';
    import axiosInstance from '../utils/axios';
    const users = ref([]);

    

    onMounted( () =>{
        axiosInstance.get('/user')
            .then(result=>{
                users.value = result.data.data;
                console.log(users.value);
                getRoleName(users.value[0].role);
                
        })
    })
    

    // 计算属性或方法将 role 转换为中文
   const getRoleName = (role) => {
        const roleMap = {
            student: '学生',
            teacher: '老师',
            parent: '家长'
        };
        return roleMap[role] || role; // 如果 role 不匹配，返回原值
    };

    const DAU = (user) => {
        console.log('禁用用户', user);
        user.active = !user.active; // 切换用户状态
        //localhost:8080/api/admin/user/6/active?active=true
        axiosInstance.put(`/user/${user.userId}/active?active=${user.active}`)
            .then(response => {
                console.log('用户状态更新成功', response.data);
            })
            .catch(error => {
                console.error('更新用户状态失败', error);
            });
    };

    const addUser = () => {
        console.log('添加用户');
        // 这里可以添加逻辑来处理添加用户的操作
        
    };

    

</script>

<style scoped>

    /* 表格区域 */
    .table-section {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
    }

    .table-header {
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }

    .table-title {
        font-size: 18px;
        color: #303133;
    }

    .table-actions {
        display: flex;
        gap: 10px;
    }

    /* 列表里的样式 */
    .user-table {
        width: 100%;
        border-collapse: collapse;
    }

    .user-table th,
    .user-table td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ebeef5;
    }

    .user-table th {
        background-color: #f5f7fa;
        color: #606266;
        font-weight: 500;
    }

    .user-table tr:hover {
        background-color: #f5f7fa;
    }

    .status-tag {
        display: inline-block;
        padding: 2px 8px;
        border-radius: 4px;
        font-size: 12px;
    }

    .status-active {
        background-color: #f0f9eb;
        color: #67c23a;
    }

    .status-inactive {
        background-color: #f4f4f5;
        color: #909399;
    }

    .role-tag {
        display: inline-block;
        padding: 2px 8px;
        border-radius: 4px;
        font-size: 12px;
        margin-right: 5px;
    }

    .role-student {
        background-color: #ecf5ff;
        color: #409eff;
    }

    .role-teacher {
        background-color: #f0f9eb;
        color: #67c23a;
    }

    .role-parent {
        background-color: #fdf6ec;
        color: #e6a23c;
    }

    .action-buttons {
        display: flex;
        gap: 8px;
    }

    .btn-small {
        padding: 4px 8px;
        font-size: 12px;
    }

    .pagination {
        display: flex;
        justify-content: flex-end;
        margin-top: 20px;
        gap: 5px;
    }

    .pagination button {
        padding: 5px 10px;
        border: 1px solid #dcdfe6;
        background-color: #fff;
        cursor: pointer;
    }

    .pagination button.active {
        background-color: #409eff;
        color: #fff;
        border-color: #409eff;
    }
</style>