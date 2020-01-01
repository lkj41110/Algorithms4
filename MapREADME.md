# 算法四

## 2.符号表 

### 链表
    - 插入 查询速度都是:N 比较次数:N*N/2

### 插入排序
`Insertion.java`  
在对部分有序的或者较小规模的队列时,可能是最有效的排序方式。
### 希尔排序
`ShellSort`
希尔排序是基于插入排序的
### 归并排序
归并排序最 吸引人的性质是它能够保证将任意长度为 N 的数组排序所需时间和 NlogN成正比;它的主要缺点 则是它所需的额外空间和IN成正比。  
原地归并 —— 需要额外一个数组
- 由底向上
- 由上向下
- 优化点
### 快速排序
- 快速排序的优点:
    - 比较次数少：2NlnN  
- 算法改进：
    - 当长度小于一定的时候，变为插入排序
    - 三取样切分 TODO
    - 重复元素的处理(三向切分法)
    