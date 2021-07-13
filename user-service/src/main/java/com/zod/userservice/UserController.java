package com.zod.userservice;

import com.zod.common.model.table.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/{name}")
  public ResponseEntity<User> saveUser(@PathVariable String name){
    log.info("Inside user controller");
    return new ResponseEntity<>(userService.saveNewUser(name), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable String id){
    return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
  }

}
