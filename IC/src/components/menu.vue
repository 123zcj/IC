<template>
  <el-row>
    <el-col>
      <el-menu
        :default-active="activeIndex"
        class="el-menu-vertical-demo"
           background-color="#E9EEF3"
           text-color="black" router>
            <el-sub-menu index="/view">
            <template #title>数据信息</template>
              <!--设置index-->
              <el-menu-item index="/data/traindata">训练样本</el-menu-item>
              <el-menu-item index="/data/testdata">测试样本</el-menu-item>
            </el-sub-menu>
            <el-sub-menu index="/overview">
            <template #title>数据总览</template>
              <!--设置index-->
              <el-menu-item index="/overview/trainmenta">训练样本概览</el-menu-item>
              <el-menu-item index="/overview/testmenta">测试数据概览</el-menu-item>
              <el-menu-item index="/overview/trainground">训练集图片信息概览</el-menu-item>
              <el-menu-item index="/overview/testground">测试集图片信息概览</el-menu-item>
            </el-sub-menu>
            
            <el-menu-item index="/predict">病理推测</el-menu-item>
            <el-menu-item index="/upload">手动上传数据</el-menu-item>
            <el-menu-item index="/retrain">重新训练模型</el-menu-item>
              <!--
              <el-submenu index="1-4">
                <template slot="title">测试5</template>
                <el-menu-item index="1-4-1">选项4-1</el-menu-item>
              </el-submenu>
              -->
        </el-menu>
    </el-col>
  </el-row>
</template>

<style>
.el-menu-vertical-demo{
    height: 645px
  }

.el-menu{
 
    border:0!important;
 
}
</style>

<script>
  export default {
    name: 'Menu',
    };
</script>