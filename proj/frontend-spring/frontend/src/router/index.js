import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

import ScrollTestPage from '@/views/ScrollTestPage'

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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
