package net.app.Registration.Entity;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int user_id;
	private String username;
	private int age;
	private String gender;
	private String hobbies;
	private String password;
	
	
	public User(int user_id, String username, int age, String gender, String hobbies, String password) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.age = age;
		this.gender = gender;
		this.hobbies = hobbies;
		this.password = password;
	}


	public User() {
		super();
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getHobbies() {
		return hobbies;
	}


	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public User save(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
