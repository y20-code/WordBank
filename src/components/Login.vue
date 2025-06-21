<template>
    <div class="login-container" >
        <div class="login-title">单词学习系统后台登录</div>
        <form class="login-form" id="loginForm" autocomplete="on" novalidate :model="registerData" @submit.prevent="login">
            <div class="form-item">
                <label for="username">用户名</label>
                <input type="text" id="username" name="username" placeholder="请输入用户名" autocomplete="username" v-model="registerData.username" @blur="validateUsername">
                <div class="error-message" id="usernameError">{{ usernameErrorMessage }}</div>
            </div>
            <div class="form-item">
                <label for="password">密码</label>
                <input type="password" id="password" name="password" placeholder="请输入密码" autocomplete="current-password" v-model="registerData.password" @blur="validatePassword">
                <div class="error-message" id="passwordError">{{ passwordErrorMessage }}</div>
            </div>
            <button type="submit" class="login-btn" id="loginBtn">
                <span id="loginBtnText">登录</span>
                <span class="spinner" id="loginSpinner" style="display:none"></span>
            </button>
        </form>
        <div class="login-footer">© 2024 单词学习系统</div>
    </div>
</template>

<script setup>
    import { ref} from 'vue';
    import axiosInstance from '../utils/axios';
    
    import { useRouter } from 'vue-router';

    const registerData = ref({
        username: '',
        password: ''
    });

    const loginError = ref('')
    const router = useRouter();

    // 错误消息，使用 ref 存储
    const usernameErrorMessage = ref('');
    const passwordErrorMessage = ref('');
    // 验证函数
    const validateUsername = () => {
        const username = registerData.value.username;
        if (username.length < 5 || username.length > 16) { // 调整为 5-16 字符
            usernameErrorMessage.value = '长度不对，请输入 5 到 16 个字符';
        } else {
            usernameErrorMessage.value = 'ok';
        }
    };

    const validatePassword = () => {
        const password = registerData.value.password;
        if (password.length < 5 || password.length > 16) { // 调整为 5-16 字符
            passwordErrorMessage.value = '长度不对，请输入 5 到 16 个字符';
        } else {
            passwordErrorMessage.value = 'ok';
        }
    };

    const login = async () =>{
        if (usernameErrorMessage.value !== 'ok' || passwordErrorMessage.value !== 'ok') {
            console.log('验证失败');
            return;
        }

        try{
            const response = await axiosInstance.post('/login',{
            username: registerData.value.username,
            password: registerData.value.password
            })

            if(response.data.code === 0){
                console.log('登录成功');
                localStorage.setItem('token', response.data.data);
                axiosInstance.defaults.headers.Authorization = `Bearer ${response.data.data}`;
                router.replace('/admin');
            }
        }catch (error) {
            console.error('登录请求失败:', error);
            loginError.value = '登录请求失败，请稍后再试';
        }
        

        // axios({
        //     url: 'http://localhost:8080/api/admin/login',
        //     method: 'post',
        //     data: {
        //         username: registerData.value.username,
        //         password: registerData.value.password
        //     }
        // }).then(result=>{
        //     console.log(result.data.data);
        //     router.push('/admin');
        // })
    }

</script>

<style scoped>
    body {
        background: linear-gradient(135deg, #409EFF 0%, #66b1ff 100%);
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, 'Helvetica Neue', Arial, sans-serif;
    }
    .login-container {
        background: #fff;
        border-radius: 16px;
        box-shadow: 0 6px 32px rgba(0,0,0,0.13);
        padding: 44px 36px 36px 36px;
        width: 370px;
        display: flex;
        flex-direction: column;
        align-items: center;
        animation: fadeIn 0.7s cubic-bezier(.4,0,.2,1);
    }
    @keyframes fadeIn {
        from { opacity: 0; transform: translateY(40px); }
        to { opacity: 1; transform: translateY(0); }
    }
    .login-logo {
        width: 64px;
        height: 64px;
        margin-bottom: 18px;
        border-radius: 12px;
        box-shadow: 0 2px 8px rgba(64,158,255,0.08);
    }
    .login-title {
        font-size: 25px;
        color: #303133;
        font-weight: bold;
        margin-bottom: 28px;
        letter-spacing: 1px;
    }
    .login-form {
        width: 100%;
        display: flex;
        flex-direction: column;
        gap: 18px;
    }
    .form-item {
        display: flex;
        flex-direction: column;
        gap: 4px;
    }
    .form-item label {
        color: #606266;
        font-size: 14px;
    }
    .form-item input {
        width: 100%;
        padding: 10px 12px;
        border: 1.5px solid #dcdfe6;
        border-radius: 4px;
        font-size: 15px;
        transition: border-color 0.3s, box-shadow 0.3s;
        background: #f8faff;
    }
    .form-item input:focus {
        border-color: #409EFF;
        box-shadow: 0 0 0 2px #ecf5ff;
        outline: none;
    }
    .form-item input.error {
        border-color: #f56c6c;
        background: #fef0f0;
    }
    .error-message {
        color: #f56c6c;
        font-size: 13px;
        margin-top: 2px;
        min-height: 18px;
        transition: opacity 0.2s;
    }
    .login-btn {
        width: 100%;
        padding: 12px 0;
        background: #409EFF;
        color: #fff;
        border: none;
        border-radius: 4px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        transition: background 0.3s, box-shadow 0.2s;
        box-shadow: 0 2px 8px rgba(64,158,255,0.08);
        display: flex;
        align-items: center;
        justify-content: center;
        gap: 8px;
    }
    .login-btn:disabled {
        background: #a0cfff;
        cursor: not-allowed;
    }
    .login-btn .spinner {
        border: 2px solid #fff;
        border-top: 2px solid #409EFF;
        border-radius: 50%;
        width: 18px;
        height: 18px;
        animation: spin 0.7s linear infinite;
    }
    @keyframes spin {
        0% { transform: rotate(0deg); }
        100% { transform: rotate(360deg); }
    }
    .login-footer {
        margin-top: 20px;
        color: #909399;
        font-size: 13px;
        text-align: center;
        letter-spacing: 0.5px;
    }
    @media (max-width: 480px) {
        .login-container {
            width: 97vw;
            padding: 24px 8px;
        }
    }
</style>