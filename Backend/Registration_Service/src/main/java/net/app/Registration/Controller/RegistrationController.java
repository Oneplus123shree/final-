package net.app.Registration.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import net.app.Registration.Entity.User;
import net.app.Registration.Service.RegistrationService;

@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registerService;
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/registerUser")
	public User registereUser(@RequestBody User user) throws Exception
	{
		String userName=user.getUsername();
		if(userName!=null && !"".equals(userName))
		{
			User userobj=registerService.fetchUserByUsername(userName);
			if(userobj!=null)
			{
				throw new Exception("Username already exist");
			}
		}
		
		User userObj=null;
		userObj= registerService.saveUser(user);
		return userObj;
	}
	
	@CrossOrigin(origins="http://localhost:4200")
	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception
	{
		String username=user.getUsername();
		String password=user.getPassword();
		User userObj=null;
		if(username!=null&& password!=null)
		{
			userObj=registerService.fetchUserByUsername(username, password);
		}
		
		if(userObj==null)
		{
			throw new Exception("Bad credentials");
		}
		return userObj;
		
	}

}
