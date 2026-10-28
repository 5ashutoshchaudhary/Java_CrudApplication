
package com.example.data_transfer_object.repository;

import com.example.data_transfer_object.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   boolean existsByName(String name);
}
