<template>
  <com-card title="智慧停车">
    <div class="card-content">
      <div class="left">
        <div class="top">
          <div class="item" v-for="(item, index) in list" :key="index">
            <div class="img">
              <img :src="item.img" alt="" />
            </div>
            <div class="value"><countTo :endVal="item.value"/></div>
            <div class="label">{{ item.label }}</div>
          </div>
        </div>
        <div class="bottom" ref="chart"></div>
      </div>
      <div class="right">
        <div class="overload">
          <div class="img">
            <countTo :endVal=" ~~((overview.used * 100) / (overview.total || 1))"/>%
            <!-- {{ ~~((overview.used * 100) / (overview.total || 1)) }}% -->
          </div>
          <div class="label">停车压力</div>
        </div>
        <div class="hour">
          <div class="guage" ref="guage"></div>
          <div class="label">高峰时段</div>
        </div>
      </div>
    </div>
    <!-- 统计：{{overview}},
    停车趋势: {{parkingTrend}} -->
  </com-card>
</template>

<script>
import totalImg from "./total.png";
import overageImg from "./overage.png";
import usedImg from "./used.png";
import overloadImg from "./overload.png";
import { getParking } from "@/http/request";
import * as echarts from "echarts";

export default {
  data() {
    return {
      overview: {
        overage: 0, // 剩余
        total: 0, // 总共
        used: 0, // 已用
        overload: 0, // 压力
        peakHours: [], // 高峰时段
      },
      overloadImg,
      list: [
        {
          value: 0,
          label: "剩余车位",
          img: overageImg,
        },
        {
          value: 0,
          label: "总车位",
          img: totalImg,
        },
        {
          value: 0,
          label: "已用车位",
          img: usedImg,
        },
      ],
      parkingTrend: [], // 趋势
    };
  },
  watch: {
    parkingTrend() {
      this.$chart.setOption(this.getOptions());
    },
    overview () {
      this.$guage.setOption(this.getGuageOptions());
    }
  },
  methods: {
    async fetchData() {
      // const { overage, total, used, parkingTrend, peakHours } = await getParking();
      const { overview, parkingTrend } = await getParking();
      console.log({ overview, parkingTrend })
      this.overview = overview;
      this.parkingTrend = parkingTrend;
      // this.overview = {
      //   overage,
      //   used,
      //   total,
      //   peakHours
      // }
      this.list[0].value = overview.overage;
      this.list[1].value = overview.total;
      this.list[2].value = overview.used;
      // this.parkingTrend = parkingTrend;
    },
    getGuageOptions() {
      const baseFontSize = this.globalGetChartFontSize();
      const min = 0;
      const max = 240;
      const value = ((this.overview.peakHours) / 24) * 240;
      const option = {
        grid: {
          top: 10
        },
        series: [
          {
            type: "gauge",
            min,
            max,
            radius: '90%',
            splitNumber: 12,
            itemStyle: {
              color: "#58D9F9",
              shadowColor: "rgba(0,138,255,0.45)",
              shadowBlur: 10,
              shadowOffsetX: 2,
              shadowOffsetY: 2,
            },
            progress: {
              show: false,
              roundCap: true,
              width: 18,
            },
            pointer: {
              icon: "path://M2090.36389,615.30999 L2090.36389,615.30999 C2091.48372,615.30999 2092.40383,616.194028 2092.44859,617.312956 L2096.90698,728.755929 C2097.05155,732.369577 2094.2393,735.416212 2090.62566,735.56078 C2090.53845,735.564269 2090.45117,735.566014 2090.36389,735.566014 L2090.36389,735.566014 C2086.74736,735.566014 2083.81557,732.63423 2083.81557,729.017692 C2083.81557,728.930412 2083.81732,728.84314 2083.82081,728.755929 L2088.2792,617.312956 C2088.32396,616.194028 2089.24407,615.30999 2090.36389,615.30999 Z",
              length: "75%",
              width: 16,
              offsetCenter: [0, "5%"],
            },
            axisLine: {
              lineStyle: {
                width: baseFontSize,
                color: [
                  [0, 'rgb(123, 193, 144)'],
                  [1, 'rgb(123, 193, 144)'],
                ]
              }
            },
            axisTick: {
              show: false,
              splitNumber: 2,
              lineStyle: {
                width: 2,
                color: "#999",
              },
            },
            splitLine: {
              show: false,
            },
            axisLabel: {
              show: false,
              distance: 30,
              color: "#999",
              fontSize: 20,
            },
            title: {
              show: false,
            },
            detail: {
              color: '#4DEED9',
              offsetCenter: [0, '80%'],
              formatter: () => {
                return this.overview.peakHours
              }
            },
            data: [
              {
                value,
              },
            ],
          },
        ],
      };
      return option;
    },
    getOptions() {
      const baseFontSize = this.globalGetChartFontSize();
      const options = {
        legend: {
          top: baseFontSize * 3,
          right: baseFontSize * 2,
          data: [
            {
              name: "进场",
              icon: "rect",
              itemStyle: {
                color: "#27C2F2",
              },
            },
            {
              name: "出场",
              icon: "rect",
              itemStyle: {
                color: "#F7EB03",
              },
            },
          ],
          // data: ['进场', '出场'],
          itemWidth: baseFontSize * 4,
          itemHeight: baseFontSize,
          // itemGap: baseFontSize * 2,
          textStyle: {
            color: "#CFD2D5",
            fontSize: baseFontSize * 3,
            padding: [0, 0, 0, 10],
          },
          icon: "rect",
        },
        grid: {
          top: baseFontSize * 10,
          bottom: baseFontSize * 5,
          left: baseFontSize * 10,
          right: baseFontSize * 2,
        },
        tooltip: {
          trigger: "axis",
          axisPointer: {
            type: "cross",
            label: {
              backgroundColor: "#6a7985",
            },
          },
        },
        xAxis: [
          {
            type: "category",
            boundaryGap: false,
            data: this.parkingTrend.map((d) => d.time),
            axisLine: {
              lineStyle: {
                color: "#8EE3FF",
              },
            },
            axisTick: {
              show: false,
            },
            axisLabel: {
              fontSize: baseFontSize * 2.5,
              color: "#CFD2D5",
            },
          },
        ],
        yAxis: [
          {
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
        ],
        series: [
          {
            name: "进场",
            type: "line",
            stack: "Total",
            smooth: true,
            lineStyle: {
              width: 0,
            },
            showSymbol: false,
            areaStyle: {
              opacity: 0.8,
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: "#27CDFF",
                },
                {
                  offset: 1,
                  color: "#27cdff3d",
                },
              ]),
            },
            emphasis: {
              focus: "series",
            },
            data: this.parkingTrend.map((d) => d.comeIn),
          },
          {
            name: "出场",
            type: "line",
            stack: "Total",
            smooth: true,
            lineStyle: {
              width: 0,
            },
            showSymbol: false,
            areaStyle: {
              opacity: 0.8,
              color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [
                {
                  offset: 0,
                  color: "#F7EB03",
                },
                {
                  offset: 1,
                  color: "#f7eb033b",
                },
              ]),
            },
            emphasis: {
              focus: "series",
            },
            data: this.parkingTrend.map((d) => d.leave),
          },
        ],
      };
      return options;
    },
  },
  mounted() {
    this.$chart = echarts.init(this.$refs.chart);
    this.$chart.setOption(this.getOptions());
    this.$guage = echarts.init(this.$refs.guage);
    this.$guage.setOption(this.getGuageOptions());
    this.fetchData();
  },
};
</script>

<style lang="less" scoped>
.debugger {
  border: 1px sandybrown dashed;
}
.card-content {
  display: flex;
  .left {
    height: 100%;
    width: 70%;
    .top {
      height: 35%;
      margin-top: 5%;
      display: flex;
      justify-content: space-around;
      .item {
        height: 100%;
        display: flex;
        flex-direction: column;
        align-content: center;
        justify-content: center;
        .img {
          height: 50%;
          text-align: center;
          img {
            max-height: 100%;
            max-width: 100%;
          }
        }
        .value,
        .label {
          text-align: center;
        }
        .value {
          font-size: var(--font-size-large);
          color: var(--color-highlight);
        }
        .label {
          font-size: var(--font-size-nromal);
        }
      }
    }
    .bottom {
      height: 60%;
    }
  }
  .right {
    height: 100%;
    width: 30%;
    .overload {
      height: 60%;
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-content: center;
      padding-top: 10%;
      .img {
        height: 65%;
        width: 100%;
        background-image: url("./overload.png");
        background-position: center;
        background-repeat: no-repeat;
        display: flex;
        justify-content: center;
        align-items: center;
        font-size: var(--font-size-large);
      }
      .label {
        padding-top: var(--font-size-small);
        text-align: center;
        font-family: SourceHanSansCN-Bold;
        font-size: var(--font-size-small);
      }
    }
    .hour {
      height: 50%;
      padding-top: 5%;
      .guage {
        height: 60%;
        width: 100%;
      }
      .label {
        text-align: center;
        font-family: SourceHanSansCN-Bold;
        font-size: var(--font-size-small);
      }
    }
  }
}
</style>