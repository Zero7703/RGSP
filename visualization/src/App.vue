<template>
  <div id="app" ref="app" :style="styles">
    <router-view></router-view>
  </div>
</template>

<script>
export default {
  name: 'App',
  data () {
    return {
      styles: {}
    }
  },
  methods: {
    resize () {
      const width = window.innerWidth;
      const height = window.innerHeight;
      console.log(`height`, height)
      this.styles = {
        transform: `scale(${width / 3840})`
      }
    }
  },
  mounted () {
    window.addEventListener('resize', this.resize);
    this.resize();
  },
  beforeDestory () {
    window.removeEventListener('resize', this.resize);
  }
}
</script>

<style lang="less">
@import "./font/font.css";
#app {
  transform-origin: 0 0;
}
</style>