package com.gameTutorial.gameApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class CurrencyConfigController {
    @Autowired
    CurrencyServiceConfig currencyServiceConfig ;
    @RequestMapping("/currency-config")
    public List<CurrencyServiceConfig> getAllCourses(){
        return Arrays.asList(
                currencyServiceConfig
        ) ;
    }
}
