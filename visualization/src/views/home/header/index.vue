<template>
  <div class="header-container bg-img">
    <div class="title">
      如皋软件园智慧园区
    </div>
  </div>
</template>

<style lang="less" scoped>
  .header-container {
    background-image: url('./bg.png');
    background-size: contain;
    background-repeat: no-repeat;
    background-position-x: center;
    display: flex;
    justify-content: center;
    font-size: var(--font-size-header);
    color: var(--color-card-header);
    font-family: "YouSheBiaoTiHei";
    font-size: var(--font-size-header);
    font-weight: 400;
    .title {
      height: 90%;

      
      display: flex;
      align-items: center;
      // padding-top: calc(var(--font-size-header) / 3);
    }
  }
</style>