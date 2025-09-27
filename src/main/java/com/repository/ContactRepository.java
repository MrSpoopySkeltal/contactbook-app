package com.repository;
import com.model.Contact;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	void deleteById(Integer id);

	Optional<Contact> findById(Integer id);
}
