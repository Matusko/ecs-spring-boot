package sk.matusko.ecs.authentication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import sk.matusko.ecs.authentication.dao.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    Page<User> findByLastName(String lastName, Pageable pageable);

}
