package sk.matusko.ecs.authentication.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import sk.matusko.ecs.authentication.dao.User;

import javax.validation.Valid;

@Validated
public interface UserService {

    User save(@Valid User user);

    Page<User> all(Pageable pageable);

    Page<User> filterByLastName(String lastName, Pageable pageable);

}
