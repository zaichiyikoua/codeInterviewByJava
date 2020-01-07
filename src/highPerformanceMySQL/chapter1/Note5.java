package highPerformanceMySQL.chapter1;

/*
*	MySQL性能优化   学习笔记5
*	@author  zaichiyikoua
*	@time  2020年1月1日
*	@description  { 事务之 MySQL中的事务 }
*/

public class Note5 {
    // ********************************************************
    // 1.自动提交
    // ********************************************************
    // MySQL采用的是自动提交模式，也就是说，只要不是显式的开始一个事务
    // 那么每个查询都会被当作一个事务执行提交操作

    // ********************************************************
    // 2.InnoDB存储引擎
    // ********************************************************
    // InnoDB是MySQl的默认事务引擎，也是最重要的使用最广泛的存储引擎
    // 它具有自动崩溃恢复的特性
    // 除非有特殊要求，否则应该优先考虑InnoDB

    // ********************************************************
    // 3.隐式和显式锁
    // ********************************************************
    // InnoDB采用的是两阶段锁定。在事务执行过程中，随时都可以锁定
    // 锁只会在Commit或者Rollback的时候才会释放，并且要注意所有的锁会在同一时刻释放
    // 也可以显式锁定，有两个语句：
    // 1.select... lock in share mode
    // 2.select... for update
}
