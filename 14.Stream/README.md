# 流式编程

> 集合优化了对象的存储，而流和对象的处理有关  
在大多数情况下，将对象存储在集合中是为了处理他们  
流是一系列与特定存储机制无关的元素  
利用流，我们无需迭代集合中的元素，就可以提取和操作他们。这些管道通常被组合在一起，
在流上形成一条操作管道

> 流操作的类型有3种：创建流、修改流元素（中间操作 Intermediate Operation）、
消费流元素（终端操作 Terminal Operations，通常意味着收集流元素，通常收集到集合中）

> 流的终端操作

> 转化成数组  
.toArray()  
.toArray(generator)

> 对每个元素应用最终操作  
.forEach(Consumer)  
.forEachOrdered(Consumer)    
.parallel() 利用多核CPU并行执行  
.collect() 收集流元素  
.reduce() 将流元素打平成单个值  
.match() 判断流元素是否满足match条件  
.findFirst() 选择元素  
.count() 流中的元素个数  
.max(Comparator) 最大值  
.min(Comparator) 最小值  
.average() 求流元素平均值  
.sum() 求和  
.summaryStatistics() 生成可能有用的数据{count=,sum=,min=,average=,max=}  

> 流极大的提升了Java编程的性质，并可能极大的阻止了Java编程人员想诸如Scala这种函数式语言的流动  