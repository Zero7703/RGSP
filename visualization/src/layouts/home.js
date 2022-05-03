import Header from '@/views/home/header';
import Overview from '@/views/home/overview';
import Operation from '@/views/home/operation';
import Consume from '@/views/home/consume';
import Company from '@/views/home/company';
import Parking from '@/views/home/parking';
import Office from '@/views/home/office';
import Security from '@/views/home/security';
import Notice from '@/views/home/notice';
import { screenSize } from '@/constants';

const leftX = 81;
const leftWidth = 708;
const left2X = 890;
const left2Width = 708;

const rightX = 5747;
const rightWidth = 708;
const right2X = 4834;
const right2Width = 708;
const bottom = 85;
const top = 228;

export default {
  size: [...screenSize], // 设计稿尺寸，非实际尺寸
  components: [
    {
      x: 0,
      y: 0,
      width: screenSize[0],
      height: 159,
      z: 0,
      use: Header // 标题
    }, 
      {
      x: leftX,
      y: top,
      width: leftWidth,
      height: 804 - top,
      z: 0,
      use: Overview // 园区概况
    }, 
    {
      x: left2X,
      y: top,
      width: left2Width,
      height: 873 - top,
      use: Operation  // 运营总览
    }, 
    {
      x: leftX,
      y: 805,
      width: leftWidth,
      height: screenSize[1] - bottom - 805,
      use: Company    // 企业概况
    }, 
    {
      x: right2X,
      y: top,
      width: right2Width,
      height: 1027 - top - 100,
      use: Parking  // 停车
    },
    {
      x: left2X,
      y: 873,
      height: screenSize[1] - bottom - 873,
      width: left2Width,
      use: Office // 智慧办公
    }, 
    {
      x: rightX,
      y: top,
      width: rightWidth,
      height: 1024 - top - 100,
      use: Consume  // 能耗
    }, 
    {
      x: right2X,
      y: 1027,
      width: rightWidth,
      height: screenSize[1] - 1027,
      use: Security // 安防
    }, 
    {
      x: rightX,
      y: 1024,
      width: rightWidth,
      height: screenSize[1] - bottom - 1024,
      use: Notice // 通知
    }
  ]
}