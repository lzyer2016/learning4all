### java5之前
#### 并发实现
Java Green Thread  
Java Native Thread  
#### 编程模型
`Thread`  
`Runnable`  
//实例  
#### 局限性
缺少线程管理的原生支持  
缺少“锁”API  
缺少执行完成的原生支持  
执行结果获取困难  
Double Check Locking 不确定性 
### java5 时代
#### 并发框架
JUC  
#### 编程模型 
`Exrcutor`  
`Runnable` `Callable`  
`Future`  
// 实例
### java7时代
#### 并行框架
Fork/Join  
#### 编程模型
`ForkJoinPool`  
`ForkJoinTask`  
`RecursiveAction`  
#### 局限性
1.无法手动完成    
2.阻塞结果返回    
3.无法链式多个Future    
4.无法合并多个Future结果     
5.缺少异处理
### java8时代
#### 并行框架
`CompleteableFuture`

