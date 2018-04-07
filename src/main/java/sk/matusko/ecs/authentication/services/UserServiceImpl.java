package sk.matusko.ecs.authentication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sk.matusko.ecs.authentication.dao.User;
import sk.matusko.ecs.authentication.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;

    }

    @Override
    public User save(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Page<User> all(Pageable pageable) {
        return this.userRepository.findAll(pageable);
    }

    @Override
    public Page<User> filterByLastName(String lastName, Pageable pageable) {
        return this.userRepository.findByLastName(lastName, pageable);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return userRepository.findOneByUsername(username);
    }

}
