<template>
  <com-card title="通知公告">
    <div class="card-content">
      <div class="list-content">
        <div class="notice-item" v-for="(item, index) in noticeList" :key="index" @click="handlerShowDetail(item.id)">
          <div class="date">{{item.date}}</div>
          <div class="content">
            <span class="icon"></span>
            {{item.content}}</div>
        </div>
      </div>
    </div>
    <el-dialog
      title="提示"
      :visible.sync="dialogVisible"
      width="30%"
      :append-to-body="false"
      :modal-append-to-body="false"
      :before-close="handleClose">
      <span>这是一段信息</span>
    </el-dialog>
  </com-card>
</template>

<script>
import { getNotice } from '@/http/request';

export default {
  data () {
    return {
      dialogVisible: false,
      noticeList: [], // 通知列表
    }
  },
  methods: {
    handleClose () {
      this.dialogVisible = false;
    },
    async fetchData () {
      const { noticeList } = await getNotice();
      this.noticeList = noticeList;
    },
    handlerShowDetail (id) {
      // this.dialogVisible = true;
      console.log(`显示通知 ${id} 的详情信息`)
    }
  },
  mounted () {
    this.fetchData();
  }
}
</script>

<style lang="less" scoped>
  .card-content {
    padding-top: var(--font-size-nromal);
  }
  .list-content::-webkit-scrollbar {
    // width: calc(var(--font-size-nromal) / 3);
    display: none;
  }
  .list-content::-webkit-scrollbar-track {
    // background: red;
  }
  .list-content::-webkit-scrollbar-thumb {
    background: #317799;
  }
  .list-content {
    height: 100%;
    overflow-y: auto;
    padding-right: var(--font-size-nromal);
  }
  .notice-item {
    background: #317799;
    padding: var(--font-size-nromal);
    margin-top: var(--font-size-nromal);
    cursor: pointer;
    .date {
      font-size: var(--font-size-small);
      color: var(--color-highlight);
    }
    .content {
      font-size: var(--font-size-nromal);
      border-left: calc(var(--font-size-nromal) / 4) var(--color-highlight) solid;
      padding-left: calc(var(--font-size-nromal) / 4);
      overflow: visible;
      text-overflow: clip;
      white-space: nowrap;// 文字不换行

      overflow: hidden;// 超出隐藏
      text-overflow: ellipsis;
    }
  }
</style>