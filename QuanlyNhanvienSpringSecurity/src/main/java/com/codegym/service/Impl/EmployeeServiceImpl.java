package com.codegym.service.Impl;

import com.codegym.model.Employee;
import com.codegym.model.GroupMembers;
import com.codegym.repository.EmployeeRepository;
import com.codegym.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class EmployeeServiceImpl implements EmployService {
    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Page<Employee> showAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public void save(Employee employee) {
employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
   employeeRepository.delete(id);
    }

    @Override
    public Iterable<Employee> findAllByGroupMembers(GroupMembers groupMembers) {
        return employeeRepository.findAllByGroupMembers(groupMembers);
    }
}
