package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.RegistrationRequest;
import edu.miu.cs.cs425.eregistrar.repository.CourseRepository;
import edu.miu.cs.cs425.eregistrar.repository.RegistrationRequestRepository;
import edu.miu.cs.cs425.eregistrar.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Override
    public List<RegistrationRequest> getAllRegistrationRequest() {
        return registrationRequestRepository.findAll();
    }

    @Override
    public RegistrationRequest save(RegistrationRequest registrationRequest) {
          return registrationRequestRepository.save(registrationRequest);
    }

    @Override
    public Optional<RegistrationRequest> findRegistrationRequestById(Long id) {
        return registrationRequestRepository.findById(id);
    }
}
