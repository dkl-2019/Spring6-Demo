package com.kunling.spring6.junit.junit5;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@ExtendWith(SpringExtension.class

)
@ContextConfiguration()
//@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestJunit5 {

    @Autowired  // 注入
    private User user;

    @Test
    public void testUser() {
        System.out.println(user);
        user.run();
    }

}
