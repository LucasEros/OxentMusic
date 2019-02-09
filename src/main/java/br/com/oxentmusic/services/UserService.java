package br.com.oxentmusic.services;

import org.springframework.security.core.context.SecurityContextHolder;

import br.com.oxentmusic.seguranca.UserSecutiry;

public class UserService {
	
	public static UserSecutiry authenticated() {
		try {
			return (UserSecutiry) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
