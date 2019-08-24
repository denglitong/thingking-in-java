# 集合

> collection classes(container classes): List, Set, Queue, Map  

> 数组将数字索引与对象相关联，大小固定不可更改  
Collection保存单一的元素，Map包含相关联的键值对  
集合不能保存基本类型，但自动装箱机制会负责执行基本类型和集合中保存的包装类型之间的双向转换      
如要执行大量的随机访问，则使用ArrayList，如果有经常从表中插入或删除元素，则应该使用LinkedList  
Queue和堆栈（使用Deque双向队列可以提供堆栈的行为）的行为是通过LinkedList来提供的  
Map是一种将对象与对象相关联的设计，HashMap专为快速访问而设计，而TreeMap保持键始终处于排序状态所以没有HashMap快  
LinkedHashMap按插入顺序保存其元素，但使用散列提供快速访问的能力  
Set不接受重复元素，HashSet提供最快的查询速度，而TreeSet保持元素处于排序状态，LinkedHashSet按插入的顺序保存其元素但使用散列提供快速访问的能力  

> 不要在新代码中使用遗留类Vector, HashTable和Stack  
