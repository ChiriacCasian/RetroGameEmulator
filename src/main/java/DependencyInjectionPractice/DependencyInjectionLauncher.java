package DepInjection;

import DependencyInjectionPractice.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.lang.reflect.Array;
import java.util.Arrays;

@Configuration
@ComponentScan /// automatically does compScan in the same package this class is in
public class DependencyInjectionLauncher {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(DependencyInjectionLauncher.class) ;
        System.out.println(context.getBean(YourBusinessClass.class)) ;
    }
}
@Component
class YourBusinessClass{
    //@Autowired
    Dependency1 dependency1 ;
    //@Autowired
    Dependency2 dependency2 ;
    //    @Autowired
//    public void setDependency1(Dependency1 dependency1) {
//        this.dependency1 = dependency1;
//    }
//    @Autowired
//    public void setDependency2(Dependency2 dependency2) {
//        this.dependency2 = dependency2;
//    }
    public YourBusinessClass(Dependency1 dependency1, Dependency2 dependency2){
        this.dependency1 = dependency1 ;
        this.dependency2 = dependency2 ;
    }
    public String toString(){
        return dependency1 + " AND " + dependency2 + '\n' ;
    }
}
@Component
class Dependency1{
}
@Component
class Dependency2{
}
@Component
class BusinessCalculationService{
    DataService dataService ;
    public BusinessCalculationService(DataService dataService){
        this.dataService = dataService ;
    }
    public int max(){
        return Arrays.stream(dataService.retrieveData()).max().orElse(0) ;
    }
}