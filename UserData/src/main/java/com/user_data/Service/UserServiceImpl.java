package com.user_data.Service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.user_data.entity.Userdata;
import com.user_data.reposetory.UserRepo;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo ur;
	@Override
	public boolean verify(String email, String password) 
	{
		Userdata user = ur.findByEmail(email);
		if(user!=null) {
		if(user.getEmail().equals(email)&&user.getPassword().equals(password))
		{
			return true;
		}
		}
		return false;

	}

	@Override
	public void save(MultipartFile multipartFile, String name, String email, String phone, String password) {
		//System.out.println(multipartFile);
		Userdata user=new Userdata();
		user.setName(name);
		user.setEmail(email);
		user.setPhone(phone);
		user.setPassword(password);
	
			try {
			user.setImage(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
			//System.out.println(user.getImage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ur.save(user);
	}
	@Override
	public Userdata show(String email) {

		return ur.findByEmail(email);
	}

}
