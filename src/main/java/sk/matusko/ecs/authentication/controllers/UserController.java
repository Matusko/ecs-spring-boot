package sk.matusko.ecs.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.matusko.ecs.authentication.dao.User;
import sk.matusko.ecs.authentication.services.UserService;

@RestController
@RequestMapping(value = "/user", produces = "application/json")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> save(@RequestBody User user) {
        return new ResponseEntity<>(this.userService.save(user), HttpStatus.OK);
    }

    @RequestMapping
    public ResponseEntity<Page<User>> all() {
        Pageable pageable = new QPageRequest(0,10);
        return new ResponseEntity<>(this.userService.all(pageable), HttpStatus.OK);
    }

    @RequestMapping(value = "/{lastName}")
    public ResponseEntity<Page<User>> filterByLastName(@PathVariable String lastName) {
        Pageable pageable = new QPageRequest(0,10);
        return new ResponseEntity<>(this.userService.filterByLastName(lastName, pageable), HttpStatus.OK);
    }

}
