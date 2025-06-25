<template>
  <div>
 <el-table
    :data="trainMenta"
    style="width: 100%"
    :row-class-name="tableRowClassName"
  >
    <el-table-column prop="id" label="编号" width="180" />
    <el-table-column prop="image" label="图像名称" width="180" />
    <el-table-column prop="ageApprox" label="大致年龄" width="180" />
    <el-table-column prop="anatomSiteGeneral" label="大致病灶部位"  width="180" />
    <el-table-column prop="lesionId" label="病灶编号"  width="180" />
    <el-table-column prop="sex" label="性别" width="180" />
 </el-table>

    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total=" totaltrainMenta">
    </el-pagination>
</div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      trainMenta: [],
      currentPage: 1,
      pageSize: 16,
      totaltrainMenta: 0
    };
  },
  created() {
    this.fetchTrainMenta();
  },
  methods: {
    fetchTrainMenta() {
      axios.get('/getalltrainmentadata', {
        params: {
          page: this.currentPage - 1,
          size: this.pageSize
        }
      }).then(response => {
        this.trainMenta = response.data.content;
        this.totaltrainMenta = response.data.totalElements;
      });
    },
    handleCurrentChange(page) {
      this.currentPage = page;
      this.fetchTrainMenta();
    }
  }
};
</script>

<style scoped>
/* 添加样式以适应页面布局 */
</style>
