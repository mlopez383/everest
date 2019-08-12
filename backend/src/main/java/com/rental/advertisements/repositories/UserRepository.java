package com.rental.advertisements;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByEmailAndUpassword(String email, String upassword);
}