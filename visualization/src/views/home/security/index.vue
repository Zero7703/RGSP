<template>
  <com-card title="智慧安防">
    监控: {{monitor}}
    烟感: {{smokeSensor}}
    温感: {{temperatureSensor}}
  </com-card>
</template>

<script>

export default {
  data () {
    return {
      monitor: 100, // 监控
      smokeSensor: 100,   // 烟感
      temperatureSensor: 100,  // 温感
    }
  }
}
</script>