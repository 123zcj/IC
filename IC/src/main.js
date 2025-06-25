import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import router from './router' // 导入路由配置
import App from './App.vue'
import axios from 'axios'


axios.defaults.baseURL = 'http://localhost:8080'
const app = createApp(App)
app.config.globalProperties.$http = axios
app.use(ElementPlus)

app.use(router).mount('#app')
