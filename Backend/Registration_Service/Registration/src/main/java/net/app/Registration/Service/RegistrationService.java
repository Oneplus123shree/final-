package net.app.Registration.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import net.app.Registration.Entity.User;
import net.app.Registration.Repository.RegistrationRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository registerRepo;
	

	public User saveUser(User user)
	{
		return registerRepo.save(user);
	}
	

	public User fetchUserByUsername(String username)
	{
		return registerRepo.findByUsername(username);
	}
	
	
	public User fetchUserByUsername(String username,String password)
	{
		return registerRepo.findByUsernameAndPassword(username, password);
	}
	
}
