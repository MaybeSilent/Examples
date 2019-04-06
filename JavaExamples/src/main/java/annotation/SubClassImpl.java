package annotation;

public class SubClassImpl extends AbstractParent {

    @Override
    public void abstractMethod() {
        System.out.println("子类实现抽象父类的抽象方法");
    }

}
