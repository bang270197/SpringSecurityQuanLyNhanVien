package com.codegym.service;

import com.codegym.model.Employee;
import com.codegym.model.GroupMembers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployService {
    Page<Employee> showAll(Pageable pageable);

    Employee findById(Long id);

    void save(Employee employee);

    void delete(Long id);

    Iterable<Employee> findAllByGroupMembers(GroupMembers groupMembers);
}
