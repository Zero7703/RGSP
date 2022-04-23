<template>
  <com-card title="智慧能耗">
    <div class="card-content consumer-container">
      <div class="top">
        <div class="item">
          <div class="img">
            <img :src="energyImg" alt="" @click="switchTyepe('energy')">
          </div>
          <div class="content">
            <div class="value">
              {{energyUsed}}
            </div>
            <div class="label">用电量</div>
          </div>
        </div>
        <div class="item">
          <div class="img">
            <img :src="energyImg" alt="" @click="switchTyepe('water')">
          </div>
          <div class="content">
            <div class="value">
              {{waterConsumption}}
            </div>
            <div class="label">用水量</div>
          </div>
        </div>
      </div>
      <div class="bottom" v-if="render">
        <!-- {{ maxValue }} -->
        <div class="line" v-for="(item, index) in currentRenderList" :key="index">
          <div class="name">{{item.name}}</div>
          <div class="bar-container">
            <div class="bar">
              <div class="bar__data" :style="{
                width: `${item.value * 100 / maxValue}%`
              }"></div>
            </div>
          </div>
          <div class="value">{{item.value}}</div>
        </div>
      </div>
    </div>
    <!-- 用电量: {{energyUsed}}
    用水量: {{waterConsumption}}
    用电量top: {{energyUsedTop}}
    用水量Top: {{waterConsumptionTop}} -->
  </com-card>
</template>

<script>
/**
 * 交互: 点击默认选中用电量；点击用水量，下方top 5与用水量联动，显示用水量 top 5
 */
import energyImg from './energy.png';
import waterImg from './water.png';
import { getConsume } from '@/http/request';

export default {
  data () {
    return {
      render: true,
      current: 'energy',  // energy | water
      currentRenderList: [],
      maxValue: 0,
      energyUsed: 1000, // 用电量
      waterConsumption: 1000, // 用水量
      energyUsedTop: [], // 用电量top
      waterConsumptionTop: [], // 用水量 TOP
      energyImg,
      waterImg
    }
  },
  watch: {
    current () {
      this.renderBar();
    },
  },
  methods: {
    renderBar () {
      if (this.current === 'energy') {
        this.currentRenderList = this.energyUsedTop;
      } else if (this.current === 'water') {
        this.currentRenderList = this.waterConsumptionTop;
      }
      this.maxValue = Math.max(...this.currentRenderList.map(d => d.value));
      this.render = false;
      this.$nextTick(() => {
        this.render = true;
      })
      console.log(this.currentRenderList)
    },
    switchTyepe (type) {
      this.current !== type && (this.current = type); 
    },
    async fetchData () {
      const { energyUsed, waterConsumption, energyUsedTop, waterConsumptionTop } = await getConsume();
      this.energyUsed = energyUsed;
      this.waterConsumption = waterConsumption;
      this.energyUsedTop = energyUsedTop;
      this.waterConsumptionTop = waterConsumptionTop;
      this.renderBar()
    }
  },
  mounted () {
    this.fetchData();
  }
}
</script>
<style lang="less" scoped>
  .consumer-container {
    .top {
      height: 30%;
      display: flex;
      justify-content: center;
      padding-top: 5%;
      .item {
        display: flex;
        width: 50%;
        justify-content: center;
        align-items: center;
        .img {
          // width: 50%;
          height: 70%;
          cursor: pointer;
          img {
            height: 100%;
            width: 100%;
            max-height: 100%;
            max-height: 100%;
          }
        }
        .content {
          margin-left: 5%;
          height: 100%;
          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
          .value {
            font-size: var(--font-size-large);
            color: var(--color-highlight);
            font-weight: bold;
          }
          .label {
            font-size: var(--font-size-nromal);
          }
          // width: 50%;
        }
      }
    }
    .bottom {
      height: 70%;
      // padding: 0 5%;
      display: flex;
      flex-direction: column;
      justify-content: space-around;
      .line {
        display: flex;
        justify-content: space-between;
        .name {
          width: 10%;
          font-size: var(--font-size-nromal);
        }
        .value {
          width: 10%;
          font-size: var(--font-size-nromal);
        }
        .bar-container {
          width: 75%;
          display: flex;
          align-items: center;
          .bar {
            width: 70%;
            height: var(--font-size-nromal);
            position: relative;
            // background-size: var(--font-size-nromal) var(--font-size-nromal);
            // background-image: linear-gradient(
            //   90deg,
            //   rgba(19, 23, 49, 0.8) 70%, 
            //   transparent 70%
            // );
            // border: 1px solid rgba(43, 225, 253, .1);
            animation: animation 2s;
          }
          .bar__data {
            position: absolute;
            left: 0;
            width: 50%;
            height: 100%;
            background-size: var(--font-size-nromal) var(--font-size-nromal);
            background-image: linear-gradient(
              90deg,
              #68D7C7 70%, 
              transparent 70%
            );
          }
        }
        
        @keyframes animation {
          from { width: 0px; }
          to { width: 70%; }
        }
      }
    }
  }
</style>