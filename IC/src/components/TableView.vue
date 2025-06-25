<template>
  <div>
    <el-table :data="users" style="width: 100%">
      <el-table-column prop="id" label="ID"></el-table-column>
      <el-table-column prop="name" label="Name"></el-table-column>
      <el-table-column prop="email" label="Email"></el-table-column>
    </el-table>
    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total="totalUsers">
    </el-pagination>
  </div>
</template>
<script>
import axios from 'axios';
export default {
  name:'tableview',
  data() {
    return {
      users: [],
      currentPage: 1,
      pageSize: 10,
      totalUsers: 0
    };
  },
  created() {
    this.fetchUsers();
  },
  methods: {
    fetchUsers() {
      axios.get('/test', {
        params: {
          page: this.currentPage - 1,
          size: this.pageSize
        }
      }).then(response => {
        this.users = response.data.content;
        this.totalUsers = response.data.totalElements;
      });
    },
    handleCurrentChange(page) {
      this.currentPage = page;
      this.fetchUsers();
    }
  }
};


</script>
<style scoped>
/* 添加样式以适应页面布局 */
</style>