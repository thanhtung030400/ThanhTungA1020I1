package vn.codegym.repository;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;
@Service
public interface StudentRepository {
    List<Student> findAll();
}
