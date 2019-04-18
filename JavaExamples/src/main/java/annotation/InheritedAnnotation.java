package annotation;


import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
//该类注解只能用于类上面

@Inherited
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)

public @interface InheritedAnnotation {

    String value();

}
