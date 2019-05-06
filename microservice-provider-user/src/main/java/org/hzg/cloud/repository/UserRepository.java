package org.hzg.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.hzg.cloud.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
