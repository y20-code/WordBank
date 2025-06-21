import axios from "axios";

const Instance = axios.create({
    baseURL:'http://localhost:8080/api/admin',
    timeout: 10000,

})

Instance.interceptors.request.use(
    (config) => {
        const token = localStorage.getItem("token");
        console.log('检查 token:', token); 
        if (token) {
            config.headers.Authorization = `Bearer ${token}`;
            console.log('设置的 Authorization 头:', config.headers.Authorization);
        }
        else {
                console.log('未找到 token'); // 调试未找到 token
            }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
)

Instance.interceptors.response.use(
    (response) => response,
    (error) => {
        if (error.response && error.response.status === 401) {
            // 令牌失效，跳转到登录页面
            localStorage.removeItem("token");
            window.location.href = "/";
        }
        return Promise.reject(error);
    }

)

export default Instance;