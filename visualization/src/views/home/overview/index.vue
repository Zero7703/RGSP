<template>
  <com-card
    title="园区概况"
    >
    <div>
      占地面积: {{area}},
      运营时长: {{duration}},
      工作人员: {{staffNums}},
    </div>
  </com-card>
</template>

<script>

export default {
  data () {
    return {
      area: 100,  // 占地面积
      duration: 10, // 运营时长
      staffNums: 1000 // 工作人员
    }
  }
}
</script>
