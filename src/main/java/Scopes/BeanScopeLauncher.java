package Scopes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan
public class BeanScopeLauncher {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(BeanScopeLauncher.class) ;
        System.out.println(context.getBean(NormalBean.class)) ;
        System.out.println(context.getBean(NormalBean.class)) ;

        System.out.println(context.getBean(PrototypeBean.class)) ;
        System.out.println(context.getBean(PrototypeBean.class)) ;
        System.out.println(context.getBean(PrototypeBean.class)) ;
    }
}
@Component
class NormalBean{

}

@Component
@Scope("singleton")
class PrototypeBean{

}