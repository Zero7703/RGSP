<template>
  <com-card title="智慧办公">
    预约时长: {{total}}
    预约趋势: {{appointmentTrend}}
  </com-card>
</template>

<script>
export default {
  data () {
    return {
      total: 10000, // 总预约时长
      appointmentTrend: []  // 预约趋势
    }
  }
}
</script>