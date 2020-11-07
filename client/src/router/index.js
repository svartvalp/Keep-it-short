import Vue from 'vue'
import VueRouter from 'vue-router'

import Login from '@/components/Login'
import Register from '@/components/Register'
import Urls from "@/components/Urls";


Vue.use(VueRouter)

const routes = [
  {
    path : '/login',
    component : Login
  },
  {
    path: '/register',
    component: Register
  },
  {
    path: '',
    component: Urls
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
