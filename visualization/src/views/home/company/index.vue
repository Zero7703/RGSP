<template>
  <com-card title="企业概况">
    <div class="card-content">
      <div class="industry" ref="chart">

      </div>
      <div class="funds-container">
        <div class="content">
          <div class="item" v-for="(item, index) in fundsCount" :key="index">
            <div class="line" :style="{
              width: `${34 + index * 2.4}%`
            }"></div>
            <div class="label">
              {{item.label}}
              <span class="num">
                <countTo :endVal="item.value"/>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </com-card>
</template>

<script>
import { getCompany } from '@/http/request';
import * as echarts from 'echarts';

export default {
  data () {
    return {
      industryCount: [],  // 行业统计
      fundsCount: [],  // 资金分布
    }
  },
  watch: {
    industryCount () {
      this.$chart.setOption(this.getIndustryOptions());
    }
  },
  methods: {
    getIndustryOptions () {
      const baseFontSize = this.globalGetChartFontSize();
      const nameMap = {};
      let total = 0;
      this.industryCount.forEach(d => {
        total += d.value;
        nameMap[d.name] = d.value;
      })
      const tickNums = 200;
      const tickData = [];
      for (let i =0; i < tickNums; ++i) {
        tickData.push({
          value: 1,
          itemStyle: {
            color: '#427CFF',
            opacity: i % 4 === 0 ? 1 : 0
          }
        })
      }
      const options = {
        legend: {
          show: true,
          orient: 'vertical',
          right: '30%',
          type: 'plain',
          top: 'center',
          itemWidth: baseFontSize * 2.8,
          itemHeight: baseFontSize * 3,
          itemGap: baseFontSize * 2,
          textStyle: {
            color: '#CFD2D5',
            fontSize: baseFontSize * 3,
            padding: [0, 0, 0, 10]
          },
          formatter: (params) => {
            if (nameMap[params]) {
              return params + `  ${Math.round((nameMap[params] * 100 / total))}%`
            }
            return params
          }
        },
        color: ['#4DEED9', '#FDC91E'],
        series: [{
          center: ['25%', '50%'],
          name: 'outter',
          type: 'pie',
          label: {
            show: false
          },
          silent: true,
          radius: ['75%', '76%'],
          data: tickData,
        }, {
          name: 'data',
          type: 'pie',
          center: ['25%', '50%'],
          radius: ['45%', '60%'],
          label: {
            show: false
          },
          data: this.industryCount.map(d => {
            return {
              name: d.name,
              value: d.value
            }
          })
        }]
      }
      return options;
    },
    async fetchData () {
      const { industryCount, fundsCount } = await getCompany();
      this.industryCount = industryCount;
      this.fundsCount = fundsCount;
    }
  },
  mounted () {
    this.$chart = echarts.init(this.$refs.chart);
    this.$chart.setOption(this.getIndustryOptions());

    this.fetchData();
  }
}
</script>

<style lang="less" scoped>
  .industry {
    height: 40%;
  }
  .funds-container {
    height: 60%;
    padding: 5%;
    .content {
      height: 100%;
      background-image: url('./level.png');
      background-repeat: no-repeat;
      background-position-y: 0%;
      background-position-x: 0%;
      background-size: contain;
      display: flex;
      flex-direction: column;
      justify-content: space-between;
      .item {
        font-size: var(--font-size-nromal);
        display: flex;
        justify-content: flex-end;
        align-items: center;
        .line {
          height: 2px;
          background-size: 10px 20px;
          opacity: 0.5;
          background-image: linear-gradient(
            90deg,
            #427CFF 70%, 
            transparent 70%
          )
        }
        .label {
          padding-left: var(--font-size-nromal / 2);
          width: 32%;
          display: flex;
          justify-content: space-around;
          .num {
            margin-left: 20px;
          }
        }
      }
    }
  }
</style>