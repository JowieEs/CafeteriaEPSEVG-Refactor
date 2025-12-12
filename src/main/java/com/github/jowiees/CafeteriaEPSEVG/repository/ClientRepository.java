package com.github.jowiees.CafeteriaEPSEVG.repository;

import com.github.jowiees.CafeteriaEPSEVG.entity.client.Client;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Professor;
import com.github.jowiees.CafeteriaEPSEVG.entity.client.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    @Query("SELECT p FROM Professor p")
    List<Professor> findAllProfessors();

    @Query("SELECT s FROM Student s")
    List<Student> findAllStudents();
}
