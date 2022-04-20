<template>
  <com-card title="运营总览">
    入驻率：{{occupancyRate}}%,
    入驻统计: {{occupancyStatistics}}
  </com-card>
</template>

<script>
export default {
  data () {
    return {
      occupancyRate: 60,  // 入驻率
      occupancyStatistics: []  // 入驻统计
    }
  }
}
</script>