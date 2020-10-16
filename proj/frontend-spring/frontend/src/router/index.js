import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

// team_project
import SecondPage from '@/views/SecondPage'
import FirstPage from '@/views/FirstPage'

// vuetify slider example
import VuetifySliderLogin from '@/views/VuetifySliderLogin'

import ScrollTestPage from '@/views/ScrollTestPage'

Vue.use(VueRouter)

const routes = [
  {
    path: '/VuetifySliderLogin',
    name: 'VuetifySliderLogin',
    components: {
      default: VuetifySliderLogin
    },
    props: {
      default: true
    }
  },
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
    path: '/FirstPage',
    name: 'FirstPage',
    components: {
      default: FirstPage
    },
    props: {
      default: true
    }
  },
  {
    path: '/SecondPage',
    name: 'SecondPage',
    components: {
      default: SecondPage
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
