package designPattern.pattern7.case1;

//具体实现类
public class Red implements Color {

    @Override
    public void bepaint(String penType, String name) {
        // TODO Auto-generated method stub
        System.out.println(penType + " red " + name);
    }

}
