package com.codegym.repository;

import com.codegym.model.Employee;
import com.codegym.model.GroupMembers;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Long> {
    Iterable<Employee> findAllByGroupMembers(GroupMembers groupMembers);
}
