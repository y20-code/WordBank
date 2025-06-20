<template>
                <!-- 用户列表 -->
            <div class="table-section">
                <div class="table-header">
                    <h3 class="table-title">用户列表</h3>
                    <div class="table-actions">
                        <button class="btn btn-primary">添加用户</button>
                        <button class="btn btn-default">导出</button>
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
                        <tr>
                            <td>1</td>
                            <td>张三</td>
                            <td>
                                <span class="role-tag role-student">学生</span>
                            </td>
                            <td>zhangsan@example.com</td>
                            <td>2024-03-20</td>
                            <td><span class="status-tag status-active">正常</span></td>
                            <td>
                                <div class="action-buttons">
                                    <button class="btn btn-small btn-default">编辑</button>
                                    <button class="btn btn-small btn-default">禁用</button>
                                    <button class="btn btn-small btn-default">删除</button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td>李老师</td>
                            <td>
                                <span class="role-tag role-teacher">老师</span>
                            </td>
                            <td>lilaoshi@example.com</td>
                            <td>2024-03-19</td>
                            <td><span class="status-tag status-active">正常</span></td>
                            <td>
                                <div class="action-buttons">
                                    <button class="btn btn-small btn-default">编辑</button>
                                    <button class="btn btn-small btn-default">禁用</button>
                                    <button class="btn btn-small btn-default">删除</button>
                                </div>
                            </td>
                        </tr>
                        <tr>
                            <td>3</td>
                            <td>王家长</td>
                            <td>
                                <span class="role-tag role-parent">家长</span>
                            </td>
                            <td>wangjiazhang@example.com</td>
                            <td>2024-03-18</td>
                            <td><span class="status-tag status-inactive">禁用</span></td>
                            <td>
                                <div class="action-buttons">
                                    <button class="btn btn-small btn-default">编辑</button>
                                    <button class="btn btn-small btn-default">启用</button>
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