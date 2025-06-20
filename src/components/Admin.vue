<template>
    <!-- 主内容区 -->
     <div class="admin-container">
        <SideBar/>
        <div class="main-content">
            <UserHeadr/>
            <UserSearch/>
            <UserList/>
            <UserDialog/> 
        </div>
     </div>
</template>

<script setup>
    import SideBar from './SideBar.vue';
    import UserHeadr from './UserHeadr.vue';
    import UserList from './UserList.vue';
    import UserSearch from './UserSearch.vue';
    import UserDialog from './UserDialog.vue';

</script>


<style >
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }

    body {
        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
        background-color: #f5f7fa;
        color: #303133;
    }

    .admin-container {
        display: flex;
        min-height: 100vh;
    }

    /* 主内容区样式 */
    .main-content {
        flex: 1;
        padding: 20px;
    }

    /* 功能卡片样式 */
    .feature-cards {
        display: grid;
        grid-template-columns: repeat(3, 1fr);
        gap: 20px;
        margin-bottom: 20px;
    }

    .feature-card {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
    }

    .feature-card h3 {
        color: #303133;
        margin-bottom: 15px;
        font-size: 18px;
    }

    .feature-card p {
        color: #909399;
        font-size: 14px;
        line-height: 1.6;
    }

    /* 数据统计卡片 */
    .stats-cards {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 20px;
        margin-bottom: 20px;
    }

    .stat-card {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
        text-align: center;
    }

    .stat-card h4 {
        color: #606266;
        margin-bottom: 10px;
    }

    .stat-card .number {
        font-size: 24px;
        color: #409EFF;
        font-weight: bold;
    }

    .btn {
        padding: 8px 15px;
        border-radius: 4px;
        border: none;
        cursor: pointer;
        font-size: 14px;
        transition: background-color 0.3s;
    }

    .btn-primary {
        background-color: #409EFF;
        color: #fff;
    }

    .btn-primary:hover {
        background-color: #66b1ff;
    }

    .btn-default {
        background-color: #f4f4f5;
        color: #909399;
    }

    .btn-default:hover {
        background-color: #e9e9eb;
    }


    /* 用户表单对话框样式 */
    .dialog-form {
        padding: 20px;
    }

    .dialog-form .form-item {
        margin-bottom: 20px;
    }

    .dialog-form label {
        display: block;
        margin-bottom: 8px;
        color: #606266;
    }

    .dialog-form input,
    .dialog-form select {
        width: 100%;
        padding: 8px 12px;
        border: 1px solid #dcdfe6;
        border-radius: 4px;
    }

    .dialog-actions {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
        margin-top: 20px;
    }
</style>