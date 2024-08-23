package com.emo.matrix.lms.service;

import com.emo.matrix.lms.models.Department;
import com.emo.matrix.lms.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // Method to create a new department
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Method to update an existing department
    public Department updateDepartment(Long departmentId, Department updatedDepartment) {
        Optional<Department> departmentOptional = departmentRepository.findById(departmentId);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setName(updatedDepartment.getName());
            // Update other fields as necessary
            return departmentRepository.save(department);
        } else {
            throw new RuntimeException("Department not found with id: " + departmentId);
        }
    }

    // Method to get all departments
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // Method to get a department by ID
    public Optional<Department> getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    // Method to delete a department by ID
    public void deleteDepartment(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }
}
