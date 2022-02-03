package edu.miu.cs.cs425.eregistrar.service.impl;

import edu.miu.cs.cs425.eregistrar.model.Registration;
import edu.miu.cs.cs425.eregistrar.repository.CourseRepository;
import edu.miu.cs.cs425.eregistrar.repository.RegistrationRepository;
import edu.miu.cs.cs425.eregistrar.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> getAllRegistration() {
        return registrationRepository.findAll();
    }

    @Override
    public Registration save(Registration registration) {
        return registrationRepository.save(registration);
    }

    @Override
    public Optional<Registration> findRegistrationById(Long id) {
        return registrationRepository.findById(id);
    }
}
