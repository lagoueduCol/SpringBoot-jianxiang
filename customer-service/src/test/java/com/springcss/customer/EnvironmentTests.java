package com.springcss.customer;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(properties = {" springcss.order.point = 10"})
public class EnvironmentTests{
 
    @Autowired
    public Environment environment;        
 
    @Test
    public void testEnvValue(){
        Assert.assertEquals(10, Integer.parseInt(environment.getProperty("springcss.order.point"))); 
    }    
}
