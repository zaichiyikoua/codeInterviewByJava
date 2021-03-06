package designPattern.pattern2;

/*
*	设计模式   笔记3
*	@author  zaichiyikoua
*	@time  2020年1月6日
*	@description  { 工厂方法模式 }
*/

public class Factory {
    // 工厂方法模式(Factory method pattern)
    // 是静态工厂的延伸，继承了静态工厂的优点，同时弥补了缺点，更好的实现了"开闭原则"

    // 结构：1.抽象产品 2.具体产品 3.抽象工厂 4.具体工厂
    // 在工厂方法模式中，核心的工厂类不再负责产品的生产，而是交给它的具体的子类去做
    // 工厂和产品之间是具有平行的等级结构，也就是说，产品和工厂之间是"一一对应"的关系

    // 应用实例： 1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。
    // 2、Hibernate 换数据库只需换方言和驱动就可以。

    // 优点： 1、一个调用者想创建一个对象，只要知道其名称就可以了。
    // 2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。
    // 3、屏蔽产品的具体实现，调用者只关心产品的接口。

    // 缺点：每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加

    // 使用场景： 1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。
    // 2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。
}
