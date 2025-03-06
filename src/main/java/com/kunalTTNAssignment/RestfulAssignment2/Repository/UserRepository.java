package com.kunalTTNAssignment.RestfulAssignment2.Repository;

import com.kunalTTNAssignment.RestfulAssignment2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
