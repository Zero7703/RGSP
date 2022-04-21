<template>
  <com-card
    title="园区概况"
    >
    <div class="card-content overview-container">
      <div
        class="item"
        v-for="(item, index) in list"
        :key="index"
      >
        <div class="img">
          <img :src="item.img" alt="">
        </div>
        <div>
          <span class="count">
            {{item.value}}
          </span>
          <span class="suffix">
            {{item.suffix}}
          </span>
        </div>
        <div class="label">{{item.label}}</div>
      </div>
    </div>
  </com-card>
</template>

<script>
import areaImg from './area.png';

export default {
  data () {
    return {
      area: 100,  // 占地面积
      duration: 10, // 运营时长
      staffNums: 1000, // 工作人员
      list: [{
        label: '占地面积',
        value: 0,
        suffix: '平方公里',
        img: areaImg
      }, {
        label: '运营时长',
        value: 0,
        suffix: '年',
        img: areaImg
      }, {
        label: '工作人员',
        value: 0,
        suffix: '人',
        img: areaImg
      }],
    }
  }
}
</script>

<style lang="less" scoped>
  .overview-container {
    display: flex;
    justify-content: space-evenly;
    .item {
      display: flex;
      flex-direction: column;
      justify-content: center;
      text-align: center;
      width: 30%;
      .img {
        height: 50%;
        img {
          width: 100%;
          height: 100%;
          max-width: 100%;
          max-height: 100%;
        }
      }
      .count {
        font-size: var(--font-size-large);
      }
      .suffix {
        font-size: var(--font-size-nromal);
      }
      .label {
        color: var(--color-highlight);
        font-size: var(--font-size-nromal);
      }
    }
  }
</style>