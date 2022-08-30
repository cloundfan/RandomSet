# 工程简介
因为在网上没找到较好的关于生成不重复随机算法分析较好的资料，因此自己创建了这个RandomSet 项目。此项目只是简单实现一些生成不重复随机数用于实现一些抽奖场景，类似双色球抽奖。
# 延伸阅读
 1. 在测试数据较小时，random1的算法明显耗时较大，如图所示：
> ![contents](./screenshot/image1.png)
 2. 去掉random1测试数据，可以较明显看出其他三种算法在不同测试数据下的性能，如图所示：
> ![contents](https://github.com/cloundfan/RandomSet/blob/master/screenshot/image2.png)
 3. 把测试数据增大且生成随机个数也较大时，各算法性能如图所示：
> ![contents](https://github.com/cloundfan/RandomSet/blob/master/screenshot/image3.png)
# 结论
没有最好的算法，只有根据场景选择合适的算法。