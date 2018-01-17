package com.junli.springclouddemo;

import com.junli.dto.User;
import com.junli.service.HelloServce;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lijun
 * @time 2018-01-16 17:33
 */
@RestController
public class RefactorController implements HelloServce {

    @Override
    public String hello(@RequestParam("name") String name) {
        return "Hello "+name;
    }

    @Override
    public User hello(@RequestHeader("name") String name, @RequestHeader("age") Integer age) {
          return new User(name,age);
    }

    @Override
    public String hello(@RequestBody User user) {
        return "Hello  " + user.getName() + "," + user.getAge();
    }
}
