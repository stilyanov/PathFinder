package bg.softuni.pathfinder.service.impl;

import bg.softuni.pathfinder.model.dto.UserLoginDTO;
import bg.softuni.pathfinder.model.dto.UserRegisterDTO;
import bg.softuni.pathfinder.model.entity.User;
import bg.softuni.pathfinder.repository.UserRepository;
import bg.softuni.pathfinder.service.CurrentUser;
import bg.softuni.pathfinder.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;
    }


    @Override
    public void register(UserRegisterDTO userRegisterDTO) {
        User user = this.modelMapper.map(userRegisterDTO, User.class);
        user.setPassword(this.passwordEncoder.encode(userRegisterDTO.getPassword()));

        this.userRepository.save(user);
    }

    @Override
    public void login(UserLoginDTO userLoginDTO) {
        User user = this.userRepository.findByUsername(userLoginDTO.getUsername());

        if (user == null) {
            // TODO
            throw new RuntimeException("Username not found!");
        }

        if (passwordEncoder.matches(userLoginDTO.getPassword(), user.getPassword()) && !currentUser.isLoggedIn()) {
            currentUser.setUser(user);
        }
    }

    @Override
    public void logout() {
        currentUser.setUser(null);
    }
}
