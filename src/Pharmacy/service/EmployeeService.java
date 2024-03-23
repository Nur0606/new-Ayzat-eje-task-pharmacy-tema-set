package Pharmacy.service;

import Pharmacy.model.Employee;
import Pharmacy.model.Medicine;

import java.util.List;

public interface EmployeeService {
    String saveEmployee(Employee employee);
    String  assignEmployeeToPharmacy(Long pharmacyId, Long EmployeeId);
    List<Employee> getAllEmployeeToPharmacyId(Long pharmacyId);

    Employee getByIdEmployeeToPharmacyid(Long pharmacyId, Long employeeId);

    String  updateEmployeeToPharmacyid(Long pharmacyId,Long employeeId, Employee newemployee);

    String   deleteEmployeeToPharmacyid(Long employeeId, Long pharmacyId);
    public List<Employee> filterEmployeeByPosition(String position);
}
