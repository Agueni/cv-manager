package myboot.app1.security;


import myboot.app1.dao.PersonRepository;
import myboot.app1.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;


@Service
@Profile("usejwt")
public class UserService {

	@Autowired
	private PersonRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtProvider jwtTokenProvider;

	@Autowired
	private AuthenticationManager authenticationManager;

	public String login(String mail, String password) {
		System.out.println("toto");
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(mail, password));
			var user = userRepository.findByEmail(mail);

			return jwtTokenProvider.createToken(user);
		} catch (AuthenticationException e) {
			throw new MyJwtException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public String signup(Person user) {

		if (!userRepository.existsByEmail(user.getEmail())) {
			System.out.println(user.getPassword());
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			userRepository.save(user);
			return jwtTokenProvider.createToken(user);
		}else {
			throw new MyJwtException("email is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	public void delete(String email) {
		userRepository.deleteByEmail(email);
	}

	public Person search(String email) {
		return userRepository.findByEmail(email);

	}

	public Person whoami(HttpServletRequest req) {
		return search(jwtTokenProvider.getUsername(jwtTokenProvider.resolveToken(req)));
	}

	public String refresh(String email) {
		return jwtTokenProvider.createToken(userRepository.findByEmail(email));
	}



	public String logout(HttpServletRequest req) {
		String token = jwtTokenProvider.resolveToken(req);

		if( jwtTokenProvider.validateToken(token) ) {
			jwtTokenProvider.forgetToken(token);
			return token;
		}

		return null;
	}

}
