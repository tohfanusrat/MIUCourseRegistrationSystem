package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.RegistrationRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RegistrationRequestService {
    public abstract List<RegistrationRequest> getAllRegistrationRequest();
    public abstract RegistrationRequest save(RegistrationRequest registrationRequest);
    public abstract Optional<RegistrationRequest> findRegistrationRequestById(Long id);
}
