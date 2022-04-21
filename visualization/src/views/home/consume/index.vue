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
            <div>用电量</div>
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
            <div>用水量</div>
          </div>
        </div>
      </div>
      <div class="bottom" ref="chart"></div>
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
import waterImg from './energy.png';
import * as echarts from 'echarts';
export default {
  data () {
    return {
      current: 'energy',  // energy | water
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
      this.$chart.setOption(this.getOptions());
    }
  },
  methods: {
    switchTyepe (type) {
      this.current !== type && (this.current = type); 
    },
    getOptions () {
      const baseFontSize = this.globalGetChartFontSize();
      const dataList = this.current === 'energy' ? this.energyUsedTop : this.waterConsumptionTop;
      return {

      }
    }
  },
  mounted () {
    this.$chart = echarts.init(this.$refs.chart);
    this.$chart.setOption(this.getOptions())
  }
}
</script>
<style lang="less" scoped>
  .consumer-container {
    border: 1px saddlebrown dashed;
    .top {
      height: 20%;
      border: 1px saddlebrown dashed;
      display: flex;
      justify-content: center;
      .item {
        display: flex;
        width: 40%;
        justify-content: center;
        .img {
          // width: 50%;
          cursor: pointer;
          img {
            height: 100%;
            width: 100%;
            max-height: 100%;
            max-height: 100%;
          }
        }
        .content {
          height: 100%;
          display: flex;
          flex-direction: column;
          justify-content: center;
          align-items: center;
          .value {
            font-size: var(--font-size-large);
            font-weight: bold;
          }
          // width: 50%;
        }
      }
    }
    .bottom {
      height: 80%;
      .chart-container {
        height: 100%;
        width: 100%;
      }
    }
  }
</style>