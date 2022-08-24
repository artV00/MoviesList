package movies.service;

import movies.dto.AppUserDTO;
import movies.model.AppUser;

public interface AppUserService {
    AppUser createUser(AppUserDTO appUserDTO);
    AppUser findByUsername(String username);
}
