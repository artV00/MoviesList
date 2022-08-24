package movies.service.implementation;

import movies.model.AppUser;
import movies.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {
    private final AppUserService appUserService;

    @Autowired
    public AppUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        AppUser applicationUser = appUserService.findByUsername(username);
        if (applicationUser == null) {
            throw new UsernameNotFoundException("User with username " + username + " does not exists");
        }

        return User.withUsername(username).password(applicationUser.getPassword()).roles("USER").disabled(false).build();

    }
}
