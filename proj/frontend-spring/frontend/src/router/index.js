import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import MainDashBoard from '@/components/FirstLayout/MainDashBoard'
import FirstPage from '@/views/FirstPage'
import MyPage from '@/components/MyPage/MyPage'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/MainDashBoard',
    name: 'MainDashBoard',
    component: MainDashBoard
  },
  {
    path: '/firstPage',
    name: 'FirstPage',
    component: FirstPage
  },
  {
    path: '/MyPage',
    name: 'MyPage',
    component: MyPage
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
