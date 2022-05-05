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

const leftX = 77;
const leftWidth = 614;
const rightX = 3411;
const rightWidth = 614;
const bottom = 78;
const top = 152;
const headerHeight = 152;

export default {
  size: [...screenSize], // 设计稿尺寸，非实际尺寸
  components: [{
    x: 0,
    y: 0,
    width: screenSize,
    height: headerHeight,
    z: 0,
    use: Header
  }, {
    x: leftX,
    y: top,
    width: leftWidth,
    height: 542 - top,
    z: 0,
    use: Overview
  }, {
    x: leftX,
    y: 542,
    width: leftWidth,
    height: 966 - 542,
    use: Operation
  }, {
    x: leftX,
    y: 966,
    width: leftWidth,
    height: screenSize[1] - bottom - 966,
    use: Company
  }, {
    x: 894,
    y: 1240,
    width: 1362,
    height: screenSize[1] - bottom - 1240,
    use: Parking
  }, {
    x: 2380,
    y: 1240,
    height: screenSize[1] - bottom - 1240,
    width: 857,
    use: Office
  }, {
    x: rightX,
    y: top,
    width: rightWidth,
    height: 712 - top,
    use: Consume
  }, {
    x: rightX,
    y: 712,
    width: rightWidth,
    height: 1218 - 712,
    use: Security
  }, {
    x: rightX,
    y: 1218,
    width: rightWidth,
    height: screenSize[1] - bottom - 1218,
    use: Notice
  }]
}