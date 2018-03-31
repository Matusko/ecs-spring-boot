package sk.matusko.ecs.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import sk.matusko.ecs.authentication.dao.User;
import sk.matusko.ecs.authentication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;

    }

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    public Page<User> all(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    public Page<User> filterByLastName(String lastName, Pageable pageable) {
        return this.repository.findByLastName(lastName, pageable);
    }

}
