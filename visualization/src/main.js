import Vue from 'vue'
import App from './App.vue'
import '@/components';
import '@/styles/vars.css';
import router from '@/router';
import '@/styles/index.less';

console.log(`====`, { router })

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
