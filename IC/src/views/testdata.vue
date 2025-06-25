<template>
  <div>
 <el-table
    :data="testMenta"
    style="width: 100%"
    :row-class-name="tableRowClassName"
  >
    <el-table-column prop="id" label="编号" width="180" />
    <el-table-column prop="image" label="图像名称" width="180" />
    <el-table-column prop="ageApprox" label="大致年龄" width="180" />
    <el-table-column prop="anatomSiteGeneral" label="大致病灶部位"  width="180" />
    <el-table-column prop="sex" label="性别" />
 </el-table>

    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total=" totaltestMenta">
    </el-pagination>
</div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      testMenta: [],
      currentPage: 1,
      pageSize: 16,
      totaltestMenta: 0
    };
  },
  created() {
    this.fetchTestMenta();
  },
  methods: {
    fetchTestMenta() {
      axios.get('/getalltestmentadata', {
        params: {
          page: this.currentPage - 1,
          size: this.pageSize
        }
      }).then(response => {
        this.testMenta = response.data.content;
        this.totaltestMenta = response.data.totalElements;
      });
    },
    handleCurrentChange(page) {
      this.currentPage = page;
      this.fetchTestMenta();
    }
  }
};
</script>
