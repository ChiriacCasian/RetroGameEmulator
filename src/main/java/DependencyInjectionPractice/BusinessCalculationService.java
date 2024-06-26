package DependencyInjectionPractice;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BusinessCalculationService {
    DataService dataService;
    public BusinessCalculationService(DataService dataService) {
        this.dataService = dataService;
    }

    public int max() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
