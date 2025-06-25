<template>
  <div>
    <input type="file" @change="handleFileChange" />
    <button @click="uploadFile">上传文件</button>
    <div v-if="preview">
      <img :src="preview" alt="文件预览" />
    </div>
   </div>

   <div>
     <el-table
    :data="res"
    style="width: 100%"
    :row-class-name="tableRowClassName"
  >
    <el-table-column prop="confidence" label="置信度" width="180" />
    <el-table-column prop="class_index" label="推断病症" :formatter="formatType"/>
 </el-table>

   </div>

</template>

<script>
import axios from 'axios';

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
        res:[],
      selectedFile: null,
      preview: null
    };
  },
  methods: {
    handleFileChange(event) {
      this.selectedFile = event.target.files[0];
      this.preview = URL.createObjectURL(this.selectedFile);
    },
    async uploadFile() {
      const formData = new FormData();
      formData.append('file', this.selectedFile);

      try {
        const response = await axios.post('/predict', formData, {
          headers: {
            'Content-Type': 'multipart/form-data'
          }
        });
        const res = response.data;
        console.log("response:", res)
        // 处理服务器响应
      } catch (error) {
        // 错误处理
      }
    },
    formatType(row){
        return diseaseMap[row.type];
    }
  }
};
</script>
