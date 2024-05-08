package DependencyInjectionPractice;

import org.springframework.stereotype.Component;

@Component
public class MongoDbDataService implements DataService{
    public int[] retrieveData(){
        return new int[]{22, 33, 44, 55, 66} ;
    }
}
