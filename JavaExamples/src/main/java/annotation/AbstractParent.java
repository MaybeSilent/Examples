package annotation;

@InheritedAnnotation("parents for InheritedAnnotation")
public abstract class AbstractParent {

    public abstract void abstractMethod();

    public void doExtends() {
        System.out.println(" AbstractParent doExtends ...");
    }


}