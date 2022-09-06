package org.aibles.validator.controller;


import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.aibles.validator.dto.request.CreateUserRequest;
import org.aibles.validator.dto.request.UpdateUserRequest;
import org.aibles.validator.dto.response.UserResponse;
import org.aibles.validator.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/users")
@Slf4j
public class UserController {

  private final UserService service;

  @Autowired
  public UserController(UserService service) {
    this.service = service;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UserResponse created(@RequestBody @Valid CreateUserRequest createUserRequest) {
    return service.created(createUserRequest);
  }

  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<UserResponse> list() {
    return service.list();
  }

  @PutMapping("{id}")
  @ResponseStatus(HttpStatus.OK)
  public UserResponse update(@PathVariable("id") long id,
      @RequestBody @Valid UpdateUserRequest updateUser) {
    return service.update(id, updateUser);
  }
}
