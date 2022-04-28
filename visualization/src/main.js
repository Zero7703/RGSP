import Vue from 'vue'
import App from './App.vue'
import plugins from '@/plugins';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/components';
import '@/styles/vars.css';
import router from '@/router';
import '@/styles/index.less';
import courtTo from 'vue-count-to';

Vue.use(ElementUI);
console.log(courtTo)
Vue.config.productionTip = false

Vue.use(plugins);
Vue.component('countTo', courtTo);
new Vue({
  render: h => h(App),
  router
}).$mount('#app')
