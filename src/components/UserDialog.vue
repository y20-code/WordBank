<template>
     <!-- 添加/编辑用户对话框 -->
    <div class="dialog-form" style="display: none;">
        <div class="form-item">
            <label>用户名</label>
            <input type="text" placeholder="请输入用户名">
        </div>
        <div class="form-item">
            <label>邮箱</label>
            <input type="email" placeholder="请输入邮箱">
        </div>
        <div class="form-item">
            <label>角色</label>
            <select>
                <option value="student">学生</option>
                <option value="teacher">老师</option>
                <option value="parent">家长</option>
            </select>
        </div>
        <div class="form-item">
            <label>密码</label>
            <input type="password" placeholder="请输入密码">
        </div>
        <div class="form-item">
            <label>确认密码</label>
            <input type="password" placeholder="请再次输入密码">
        </div>
        <div class="dialog-actions">
            <button class="btn btn-default">取消</button>
            <button class="btn btn-primary">确定</button>
        </div>
    </div>
</template>