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
    background: var(--background-card);
    .title {
      font-size: var(--font-size-card-title);
      color: var(--color-card-title);
    }
  }
</style>