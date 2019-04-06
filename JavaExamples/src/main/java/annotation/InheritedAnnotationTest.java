package annotation;

import java.lang.reflect.Method;

public class InheritedAnnotationTest {

    public static void main(String[] args) throws SecurityException, NoSuchMethodException {

        Class<SubClassImpl> clazz = SubClassImpl.class;

//        表示这个注解可以继承超类注解。注意：这个注解只能用来声明类 ,下方为对类的注解
//        abstractMethod
//        Method method = clazz.getMethod("abstractMethod", new Class[]{});
//        if(method.isAnnotationPresent(InheritedAnnotation.class)){
//            InheritedAnnotation ma = method.getAnnotation(InheritedAnnotation.class);
//            System.out.println("子类实现的抽象方法继承到父类抽象方法中的Annotation,其信息如下：");
//            System.out.println(ma.value());
//        }else{
//            System.out.println("子类实现的抽象方法没有继承到父类抽象方法中的Annotation");
//        }
//
//
//
//
//        Method methodOverride = clazz.getMethod("doExtends", new Class[]{});
//        if(methodOverride.isAnnotationPresent(InheritedAnnotation.class)){
//            InheritedAnnotation ma = methodOverride.getAnnotation(InheritedAnnotation.class);
//            System.out.println("子类doExtends方法继承到父类doExtends方法中的Annotation,其信息如下：");
//            System.out.println(ma.value());
//        }else{
//            System.out.println("子类doExtends方法没有继承到父类doExtends方法中的Annotation");
//        }
//        该方法为错误示范样例
        InheritedAnnotation cla = clazz.getAnnotation(InheritedAnnotation.class);
        if (cla != null) {
            System.out.println(cla.value());
        } else {
            System.out.println("cla's value is null");
        }


    }

}