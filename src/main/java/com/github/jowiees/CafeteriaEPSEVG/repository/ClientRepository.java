package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT p FROM Professor p")
    Page<Professor> findAllProfessors(Pageable pageable);

    @Query("SELECT s FROM Student s")
    Page<Student> findAllStudents(Pageable pageable);
}
