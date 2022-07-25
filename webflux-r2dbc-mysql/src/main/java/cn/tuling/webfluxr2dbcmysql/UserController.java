package cn.tuling.webfluxr2dbcmysql;

import cn.tuling.webfluxr2dbcmysql.entity.User;
import cn.tuling.webfluxr2dbcmysql.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/save")
    public Mono<User> saveUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/user/delete")
    public Mono<Void> deleteUser(Integer userId) {
        return userService.deleteUser(userId);
    }

    @PostMapping("/user/update")
    public Mono<User> updateUser(@RequestBody User user){

        return userService.updateUser(user);
    }

    @GetMapping("/user/get")
    public Mono<User> getUser(Integer userId){
        return userService.getUserById(userId).defaultIfEmpty(User.builder().build());
    }



}
