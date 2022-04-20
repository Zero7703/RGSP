<template>
  <com-card title="企业概况">
    行业统计(饼图)：{{industryCount}},
    资金分布: {{fundsCount}}
  </com-card>
</template>

<script>
export default {
  data () {
    return {
      industryCount: [],  // 行业统计
      fundsCount: [],  // 资金分布
    }
  }
}
</script>