package cn.tuling.webfluxstart.annotated;

import cn.tuling.webfluxstart.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/annotated")
public class AnnotatedController {

    @ExceptionHandler
    public ResponseEntity<String> handle(RuntimeException ex) {
        // ...
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("error");
    }
    @GetMapping("/user/get")
    public User getUser(){

        return User.builder().build();
    }



}
