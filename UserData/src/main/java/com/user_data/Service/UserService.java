package com.user_data.Service;


import org.springframework.web.multipart.MultipartFile;

import com.user_data.entity.Userdata;

public interface UserService {

	boolean verify(String email, String password);


	void save(MultipartFile multipartFile, String name, String email, String phone, String password);

	Userdata show(String email);

}
