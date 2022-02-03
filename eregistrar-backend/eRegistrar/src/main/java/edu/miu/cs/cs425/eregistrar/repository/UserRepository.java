package edu.miu.cs.cs425.eregistrar.repository;

import edu.miu.cs.cs425.eregistrar.model.BlockCourse;
import edu.miu.cs.cs425.eregistrar.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u join u.roles r where r.title = ?1")
    List<User> findAllUserByRole(String userRole);

}
