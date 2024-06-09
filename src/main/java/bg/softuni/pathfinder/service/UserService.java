package bg.softuni.pathfinder.service;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;

public interface UserService {
    public void register(UserRegisterDTO userRegisterDTO);

    void login(UserLoginDTO userLoginDTO);

    void logout();
}
