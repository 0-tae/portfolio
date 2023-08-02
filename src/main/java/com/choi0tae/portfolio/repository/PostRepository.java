package com.choi0tae.portfolio.repository;

import com.choi0tae.portfolio.entity.Post;
import com.choi0tae.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

    /* Find All posts */
    List<Post> findAllByUserAndDeletedAtIsNull(User user);

    /* Find VISIBLE posts, This method is required for guest-visit or locked posts */
    List<Post> findAllByUserAndVisibleIsTrueAndDeletedAtIsNull(User user);

    default List<Post> findAllByUser(User user){
        return this.findAllByUserAndDeletedAtIsNull(user);
    }
}
