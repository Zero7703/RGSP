<template>
  <com-card title="通知公告">
    通知公告: {{noticeList}}
  </com-card>
</template>

<script>
export default {
  data () {
    return {
      noticeList: [], // 通知列表
    }
  }
}
</script>