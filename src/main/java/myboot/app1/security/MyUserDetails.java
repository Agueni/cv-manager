package myboot.app1.security;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("simple")

public class MyUserDetails /*implements UserDetailsService */{
/*
	@Autowired
	private XUserRepository userRepository;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final var appUser = userRepository.findById(username);
		if (appUser.isEmpty()) {
			throw new UsernameNotFoundException("User '" + username + "' not found");
		}
		final var user = appUser.get();
		var authorites = new LinkedList<GrantedAuthority>();
		user.getRoles().forEach((role) -> {
			authorites.add(new SimpleGrantedAuthority(role));
		});
		return org.springframework.security.core.userdetails.User//
				.withUsername(username)//
				.password(user.getPassword())//
				.authorities(authorites)//
				.accountExpired(false)//
				.accountLocked(false)//
				.credentialsExpired(false)//
				.disabled(false)//
				.build();
	}
*/
}