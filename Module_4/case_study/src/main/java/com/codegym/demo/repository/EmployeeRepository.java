package com.codegym.demo.repository;


import com.codegym.demo.model.Division;
import com.codegym.demo.model.EducationDegree;
import com.codegym.demo.model.Employee;
import com.codegym.demo.model.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Iterable<Employee> findAllByDivision(Division division);
    Iterable<Employee> findAllByPosition(Position position);
    Iterable<Employee> findAllByEducationDegree(EducationDegree educationDegree);

    @Query("select e from Employee e where e.employeeName like %?1%" +
            " or e.employeeIdCard like %?1%" +
            " or e.position.positionName like %?1%" +
            " or e.division.divisionName like %?1%" +
            " or e.educationDegree.educationDegreeName like %?1%")
    Page<Employee> search(String keyword, Pageable pageable);
}
