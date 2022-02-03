package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.Registration;
import edu.miu.cs.cs425.eregistrar.model.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RegistrationService {
    public abstract List<Registration> getAllRegistration();
    public abstract Registration save(Registration registration);
    public abstract Optional<Registration> findRegistrationById(Long id);
}
