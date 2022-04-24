import Vue from 'vue'
import App from './App.vue'
import plugins from '@/plugins';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import '@/components';
import '@/styles/vars.css';
import router from '@/router';
import '@/styles/index.less';

Vue.use(ElementUI);

Vue.config.productionTip = false

Vue.use(plugins);

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
