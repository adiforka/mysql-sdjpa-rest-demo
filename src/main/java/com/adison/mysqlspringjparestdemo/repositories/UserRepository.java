package com.adison.mysqlspringjparestdemo.repositories;

import com.adison.mysqlspringjparestdemo.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
