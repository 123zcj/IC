<script setup>
import Menu from './components/menu.vue';
</script>

<template>
   <div id="app">
    <el-container>
      <el-header class="el-header" style="background-color:#72242426">
        <h4>Data management and model prediction system based on ISIC datasets</h4>
      </el-header>
      <el-container>
        <el-aside width="200px" height:100vh>
          <!--引入自定义左侧菜单栏-->
          <Menu></Menu>

        </el-aside>
        <el-main>
          <!--引入跳转路由-->
            <router-view ></router-view>
            
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #5a8da3aa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #72242426);
}
</style>
