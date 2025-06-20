import {createRouter, createWebHistory} from 'vue-router'
import Login from '../components/Login.vue'
import Admin from '../components/Admin.vue'

const router = createRouter({

    history:createWebHistory(),
    routes:[
        {
            path:'/',
            name:'login',
            component:Login
        },
        {
            path:'/admin',
            component:Admin
        }
    ]
})

export default router