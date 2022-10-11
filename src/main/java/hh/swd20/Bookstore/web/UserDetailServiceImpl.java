package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.swd20.Bookstore.domain.User;
import hh.swd20.Bookstore.domain.UserRepository;

/**
 * Spring security uses this class to authenticate and authorize user
 **/

@Service
public class UserDetailServiceImpl implements UserDetailsService{
	private final UserRepository userRepo;
	
	@Autowired
	public UserDetailServiceImpl(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		User currentUser = userRepo.findByUsername(username);
		UserDetails user = new org.springframework.security.core.userdetails.User(username, 
				currentUser.getPasswordHash(),
				AuthorityUtils.createAuthorityList(currentUser.getRole()));
		return user;
	}
}
