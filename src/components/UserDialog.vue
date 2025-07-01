<template>
  <!-- 添加/编辑用户对话框 -->
  <div class="dialog-overlay" v-if="isVisible" @click.self="emitClose">
    <div class="dialog-form" :class="{ 'slide-in': isVisible }">
      <div class="form-item">
        <label>用户名</label>
        <input type="text" placeholder="请输入用户名" v-model="formData.username">
      </div>
      <div class="form-item">
        <label>邮箱</label>
        <input type="email" placeholder="请输入邮箱" v-model="formData.email">
      </div>
      <div class="form-item">
        <label>角色</label>
        <select v-model="formData.role">
          <option value="student">学生</option>
          <option value="teacher">老师</option>
          <option value="parent">家长</option>
        </select>
      </div>
      <div class="form-item">
        <label>密码</label>
        <input type="password" placeholder="请输入密码" v-model="formData.password">
      </div>
      <div class="form-item">
        <label>确认密码</label>
        <input type="password" placeholder="请再次输入密码" v-model="formData.confirmPassword">
      </div>
      <div class="dialog-actions">
        <button class="btn btn-default" @click="emitClose">取消</button>
        <button class="btn btn-primary" @click="submitForm">确定</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { defineProps,reactive,defineEmits } from 'vue';
import axiosInstance from '../utils/axios';

    const props = defineProps([
        'isVisible'
    ]);

    // 表单数据
    const formData = reactive({
        username: '',
        email: '',
        role: 'student',
        password: '',
        confirmPassword: ''
    });

    const emit = defineEmits(['close']);

    // 提交表单
    const submitForm = async () => {
        if (formData.password !== formData.confirmPassword) {
            alert('两次密码输入不一致');
            return;
        }
        try {
            const response = await axiosInstance.post('/users', {
                username: formData.username,
                email: formData.email,
                role: formData.role,
                password: formData.password
            });
            if (response.data.code === 0) {
            console.log('用户添加成功');
            emitClose();
            }
        } catch (error) {
            console.error('添加用户失败:', error);
            alert('添加用户失败，请稍后再试');
        }
    };

    // 关闭对话框
    const emitClose = () => {
        Object.keys(formData).forEach(key => formData[key] = '');
        formData.role = 'student'; // 重置默认角色
        emit('close');
    };

//     // 确保组件挂载后数据可用
// onMounted(() => {
//   console.log('UserDialog mounted, formData:', formData);
// });

</script>




<style scoped>
/* 遮罩层 */
.dialog-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: flex-end;
  z-index: 2000;
}

/* 对话框容器 */
.dialog-form {
  width: 400px;
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  transform: translateX(100%); /* 初始状态：右侧隐藏 */
  transition: transform 0.3s ease-out;
}

/* 对话框显示时滑入 */
.slide-in {
  transform: translateX(0); /* 滑入可见位置 */
}

/* 表单项 */
.form-item {
  margin-bottom: 20px;
}

.form-item label {
  display: block;
  margin-bottom: 8px;
  color: #606266;
}

.form-item input,
.form-item select {
  width: 100%;
  padding: 8px 12px;
  border: 1px solid #dcdfe6;
  border-radius: 4px;
  font-size: 14px;
}

/* 操作区 */
.dialog-actions {
  display: flex;
  justify-content: flex-end;
  gap: 10px;
  margin-top: 20px;
}

/* 按钮样式 */
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
</style>
