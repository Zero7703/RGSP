<template>
  <com-card title="智慧能耗">
    用电量: {{energyUsed}}
    用水量: {{waterConsumption}}
    用电量top: {{energyUsedTop}}
    用水量Top: {{waterConsumptionTop}}
  </com-card>
</template>

<script>
/**
 * 交互: 点击默认选中用电量；点击用水量，下方top 5与用水量联动，显示用水量 top 5
 */
export default {
  data () {
    return {
      current: 'energy',  // energy | water
      energyUsed: 1000, // 用电量
      waterConsumption: 1000, // 用水量
      energyUsedTop: [], // 用电量top
      waterConsumptionTop: [] // 用水量 TOP
    }
  }
}
</script>