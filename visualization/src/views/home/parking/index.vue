<template>
  <com-card title="智慧停车">
    统计：{{overview}},
    停车趋势: {{parkingTrend}}
  </com-card>
</template>

<script>
export default {
  data () {
    return {
      overview: {
        overage: 100, // 剩余
        total: 200, // 总共
        used: 100, // 已用
        overload: 80, // 压力
        peakHours: [] // 高峰时段
      },
      parkingTrend: [] // 趋势
    }
  }
}
</script>