<template>
  <com-card title="智慧办公">
    <div class="card-content">
      <div class="top">
        <div class="img"></div>
        <div class="label">会议室</div>
        <div class="value">
          <countTo :endVal="total"/>h
        </div>
      </div>
      <div class="bottom" ref="chart"></div>
    </div>
    <!-- 预约时长: {{total}}
    预约趋势: {{appointmentTrend}} -->
  </com-card>
</template>

<script>
import { getOffice } from '@/http/request';
import * as echarts from 'echarts';

export default {
  data () {
    return {
      total: 10000, // 总预约时长
      appointmentTrend: []  // 预约趋势
    }
  },
  watch: {
    appointmentTrend () {
      this.$chart.setOption(this.getOptions());
    }
  },
  methods: {
    getOptions () {
      const baseFontSize = this.globalGetChartFontSize();
      const category = this.appointmentTrend.map(d => d.date);
      const options = {
        tooltip: {},
        grid: {
          bottom: baseFontSize * 4,
          left: baseFontSize * 6,
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
            fontSize: baseFontSize * 2.5
          }
        },
        yAxis: {
          type: "value",
          axisLabel: {
            fontSize: baseFontSize * 2.5,
            color: "#CFD2D5",
          },
          axisTick: {
            interval: 3,
          },
          splitLine: {
            lineStyle: {
              color: "#27cdff38",
            },
          },
        },
        series: [
          {
            name: '时长',
            type: 'bar',
            barWidth: baseFontSize * 1.2,
            data: this.appointmentTrend.map(d => {
              return {
                value: d.value,
                itemStyle: {
                  borderRadius: [10, 10, 0, 0],
                  color: new echarts.graphic.LinearGradient(0, 1, 0, 0, [
                    { offset: 1, color: '#4DEED9' },
                    { offset: 0, color: '#4deed900' },
                  ])
                },
              }
            }),
            label: {
              show: false,
            }
          }
        ]
      }
      return options;
    },
    async fetchData () {
      const { total,  appointmentTrend } = await getOffice();
      this.total = total;
      this.appointmentTrend = appointmentTrend;
    }
  },
  mounted () {
    this.$chart = echarts.init(this.$refs.chart);
    this.$chart.setOption(this.getOptions());
    this.fetchData();
  }
}
</script>

<style lang="less" scoped>
  .card-content {
    height: 100%;
  }
  .top {
    height: 30%;
    display: flex;
    justify-content: center;
    align-items: center;
    .img {
      height: calc(var(--font-size-large) * 2);
      width: calc(var(--font-size-large) * 2);
      background-repeat: no-repeat;
      background-image: url('./meeting.png');
      background-position: center;
      background-size: contain;
    }
    .label {
      margin: 0 var(--font-size-large);
      font-size: var(--font-size-medium);
    }
    .value {
      font-size: var(--font-size-large);
      color: var(--color-highlight);
    }
  }
  .bottom {
    height: 70%;
  }
</style>