package com.neshan.reportservice.repository;

import com.neshan.reportservice.model.dto.UserDto;
import com.neshan.reportservice.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query(value = """
            select first_name as firstName, title, type, ST_AsText(location) as location
            from users
            inner join reports
            on users.id = reports.user_id
            where users.id = :userId
            """, nativeQuery = true)
    UserDto findUserById(@Param("userId") long userId);
}
