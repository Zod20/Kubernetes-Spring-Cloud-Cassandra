package com.zod.userservice;

import com.zod.common.model.table.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.UUID;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User saveNewUser(String name){
    User user = new User();
    user.setName(name);
    return userRepository.save(user);
  }

  public User getUserById(String id) throws NoSuchElementException {
    return userRepository.findById(UUID.fromString(id)).orElseThrow();
  }


}
