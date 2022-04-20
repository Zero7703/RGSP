<template>
  <com-card title="运营总览">
    <div class="card-content operation-container">
      <div class="left">
        <div class="rate">
          {{occupancyRate}}%
        </div>
        <div class="label">入驻率</div>
      </div>
      <div class="right" ref="chart">
      </div>
    </div>
    <!-- 入驻率：,
    入驻统计: {{occupancyStatistics}} -->
  </com-card>
</template>

<script>
import * as echarts from 'echarts';

export default {
  data () {
    return {
      occupancyRate: 60,  // 入驻率
      occupancyStatistics: [{
        label: '1年',
        value: 100
      }, {
        label: '2年',
        value: 100
      }, {
        label: '3年',
        value: 100
      }, {
        label: '4年',
        value: 100
      }, {
        label: '5年以上',
        value: 10
      }]  // 入驻统计
    }
  },
  methods: {
    getOptions () {
      const category = this.occupancyStatistics.map(d => d.label);
      return {
        tooltip: {},
        grid: {
          bottom: 40
        },
        xAxis: {
          data: category,
          axisLine: {
            show: false
          },
          axisTick: {
            show: false
          },
          axisLabel: {
            color: 'white',
            fontSize: 15
          }
        },
        yAxis: {
          show: false
        },
        series: [
          {
            name: '入驻',
            type: 'bar',
            barWidth: 10,
            data: this.occupancyStatistics.map(d => {
              return {
                value: d.value,
                itemStyle: {
                  color: 'rgb(120,190,203)',
                  borderRadius: [0, 0, 5, 5]
                },
              }
            }),
            label: {
              show: true,
              position: 'top',
              offset: [0, -10],
              color: 'white'
            },
            markPoint: {
              data: this.occupancyStatistics.map((d, i) => {
                return {
                  coord: [category[i], d.value],
                  symbol: 'circle',
                  symbolSize: 15,
                  itemStyle: {
                    color: 'rgb(120,190,203)'
                  }
                }
              })
            }
          }
        ]
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
  .operation-container {
    display: flex;
    padding: 10% 5%;
    .left {
      width: 30%;
      text-align: center;
      .rate {
        color: var(--color-primary);
        font-size: var(--font-size-large);
      }
      .label {
        color: var(--color-primary);
      }
    }
    .right {
      width: 70%;
      border: 1px darkcyan dashed;
    }
  }
</style>