import Vue from 'vue';
import VueRouter from 'vue-router';

import Home from '@/views/home/index.vue';

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [{
    name: 'home',
    path: '/',
    component: Home
  }]
})