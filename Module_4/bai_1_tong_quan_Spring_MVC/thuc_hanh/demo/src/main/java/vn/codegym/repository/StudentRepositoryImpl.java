package vn.codegym.repository;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.ArrayList;
import java.util.List;
@Service
public class StudentRepositoryImpl implements StudentRepository {
   private static List<Student> studentList;

   static {
       studentList = new ArrayList<>();
       studentList.add(new Student(1,"Nguyen Van A"));
       studentList.add(new Student(2,"Nguyen Van B"));
       studentList.add(new Student(3,"Nguyen Van B"));
   }


    @Override
    public List<Student> findAll() {
        return studentList;
    }
}
