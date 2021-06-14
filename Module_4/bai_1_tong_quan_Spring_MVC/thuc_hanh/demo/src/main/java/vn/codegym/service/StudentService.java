package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;
@Service
public interface StudentService {
    List<Student> findAll();

    Student findById(int Id);


}
