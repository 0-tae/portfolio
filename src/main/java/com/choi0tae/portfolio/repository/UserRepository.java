package com.choi0tae.portfolio.repository;

import com.choi0tae.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;


@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Optional<User> findUserByUserStringIdAndDeletedAtIsNull(String id);

    default Optional<User> findByUserStringId(String id){
        return findUserByUserStringIdAndDeletedAtIsNull(id);
    }
}
