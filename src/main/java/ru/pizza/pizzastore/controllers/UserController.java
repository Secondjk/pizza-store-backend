package ru.pizza.pizzastore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ru.pizza.pizzastore.models.User;
import ru.pizza.pizzastore.payloads.request.UserRequest;
import ru.pizza.pizzastore.payloads.response.UserResponse;
import ru.pizza.pizzastore.repositories.UserRepository;
import ru.pizza.pizzastore.security.services.UserDetailsImpl;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getTutorialById(@PathVariable("id") long id) {
        Optional<User> userData = userRepository.findById(id);

        return userData.isPresent()
                ? ResponseEntity.ok(new UserResponse(
                        userData.get().getFirstName(),
                        userData.get().getLastName(),
                        userData.get().getEmail(),
                        userData.get().getCity(),
                        userData.get().getDeliveryAddress(),
                        userData.get().getEntrance(),
                        userData.get().getFloor(),
                        userData.get().getIntercom(),
                        userData.get().getTel()))
                : ResponseEntity.ok(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return ResponseEntity.ok(new UserResponse(
                        userDetails.getFirstName(),
                        userDetails.getLastName(),
                        userDetails.getEmail(),
                        userDetails.getCity(),
                        userDetails.getDeliveryAddress(),
                        userDetails.getEntrance(),
                        userDetails.getFloor(),
                        userDetails.getIntercom(),
                        userDetails.getTel()));
    }

    @PutMapping("/user")
    public ResponseEntity<UserResponse> updateCurrentUser(@Valid @RequestBody UserRequest userRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        Optional<User> userData = userRepository.findById(userDetails.getId());

        if (userData.isPresent()) {
            User _user = userData.get();
            _user.setFirstName(userRequest.getFirstName());
            _user.setEmail(userRequest.getEmail());
            _user.setDeliveryAddress(userRequest.getDeliveryAddress());
            _user.setCity(userRequest.getCity());
            _user.setFloor(userRequest.getFloor());
            _user.setEntrance(userRequest.getEntrance());
            _user.setIntercom(userRequest.getIntercom());
            _user.setLastName(userRequest.getLastName());
            _user.setTel(userRequest.getTel());
            userRepository.save(_user);
            return new ResponseEntity<>(new UserResponse(
                    userRequest.getFirstName(),
                    userRequest.getLastName(),
                    userRequest.getEmail(),
                    userRequest.getCity(),
                    userRequest.getDeliveryAddress(),
                    userRequest.getEntrance(),
                    userRequest.getFloor(),
                    userRequest.getIntercom(),
                    userRequest.getTel()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
