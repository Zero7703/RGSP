## Api 列表

### 1. 园区概况


```js
{
  area: 100,  // 占地面积
  duration: 10, // 运营时长
  staffNums: 1000 // 工作人员
}
```

### 2. 运营总览

```js
{
  occupancyRate: 60,  // 入驻率, 百分比例
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
```

### 3. 企业概况

```js
{
  industryCount: [{
    name: '互联网',
    value: 100
  }, {
    name: '通信',
    value: 33
  }, {
    name: '医疗',
    value: 22
  }],  // 行业统计
  fundsCount: [{
    label: '100万',
    value: 26
  }, {
    label: '300万',
    value: 18
  }, {
    label: '500万',
    value: 19
  }, {
    label: '1000万',
    value: 10
  }, {
    label: '2000万',
    value: 9
  }, {
    label: '6000万',
    value: 5
  }]  // 资金分布
}
```

> 资金分布 必须返回6条纪录

### 4. 智慧停车

```js
{
  overview: {
    overage: 100, // 剩余
    total: 200, // 总共
    used: 100, // 已用
    overload: 80, // 压力
    peakHours: "待定" // 高峰时段 
  },
  parkingTrend: [{
    time: '00',
    comeIn: 10,
    leave: 10,
  }, {
    time: '01',
    comeIn: 10,
    leave: 10
  }, 
    ...
  {
    time: '24',
    comeIn: 10,
    leave: 10
  }] // 趋势以小时为单位，共24个
}
```

### 5. 智慧办公

```js
{
  total: 10000, // 总预约时长
  appointmentTrend: [{
    date: '04/01',
    value: 100
  }, {
    date: '04/01',
    value: 200
  },
  ...
  {
    date: '04/19',
    value: 300
  }]  // 预约趋势, 最近30天
}
```

### 6. 智慧能耗

```js
{
  energyUsed: 1000, // 用电量
  waterConsumption: 1000, // 用水量
  energyUsedTop: [{
    name: '1栋',
    value: 100
  }, {
    name: '2栋',
    value: 20
  }], // 用电量top
  waterConsumptionTop: [{
    name: '1栋',
    value: 100
  }, {
    name: '2栋',
    value: 20
  }] // 用水量 TOP
}
```

### 7. 智慧安防

```js
{
  monitor: 100, // 监控
  smokeSensor: 100,   // 烟感
  temperatureSensor: 100,  // 温感
}
```

### 8. 通知公告

#### 8.1 公告列表

```js
{
  noticeList: [{
    id: 'id_xxx',
    date: '04/11',
    content: '关于做好疫情防控'
  }, {
    id: 'id_xxx',
    date: '04/11',
    content: '关于做好疫情防控'
  }]
}
```

#### 8.2 通知详情

详情内容待定，根据详情内容决定是否需要详情接口