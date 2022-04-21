export default {
  install (Vue, options) {
    Vue.mixin({
      methods: {
        /**
         * 根据页面大小获取基础尺寸
         */
        globalGetChartFontSize () {
          return 12;
        }
      }
    })
  }
}