<template>
  <div>
 <el-table
    :data="testTruth"
    style="width: 100%"
    :row-class-name="tableRowClassName"
  >
    <el-table-column prop="id" label="编号" width="180" />
    <el-table-column prop="image" label="图像名称" width="180" />
    <el-table-column prop="type" label="病症类型" :formatter="formatType" />
 </el-table>

    <el-pagination
      @current-change="handleCurrentChange"
      :current-page="currentPage"
      :page-size="pageSize"
      layout="total, prev, pager, next"
      :total=" totalTestTruth">
    </el-pagination>
</div>
</template>

<script>
import axios from 'axios';

// 病症映射关系
const diseaseMap = {
  1: '黑色素瘤 Melanoma',
  2: '黑素细胞痣 Melanocytic nevus',
  3: '基底细胞癌 Basal cell carcinoma',
  4: '光化性角化病 Actinic keratosis',
  5: '良性角化病（日光性雀斑/脂溢性角化病/扁平苔藓样角化病）',
  6: '皮肤纤维瘤 Dermatofibroma',
  7: '血管病变 Vascular lesion',
  8: '鳞状细胞癌 Squamous cell carcinoma',
  9: '不属于其他八种病症 None of the above'
};

export default {
  data() {
    return {
      testTruth: [],
      currentPage: 1,
      pageSize: 16,
      totalTestTruth: 0
    };
  },
  created() {
    this.fetchTesttruth();
  },
  methods: {
    fetchTesttruth() {
      axios.get('/getalltestgroundtruth', {
        params: {
          page: this.currentPage - 1,
          size: this.pageSize
        }
      }).then(response => {
        this.testTruth = response.data.content;
        this.totalTestTruth = response.data.totalElements;
      });
    },
    handleCurrentChange(page) {
      this.currentPage = page;
      this.fetchTesttruth();
    },
    formatType(row){
        return diseaseMap[row.type];
    }
  }
};
</script>
