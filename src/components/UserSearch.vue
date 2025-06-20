<template>
    <!-- 搜索栏 -->
    <div class="search-bar">
        <div class="search-form">
            <div class="form-item">
                <label>用户名</label>
                <input type="text" placeholder="请输入用户名">
            </div>
            <div class="form-item">
                <label>角色</label>
                <select>
                    <option value="">全部</option>
                    <option value="student">学生</option>
                    <option value="teacher">老师</option>
                    <option value="parent">家长</option>
                </select>
            </div>
            <div class="form-item">
                <label>状态</label>
                <select>
                    <option value="">全部</option>
                    <option value="active">正常</option>
                    <option value="inactive">禁用</option>
                </select>
            </div>
            <div class="form-item">
                <label>注册时间</label>
                <input type="date">
            </div>
        </div>
        <div class="search-actions">
            <button class="btn btn-default">重置</button>
            <button class="btn btn-primary">搜索</button>
        </div>
    </div>
</template>

<style scoped>
    .search-bar {
        background-color: #fff;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 12px 0 rgba(0,0,0,0.1);
        margin-bottom: 20px;
    }

    .search-form {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        gap: 15px;
    }

    .form-item {
        display: flex;
        flex-direction: column;
    }

    .form-item label {
        margin-bottom: 8px;
        color: #606266;
    }

    .form-item input,
    .form-item select {
        padding: 8px 12px;
        border: 1px solid #dcdfe6;
        border-radius: 4px;
        font-size: 14px;
    }

    .search-actions {
        display: flex;
        justify-content: flex-end;
        gap: 10px;
        margin-top: 15px;
    }


</style>