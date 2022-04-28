export default {
  install (Vue, options) {
    Vue.mixin({
      methods: {
        /**
         * 根据页面大小获取基础尺寸
         */
        globalGetChartFontSize () {
          return 8;
        }
      },
      mounted () {
        if (this.fetchData) {
          this.$timer = setInterval(() => {
            this.fetchData();
          }, 10000);
        }
      },
      beforeDestory () {
        this.$timer && clearInterval(this.$timer);
      }
    })
  }
}