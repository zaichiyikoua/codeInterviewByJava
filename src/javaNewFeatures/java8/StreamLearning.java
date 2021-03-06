package javaNewFeatures.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javaNewFeatures.java8.practice.Employee;

/**
 * java8新特性Stream学习
 * 
 * @author zaichiyikoua
 * 
 * @time 2020年4月21日
 */

public class StreamLearning {
    /**
     * 一.java8中有两大最为重要的改变
     * 
     * 1.lambda表达式 2.StreamAPI(java.util.stream.*)
     * 
     * Stream是java8中处理集合的关键抽象概念，它可以指定你希望的集合进行的操作
     * 
     * 可以执行非常复杂的查找，过了和映射数据库等操作
     * 
     * 使用streamAPI对集合数据操作，就类似与使用SQL操作数据库一样
     * 
     * 也可以使用StreamAPI来并行执行操作。
     */
    /**
     * 二.流(Stream)到底是什么？
     * 
     * 是数据渠道，用于操作数据源(集合，数组)所生成的元素序列 “集合讲的是数据结构，流讲的是计算”
     * 
     * 注意：
     * 
     * 1.Stream自己不会存储元素
     * 
     * 2.Stream不会改变源对象，会返回一个持有结果的新的Stream
     * 
     * 3.Stream操作时延迟执行的，这意味着他们会等到需要结果的时候才会执行
     */
    /**
     * 三.Stream的操作步骤
     * 
     * 1.创建一个Stream。一个数据源(比如集合、数组)，获取一个流
     * 
     * 2.中间操作。一个中间操作链，对数据源的数据进行处理
     * 
     * 3.终止操作(中段操作)。一个终止操作，执行中间操作链，并产生结果。
     */
    /**
     * 创建Stream
     */
    @SuppressWarnings("unused")
    public void StreamTest1() {
        // 1.可以通过Collection系列集合提供的Stream()(这个获取串行流)或ParallelStream()(这个获取并行流)获得
        ArrayList<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        // 2.通过Arrays工具类中的静态方法获得数组流
        Employee[] array = new Employee[10];
        Stream<Employee> stream2 = Arrays.stream(array);

        // 3.通过Stream类中的静态方法来获取流，也是带泛型的
        Stream<String> stream3 = Stream.of("aa", "bb", "cc", "dd");

        // 4.创建无限流
        // 迭代 seed=起始值 后面是一个接口，可以使用lambda表达式
        // 会一直执行+2操作
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x += 2);
        iterate.limit(10).forEach(System.out::println);
        // 生成
        // 会一直生成随机数
        Stream.generate(() -> new Random().nextInt(10)).limit(10).forEach(System.out::println);
    }

    /**
     * 中间操作不会执行任何操作，只有终止操作的时候，会一次性执行所有的操作，这被称为“延迟加载”或“惰性求值”
     */
    /*
     * 筛选与切片
     * filter---接受lambda，从流种排除某些元素
     * limit---截断流，使元素不超过指定数量
     * skip(n)---跳过元素，返回一个扔掉了前n个元素的流。如果流中元素不超过n，则返回一个空流。
     * distinct---筛选，通过流所生成元素的hashcode()和equals()去除重复元素
     */
    List<Employee> list = Arrays.asList(new Employee(100, "张三", 18, 1000), new Employee(101, "李四", 19, 1001),
        new Employee(102, "王二", 20, 1002), new Employee(103, "麻子", 21, 1003));

    // 内部迭代：迭代操作由StreamAPI自动完成
    public void StreamTest2() {
        // 拿到流，过滤年龄小于15的
        list.stream().filter((emp) -> emp.getAge() > 15).forEach(System.out::println);;
        list.stream().limit(100).forEach(System.out::println);
        list.stream().skip(3).forEach(System.out::println);
        list.stream().distinct().forEach(System.out::println);

    }

    // 外部迭代：就是最开始学集合的时候见过的iterator
    public void testIterator() {
        Iterator<Employee> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /*
     * 映射
     * map---接受lambda参数，将元素转换成其他形式或提取信息。
     * 接受一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     * faltMap---接受一个函数作为参数，将流中的每个值都替换成另一个流，然后把所有的流连接成一个流
     */
    public void StreamTest3() {
        List<String> list2 = Arrays.asList("aa", "bb", "cc", "dd");
        // 将list中的每个元素都应用，转成大写
        list2.stream().map((str) -> str.toUpperCase()).forEach(System.out::println);
        // 实际工作例子：比如说提取员工的名字
        list.stream().map((emp) -> emp.getName()).forEach(System.out::println);
        System.out.println("************************************");
    }

    /*
     * 排序
     * sorted()---自然排序
     * sorred(Comparator comp)---定制排序
     */
    public void StreamTest4() {
        list.stream().sorted().forEach(System.out::println);
        list.stream().sorted((emp1, emp2) -> {
            if (emp1.getAge().equals(emp2.getAge())) {
                // 年龄相同，按照姓名排序
                return emp1.getName().compareTo(emp2.getName());
            } else {
                return emp1.getAge().compareTo(emp2.getAge());
            }
        }).forEach(System.out::println);
    }

    /*
     * 终止操作：会从流的流水线生成结果，其结果可以是任何不是流的值，例如：List，Integer甚至是void
     */
    /*
     * 查找与匹配
     * allMatch---检查是否匹配全部元素
     * anyMatch---检查是否至少匹配一个元素(至少有一个元素满足条件)
     * noneMatch---检查是否没有匹配任何元素
     * findFirst---返回第一个元素
     * findAny---返回当前流中的任意值
     * count---返回流中元素的数量
     * max---返回流中最大的元素
     * min---返沪流中最小的元素
     */
    @SuppressWarnings("unused")
    public void StreamTest5() {
        // 可以清楚的看到各个查找与匹配的返回结果
        boolean allMatch = list.stream().allMatch((emp) -> emp.getAge() > 18);
        boolean anyMatch = list.stream().anyMatch((emp) -> emp.getAge() > 18);
        boolean noneMatch = list.stream().noneMatch((emp) -> emp.getAge() > 18);

        // 这个Optional是一个容器类 java8中尽可能的去避免空指针异常
        // 如果返回的值一旦有可能为空，就会封装进op中
        // 比如说findFirst，有可能就没有第一个元素
        Optional<Employee> findFirst = list.stream().findFirst();
        Employee employee = findFirst.get();
        // 比如说过滤出年龄小于18的，然后随便返回一个
        Optional<Employee> findAny = list.stream().filter((emp) -> emp.getAge() < 18).findAny();
        Employee employee2 = findAny.get();

        long count = list.stream().count();
        // comparator这是一个接口，要自己写基于怎样规则得到的最大值，同理min也是一样
        // list.stream().max(comparator);
    }

    /*
     * 规约  这个很重要，map和reduce的连接通常被称为map-reduce模式，配合使用
     * reduce---将流中元素反复结合起来 ，得到一个值
     */
    @SuppressWarnings("unused")
    public void StreamTest6() {
        List<Integer> asList = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 比如说计算总和 第一个参数identity起始值 第二个参数accumulator计算
        Integer reduce = asList.stream().reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println("****************");

        // 计算工资总和 先拿到所有的工资，然后计算总和
        Optional<Integer> reduce2 = list.stream().map((emp) -> emp.getSalary()).reduce(Integer::sum);
        Integer integer = reduce2.get();
    }

    /*
     * 收集
     * collect---将流转换成其他形式，接受一个collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @SuppressWarnings("unused")
    public void StreamTest7() {
        // collector接口，java为我们提供了一个方便的工具类Collectors
        // 比如收集emp的名字到一个集合中
        // 到list中
        List<String> collect = list.stream().map(Employee::getName).collect(Collectors.toList());
        // 到set中
        Set<String> collect2 = list.stream().map(Employee::getName).collect(Collectors.toSet());
        // 到特殊的指定集合中
        HashSet<String> collect3 = list.stream().map(Employee::getName).collect(Collectors.toCollection(HashSet::new));
        System.out.println("*****************************");
        // 收集得到总数
        Long countLong = list.stream().collect(Collectors.counting());
        // 得到平均值
        Double aveDouble = list.stream().collect(Collectors.averagingInt(Employee::getSalary));
        // 得到总和
        Integer sumInteger = list.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("*****************************");
        // 分组返回的是一个map
        Map<Integer, List<Employee>> groupMap = list.stream().collect(Collectors.groupingBy(Employee::getAge));
        // 多级分组 比如先按照年龄，再按照其他
        Map<Integer, Map<Integer, List<Employee>>> groupMap2 =
            list.stream().collect(Collectors.groupingBy(Employee::getAge, Collectors.groupingBy(Employee::getSalary)));
        // 连接字符
        String joinString = list.stream().map(Employee::getName).collect(Collectors.joining(","));
    }
}
