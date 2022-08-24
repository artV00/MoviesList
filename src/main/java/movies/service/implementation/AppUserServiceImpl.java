package movies.service.implementation;

import movies.dto.AppUserDTO;
import movies.model.AppUser;
import movies.repository.AppUserRepository;
import movies.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AppUser createUser(AppUserDTO appUserDTO) {
        AppUser appUserUpdate = new AppUser();
        appUserUpdate.setFirstName(appUserDTO.getFirstName());
        appUserUpdate.setLastName(appUserDTO.getLastName());
        appUserUpdate.setEmail(appUserDTO.getEmail());
        appUserUpdate.setUsername(appUserDTO.getUsername());
        appUserUpdate.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));

        return appUserRepository.save(appUserUpdate);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}
