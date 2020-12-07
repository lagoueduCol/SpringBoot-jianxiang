package com.springcss.account.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SpringCssUser implements UserDetails {

	private static final long serialVersionUID = 1L;
	private Long id;
	private final String username;
	private final String password;
	private final String phoneNumber;

	public Long getId() {
		return id;
	}

	public SpringCssUser(Long id, String username, String password, String phoneNumber) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String getUsername() {
		return username;
	}
	
	@Override
	public String getPassword() {
		return password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
