<script setup>
import Admin from './components/admin.vue';
import SideBar from './components/SideBar.vue';
</script>



<template>
  <div class="admin-container">
        <!-- 侧边栏 -->
        <SideBar/>
        <!-- 主内容区 -->
         <Admin/>
    </div>
</template>

<style>
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
</style>
