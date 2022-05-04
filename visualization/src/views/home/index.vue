<template>
  <div class="views-container views-home">
    <component
      class="component-item"
      v-for="(item, index) in componentList"
      :is="item.use"
      :style="item.inlineStyles"
      :key="index"
    />
  </div>
</template>

<script>
import computeLayout from '@/utils/layout';
import Card from '@/components/card';
import homeLayout from '@/layouts/home';

export default {
  components: {
    Card
  },
  data () {
    return {
      componentList: []
    }
  },
  created () {
    this.componentList = computeLayout(homeLayout);
    // console.log(`====`, this.componentList)
  }
}
</script>

<style lang="less" scoped>
  .views-home {
    // background-image: url('./bg.png');
    background-image: url('./4096.png');
    background-size: cover;
    background-repeat: no-repeat;
  }
  .component-item {
    // border: 1px saddlebrown dashed;
  }
</style>