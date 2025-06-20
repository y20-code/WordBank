<template>
    <div class="sidebar">
        <div class="logo">
            <h1>单词学习系统</h1>
        </div>
        <div class="menu">
            <div class="menu-item">控制台</div>
            <div class="menu-item active">用户管理</div>
            <div class="menu-item">单词管理</div>
            <div class="menu-item">任务管理</div>
            <div class="menu-item">学习统计</div>
            <div class="menu-item">系统设置</div>
        </div>
    </div>
</template>

<script>
</script>

<style >
    /* 侧边栏样式 */
    .sidebar {
        width: 240px;
        background-color: #304156;
        color: #fff;
        padding: 20px 0;
    }

    .logo {
        text-align: center;
        padding: 20px;
        border-bottom: 1px solid #1f2d3d;
    }

    .logo h1 {
        font-size: 20px;
        color: #fff;
    }

    .menu {
        padding: 20px 0;
    }

    .menu-item {
        padding: 12px 20px;
        cursor: pointer;
        transition: background-color 0.3s;
    }

    .menu-item:hover {
        background-color: #263445;
    }

    .menu-item.active {
        background-color: #1890ff;
    }
</style>