<template>
  <div id="app" ref="app" :style="styles">
    <router-view></router-view>
  </div>
</template>

<script>
import { screenSize } from '@/constants';

export default {
  name: 'App',
  data () {
    return {
      size: {
        width: `${screenSize[0]}px`,
        height: `${screenSize[1]}px`,
      },
      styles: {
        width: `${screenSize[0]}px`,
        height: `${screenSize[1]}px`,
      }
    }
  },
  methods: {
    resize () {
      const width = window.innerWidth;
      const height = window.innerHeight;
      this.styles = {
        transform: `scale(${width / screenSize[0]})`,
        ...this.size
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