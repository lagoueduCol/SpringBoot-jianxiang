package com.springcss.account.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SpringCssUserDetailsService implements UserDetailsService {

	@Autowired
	private SpringCssUserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SpringCssUser user = repository.findByUsername(username);
		if (user != null) {
			return user;
		}
		throw new UsernameNotFoundException("SpringCSS User '" + username + "' not found");
	}
}
