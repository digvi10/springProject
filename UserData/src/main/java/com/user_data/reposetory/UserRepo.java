package com.user_data.reposetory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_data.entity.Userdata;

public interface UserRepo extends JpaRepository<Userdata, Integer> {

	Userdata findByEmail(String email);

}
