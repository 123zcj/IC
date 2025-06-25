<template>
  <div>
 <el-table
    :data="trainTruth"
    style="width: 100%"
    :row-class-name="tableRowClassName"
  >
    <el-table-column prop="id" label="编号" width="180" />
    <el-table-column prop="image" label="图像名称" width="180" />
    <el-table-column prop="type" label="病症类型" />
 </el-table>

    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total=" totaltrainTruth">
    </el-pagination>
</div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      trainTruth: [],
      currentPage: 1,
      pageSize: 16,
      totaltrainTruth: 0
    };
  },
  created() {
    this.fetchTrainTruth();
  },
  methods: {
    fetchTrainTruth() {
      axios.get('/getalltraingroundtruth', {
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
      this.fetchTrainTruth();
    }
  }
};
</script>

<style scoped>
/* 添加样式以适应页面布局 */
</style>
