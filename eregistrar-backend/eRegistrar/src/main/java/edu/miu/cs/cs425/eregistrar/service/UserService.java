package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    public abstract List<User> getAllUser();
    public abstract void save(User user);
    public abstract Optional<User> getUserById(Long id);
    public abstract List<User> getAllUserByRole(String userRole);
}
