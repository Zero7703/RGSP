<template>
  <com-card title="智慧安防">
    <div class="card-content">
      <div class="img">
        <div class="item temperatureSensor">
          <div class="value"><countTo :endVal="temperatureSensor"/></div>
          <div class="label">温感</div>
        </div>
        <div class="item monitor">
          <div class="value"><countTo :endVal="monitor"/></div>
          <div class="label">监控</div>
        </div>
        <div class="item smokeSensor">
          <div class="value"><countTo :endVal="smokeSensor"/></div>
          <div class="label">烟感</div>
        </div>
      </div>
    </div>
    <!-- 监控: {{monitor}}
    烟感: {{smokeSensor}}
    温感: {{temperatureSensor}} -->
  </com-card>
</template>

<script>
import { getSecurity } from '@/http/request';

export default {
  data () {
    return {
      monitor: 100, // 监控
      smokeSensor: 100,   // 烟感
      temperatureSensor: 100,  // 温感
    }
  },
  methods: {
    async featchData () {
      const { monitor, smokeSensor, temperatureSensor } = await getSecurity();
      this.temperatureSensor = temperatureSensor;
      this.smokeSensor = smokeSensor;
      this.monitor = monitor;
    }
  },
  mounted () {
    this.featchData();
  }
}
</script>

<style lang="less" scoped>
  .card-content {
    padding: 20% 10% 10% 10%;
  }
  .img {
    position: relative;
    height: 100%;
    width: 100%;
    background-image: url('./img.png');
    background-position: center;
    background-repeat: no-repeat;
    background-size: contain;
    .item {
      position: absolute;
      .value {
        font-size: var(--font-size-small);
        color: var(--color-highlight);
        font-weight: bold;
        text-align: center;
      }
      .label {
        text-align: center;
        font-size: var(--font-size-nromal);
      }
    }
    .temperatureSensor {
      top: calc(0px - (var(--font-size-small) * 2.5));
      left:  calc((var(--font-size-small) * 1.5))
    }
    .monitor {
      bottom: calc((var(--font-size-small) * 6  ));
      left: calc(var(--font-size-small));
    }
    .smokeSensor {
      right: var(--font-size-small);
      bottom: calc((var(--font-size-small) * 6));
    }
  }
</style>