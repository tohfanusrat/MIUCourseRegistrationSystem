package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest, Long> {
}
