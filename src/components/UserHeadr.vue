<template>
    <!-- 顶部栏 -->
    <div class="header">
        <div class="breadcrumb">用户管理</div>
        <div class="user-info">
            <!-- <img src="https://via.placeholder.com/40" alt="用户头像" class="user-avatar"> -->
            <span>管理员</span>
        </div>
    </div>
</template>


<style>
    .header {
        background-color: #fff;
        padding: 15px 20px;
        box-shadow: 0 1px 4px rgba(0,21,41,.08);
        display: flex;
        justify-content: space-between;
        align-items: center;
        margin-bottom: 20px;
    }

    .user-info {
        display: flex;
        align-items: center;
    }

    .user-avatar {
        width: 40px;
        height: 40px;
        border-radius: 50%;
        margin-right: 10px;
    }
</style>