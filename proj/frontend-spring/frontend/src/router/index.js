import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import ScrollTestPage from '@/views/ScrollTestPage'

import MainDashBoard from '@/components/FirstLayout/MainDashBoard'
import FirstPage from '@/views/FirstPage'
import test from '@/components/FirstLayout/test'

Vue.use(VueRouter)

const routes = [
  {
    path: '/ScrollTestPage',
    name: 'ScrollTestPage',
    components: {
      default: ScrollTestPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/test',
    name: 'test',
    component: test
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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
