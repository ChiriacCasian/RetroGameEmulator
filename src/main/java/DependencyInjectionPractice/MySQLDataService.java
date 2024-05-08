package DependencyInjectionPractice;

import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
@Component
public class MySQLDataService implements DataService {
    public int[] retrieveData(){
        return new int[]{22, 33, 44, 55, 66, 88} ;
    }
}
