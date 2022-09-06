package org.aibles.validator.service;

import java.util.List;
import org.aibles.validator.dto.request.CreateUserRequest;
import org.aibles.validator.dto.request.UpdateUserRequest;
import org.aibles.validator.dto.response.UserResponse;


public interface UserService {

  UserResponse created(CreateUserRequest createUserRequest);

  List<UserResponse> list();

  UserResponse update(long id, UpdateUserRequest updateUser);
}
