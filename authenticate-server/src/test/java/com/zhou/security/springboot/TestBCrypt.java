package com.zhou.security.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Administrator
 * @version 1.0
 **/
@RunWith(SpringRunner.class)
public class TestBCrypt {

    @Test
    public void testBCrypt() {

        System.out.println(new BCryptPasswordEncoder().encode("secret"));
        //对密码进行加密
//        String hashpw = BCrypt.hashpw("123", BCrypt.gensalt());
//        System.out.println(hashpw);
//
//        boolean checkpw2 = BCrypt.checkpw("123", "$2a$10$HuClcUqr/FSLmzSsp9SHqe7D51Keu1sAL7tUAAcb..FyILiLdFKYy");
//        System.out.println(checkpw2);
    }
}
