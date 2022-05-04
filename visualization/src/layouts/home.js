import Header from '@/views/home/header';
import Overview from '@/views/home/overview';
import Operation from '@/views/home/operation';
import Consume from '@/views/home/consume';
import Company from '@/views/home/company';
import Parking from '@/views/home/parking';
import Office from '@/views/home/office';
import Security from '@/views/home/security';
import Notice from '@/views/home/notice';

const leftX = 77;
const leftWidth = 761;
const rightX = 2983;
const rightWidth = 761;
const bottom = 78;

export default {
  size: [3840, 2160], // 设计稿尺寸，非实际尺寸
  components: [{
    x: 0,
    y: 0,
    width: 3840,
    height: 184,
    z: 0,
    use: Header
  }, {
    x: leftX,
    y: 234,
    width: leftWidth,
    height: 717 - 234,
    z: 0,
    use: Overview
  }, {
    x: leftX,
    y: 717,
    width: leftWidth,
    height: 1242 - 717,
    use: Operation
  }, {
    x: leftX,
    y: 1242,
    width: leftWidth,
    height: 2160 - bottom - 1242,
    use: Company
  }, {
    x: 894,
    y: 1392,
    width: 980,
    height: 2160 - bottom - 1392,
    use: Parking
  }, {
    x: 1925,
    y: 1392,
    height: 2160 - bottom - 1392,
    width: 894,
    use: Office
  }, {
    x: rightX,
    y: 234,
    width: rightWidth,
    height: 920 - 234,
    use: Consume
  }, {
    x: rightX,
    y: 920,
    width: rightWidth,
    height: 1546 - 920,
    use: Security
  }, {
    x: rightX,
    y: 1546,
    width: rightWidth,
    height: 2160 - bottom - 1546,
    use: Notice
  }]
}