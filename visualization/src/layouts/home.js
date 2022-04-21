import Header from '@/components/header';
// import Overview from '@/views/home/overview';
// import Operation from '@/views/home/operation';
import Consume from '@/views/home/consume';

export default {
  size: [3840, 2160], // 设计稿尺寸，非实际尺寸
  components: [{
    x: 0,
    y: 0,
    width: 1000,
    height: 100,
    z: 0,
    use: Header
  }, {
    x: 100,
    y: 100,
    width: 800,
    height: 500,
    use: Consume
  }]
}