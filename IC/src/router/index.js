import { createRouter, createWebHistory } from 'vue-router'



const routes = [
  {
    path:'/data/traindata',
    name: '/data/traindata',
    component:() => import('../views/traindata.vue')
  },
  {
    path:'/data/testdata',
    name:'/data/testdata',
    component:() => import('../views/testdata.vue') 

  },
  {
    path:'/overview/trainmenta',
    name: 'trainmenta',
    component:() => import('../views/overviewtrainmenta.vue') 
  },
  {
    path:'/overview/testmenta',
    name: 'testmenta',
    component:() => import('../views/overviewtestmenta.vue') 
  },
  {
    path:'/overview/trainground',
    name: 'trainground',
    component:() => import('../views/overviewtrainground.vue') 
  },
  {
    path:'/overview/testground',
    name: 'testground',
    component:() => import('../views/overviewtestground.vue') 
  },
  {
    path: '/predict',
    name: 'predict',
    component:() => import('../views/predict.vue') 
  },
  {
    path: '/upload',
    name: 'upload',
    component:() => import('../views/upload.vue') 
  },
  {
    path: '/retrain',
    name: 'retrain',
    component:() => import('../views/retrain.vue') 
  }
]

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL), // 使用 HTML5 历史模式
  routes
})

export default router