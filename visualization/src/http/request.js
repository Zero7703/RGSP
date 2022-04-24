import axios from 'axios'
import http from './index'

/**
 * 概况
 */
export const getOverview = async () => {
  return Promise.resolve({
    area: ~~(Math.random() * 100),
    duration: ~~(Math.random() * 10000),
    staffNums: ~~(Math.random() * 1000)
  })
}

/**
 * 运营总览
 */
export const getOperation = async () => {
  const occupancyStatistics = [{
    label: '1年',
    value: ~~(Math.random() * 100),
  }, {
    label: '2年',
    value: ~~(Math.random() * 100),
  }, {
    label: '3年',
    value: ~~(Math.random() * 100),
  }, {
    label: '4年',
    value: ~~(Math.random() * 100),
  }, {
    label: '5年以上',
    value: ~~(Math.random() * 100),
  }]
  return Promise.resolve({
    occupancyRate: ~~(Math.random() * 100),
    occupancyStatistics: occupancyStatistics.sort((a, b) => {
      return a.value > b.value ? -1 : 1;
    })
  })
}

/**
 * 企业概况
 */
export const getCompany = async () => {
  const industryCount = [{
    name: '互联网',
    value: 100
  }, {
    name: '通信',
    value: 33
  }]
  const fundsCount = [{
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
  }]
  return Promise.resolve({
    industryCount,
    fundsCount
  })
}

/**
 * 智慧停车
 * http://124.220.176.90:18888/screen/smartParking/getSmartParkingInfo
 */
export const getParking = async () => {
  console.log('')
  const {
    data: {
      data
    }
  } = await http.post('/screen/smartParking/getSmartParkingInfo');
  return Promise.resolve(data)
}

/**
 * 智慧办公
 */
export const getOffice = async () => {
  const days = 30;
  const total = ~~(Math.random() * 10000);
  const appointmentTrend = [];
  for (let i = 0; i < days; ++i) {
    appointmentTrend.push({
      date: `03/${i < 10 ? '0' + i : 0}`,
      value: ~~(Math.random() * 100)
    })
  }
  return Promise.resolve({
    total,
    appointmentTrend
  })
}

/**
 * 智慧能耗
 */
export const getConsume = async () => {
  const energyUsed = ~~(Math.random() * 1000);
  const waterConsumption = ~~(Math.random() * 1000);
  const energyUsedTop = [];
  const waterConsumptionTop = [];
  for (let i = 0; i < 5; ++i) {
    energyUsedTop.push({
      name: `${i + 1} 栋`,
      value: ~~(Math.random() * 1000)
    })
    waterConsumptionTop.push({
      name: `${i + 1} 栋`,
      value: ~~(Math.random() * 1000)
    })
  }
  return Promise.resolve({
    energyUsed,
    waterConsumption,
    energyUsedTop,
    waterConsumptionTop
  })
}

/**
 * 安防
 */
export const getSecurity = async () => {
  const monitor = ~~(Math.random() * 1000);
  const smokeSensor = ~~(Math.random() * 1000);
  const temperatureSensor = ~~(Math.random() * 1000);
  return Promise.resolve({
    monitor,
    smokeSensor,
    temperatureSensor
  })
}

/**
 * notice
 */
export const getNotice = async () => {
  const list = [];
  for (let i = 0 ; i < 10; ++i) {
    list.push({
      id: i,
      date: `04/${i}`,
      content: '关于做好疫情防控关于做好疫情防控关于做好疫情防控关于做好疫情防控关于做好疫情防控' + i
    })
  }
  return Promise.resolve({
    noticeList: list
  })
}