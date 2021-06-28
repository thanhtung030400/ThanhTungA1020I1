package vn.codegym.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Student;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager.createQuery("SELECT s FROM Student as s", Student.class);
        return query.getResultList();
    }

    @Override
    public Student finById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public void update(Student student){
        entityManager.merge(student);
    }

    @Override
    public void remove(Student student){
        int id = student.getId();
        entityManager.remove(student);
    }

    @Override

    public List<Student> searchByName(String kq) {
        TypedQuery<Student> query =
                entityManager.createQuery("SELECT d FROM Student  as d where  d.name like :keyword", Student.class);
        query.setParameter("keyword", kq + "%");
        return  query.getResultList();    }


}
