package designPattern.pattern1;

/*
*	设计模式   笔记2
*	@author  zaichiyikoua
*	@time  2020年1月3日
*	@description  { 简单工厂模式 }
*/

public class SimpleFactory {
    // 简单工厂模式(Simple factory pattern)
    // 简单工厂模式不属于23种设计模式之一，但是应用频繁，也是其他创建型模式的基础
    // 简单工厂模式又叫做静态工厂方法,核心是工厂类

    // 结构比较简单：1.工厂角色 2.抽象产品角色 3.具体实现的产品角色
    // 例子可见case1，以电视机为例

    // 工厂模式的优缺点：
    // 1.优点：
    // 1.1工厂类含有必要的逻辑判断，可以决定什么时候来创建哪一个产品，避免了直接操作对象
    // 1.2客户端不用知道具体的产品的名字，只需要知道具体产品对应的参数即可
    // 2.缺点：
    // 2.1扩展性特别差，不满足开闭原则(这点是最重要的)
    // 2.2工厂方法因为是静态的，所以工厂角色无法形成基于继承的等级结构
}
