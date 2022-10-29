package com.example.demo.restapi.user;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;


@Component
public class UserDaoService {
	
	//JPA/HIBERNATE > FOR DATABASE
	//FOR NOW userdaoservice using static list
	
	//public List<User> findAll()

	//public User save(User user)
	
	//public User findOne(int id)
	
	
	
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1, "Nitin", LocalDate.now().minusYears(25) ));
		users.add(new User(2, "Harry", LocalDate.now().minusYears(24) ));
		users.add(new User(3, "Prisha", LocalDate.now().minusYears(27) ));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User findOne(int id){
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		
		
		return users.stream().filter(predicate).findFirst().get();
	}
}
