package com.example.labsoap.service;

import com.example.labsoap.model.Provider;
import com.example.labsoap.model.User;
import com.example.labsoap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired private UserRepository repo;

  public void processOAuthPostLogin(String username) {
    User existUser = repo.getUserByUsername(username);

    if (existUser == null) {
      User newUser = new User();
      newUser.setUsername(username);
      newUser.setProvider(Provider.GOOGLE);
      newUser.setEnabled(true);

      repo.save(newUser);
    }
  }
}
