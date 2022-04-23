<template>
  <div class="card-container">
    <div class="title">
      {{title}}
    </div>
    <div class="content">
      <slot></slot>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    title: {
      type: String,
      default: ''
    }
  },
  data () {
    return {}
  }
}
</script>

<style lang="less" scoped>
  .card-container {
    width: 100%;
    height: 100%;
    .title {
      font-size: var(--font-size-card-title);
      color: var(--color-card-title);
      height: var(--height-card-title);
      background-image: url('./title-bg.png');
      background-repeat: no-repeat;
      background-size: contain;
      background-position-x: 0;
      line-height: var(--height-card-title);
      padding-left: var(--font-size-card-title);
    }
    .content {
      height: calc(100% - var(--height-card-title));
    }
  }
</style>