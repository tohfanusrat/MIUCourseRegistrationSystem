package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.User;
import edu.miu.cs.cs425.eregistrar.repository.UserRepository;
import edu.miu.cs.cs425.eregistrar.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAllUserByRole(String userRole) {
        return userRepository.findAllUserByRole(userRole);
    }
}
