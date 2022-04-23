<template>
  <com-card title="运营总览">
    <div class="card-content operation-container">
      <div class="left">
        <div class="rate" ref="pie">
          <!-- {{occupancyRate}}% -->
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
import { getOperation } from '@/http/request';

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
  watch: {
    occupancyRate () {
      this.$pie.setOption(this.getPieOptions());
    },
    occupancyStatistics () {
      this.$chart.setOption(this.getOptions());
    }
  },
  methods: {
    async fetchData () {
      const { occupancyRate, occupancyStatistics } = await getOperation();
      this.occupancyRate = occupancyRate;
      this.occupancyStatistics = occupancyStatistics;
    },
    getPieOptions () {
      const baseFontSize = this.globalGetChartFontSize();
      const tickNums = 200; 
      const tickData = [];
      for (let i =0; i < tickNums; ++i) {
        tickData.push({
          value: 1,
          itemStyle: {
            color: '#06F8A8',
            opacity: i % 4 === 0 ? 1 : 0
          }
        })
      }
      const options = {
        title: {
          show: true,
          text: this.occupancyRate + '%',
          textAlign: 'center',
          textVerticalAlign: 'center',
          left: '50%',
          top: '50%',
          textStyle: {
            color: '#4DEED9',
            fontSize: baseFontSize * 4
          }
        },
        legend: { show: false },
        series: [{
          name: 'outter',
          type: 'pie',
          label: {
            show: false
          },
          silent: true,
          radius: ['75%', '85%'],
          data: tickData,
          // data: [{
          //   value: 100
          // }]
        }, {
          name: 'inner',
          type: 'pie',
          radius: ['50%', '52%'],
          silent: true,
          data: [{
            value: 100,
            itemStyle: {
              color: '#06F8A8'
            }
          }],
          label: {
            show: false
          }
        }, {
          name: 'data',
          type: 'pie',
          radius: ['50%', '60%'],
          label: {
            show: false
          },
          data: [{
            value: 100 - this.occupancyRate,
            itemStyle: {
              opacity: 0
            },
            tooltip: {
              formatter: () => null
            }
          }, {
            value: this.occupancyRate,
            name: '入驻率',
            itemStyle: {
              color: new echarts.graphic.LinearGradient(0, 1, 1, 0, [
                { offset: 0, color: '#4DEED9' },
                { offset: 1, color: '#E5B408' },
              ])
            }
          }]
        }]
      }
      return options;
    },
    getOptions () {
      const baseFontSize = this.globalGetChartFontSize();
      const category = this.occupancyStatistics.map(d => d.label);
      return {
        tooltip: {},
        grid: {
          bottom: baseFontSize * 4,
          left: baseFontSize,
          right: baseFontSize,
          top: baseFontSize * 5
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
            interval: false,
            fontSize: baseFontSize * 2.5
          }
        },
        yAxis: {
          show: false
        },
        series: [
          {
            name: '入驻',
            type: 'bar',
            barWidth: baseFontSize * 1.2,
            data: this.occupancyStatistics.map(d => {
              return {
                value: d.value,
                itemStyle: {
                  borderRadius: [0, 0, 5, 5],
                  color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [
                    { offset: 1, color: '#4DEED9' },
                    { offset: 0, color: '#4deed900' },
                  ])
                },
              }
            }),
            label: {
              show: true,
              position: 'top',
              offset: [0, -10],
              color: 'white',
              fontSize: baseFontSize * 2.5
            },
            markPoint: {
              data: this.occupancyStatistics.map((d, i) => {
                return {
                  coord: [category[i], d.value],
                  symbol: 'circle',
                  symbolSize: baseFontSize * 2.5,
                  itemStyle: {
                    borderColor: 'white',
                    color: '#4DEED9'
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
    this.$chart.setOption(this.getOptions());
    this.$pie = echarts.init(this.$refs.pie);
    this.$pie.setOption(this.getPieOptions());
    this.fetchData();
  }
}
</script>

<style lang="less" scoped>
  .operation-container {
    display: flex;
    padding: 10% 0%;
    .left {
      width: 40%;
      text-align: center;
      .rate {
        height: 95%;
        color: var(--color-primary);
        font-size: var(--font-size-large);
      }
      .label {
        color: var(--color-highlight);
        font-size: var(--font-size-nromal);
      }
    }
    .right {
      width: 60%;
    }
  }
</style>