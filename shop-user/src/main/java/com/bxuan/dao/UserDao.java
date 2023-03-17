package com.bxuan.dao;

import com.bxuan.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: BXuan
 * @Date: 2023/03/17/ 21:38
 * @description
 */

@Repository
public interface UserDao extends JpaRepository<User, Integer> {
}
