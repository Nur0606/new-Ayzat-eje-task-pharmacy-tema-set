package Pharmacy.service.impl;

import Pharmacy.db.Database;
import Pharmacy.enums.Position;
import Pharmacy.model.Employee;
import Pharmacy.model.Pharmacy;
import Pharmacy.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class EmployeeServiceimpl implements EmployeeService {

    @Override
    public String saveEmployee(Employee employee) {
        Database.getEmploye.add(employee);
        return "Success Saved!✅";
    }

    @Override
    public String  assignEmployeeToPharmacy(Long pharmacyId, Long EmployeeId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)) {
                for (Employee employee :Database.getEmploye) {
                    if (employee.getId().equals(EmployeeId)) {
                        pharmacy.getEmployees().add(employee);
                        return "✅";
                    }
                }
            }
        }
        return "❌";
    }

    @Override
    public List<Employee> getAllEmployeeToPharmacyId(Long pharmacyId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)) {
                return pharmacy.getEmployees();
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }

    @Override
    public Employee getByIdEmployeeToPharmacyid(Long pharmacyId, Long employeeId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)) {
                for (Employee employee : pharmacy.getEmployees()) {
                    if (employee.getId().equals(employeeId)) {
                        return employee;
                    }
                }
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }

    @Override
    public String updateEmployeeToPharmacyid(Long pharmcyId, Long employeeId, Employee employee) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmcyId)) {
                for (Employee employee1 : pharmacy.getEmployees()) {
                    if (employee1.getId().equals(employeeId)) {
                        employee1.setFullName(employee.getFullName());
                        employee1.setEmail(employee.getEmail());
                        employee1.setGender(employee.getGender());
                        employee1.setPhoneNumber(employee.getPhoneNumber());
                        employee1.setExprirence(employee.getExprirence());
                        return "Success updates✅";
                    }
                }
            }
        }
        return "Not-Found!❌";
    }

    @Override
    public String deleteEmployeeToPharmacyid(Long employeeId, Long pharmacyId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)) {
                for (Employee employee : pharmacy.getEmployees()) {
                    if (employee.getId().equals(employeeId)) {
                        pharmacy.getEmployees().remove(employee);
                        return "Success Deleted!✅";
                    }
                }
            }
        }
        return "Not-Found!❌";
    }
    public List<Employee> filterEmployeeByPosition(String position) {
        List<Employee> admin = new ArrayList<>();
        List<Employee> pharmacist = new ArrayList<>();
        List<Employee> teller = new ArrayList<>();
        if (position.equalsIgnoreCase("ADMIN")){
            for (Employee employee : Database.getEmploye) {
                if (employee.getPosition().equals(Position.admin)){
                    admin.add(employee);
                }
            }
            return admin;
        }else if (position.equalsIgnoreCase("PHARMACIST")){
            for (Employee employee : Database.getEmploye) {
                if (employee.getPosition().equals(Position.phatmacist)){
                    pharmacist.add(employee);
                }
            }
            return pharmacist;
        } else if (position.equalsIgnoreCase("TELLER")) {
            for (Employee employee : Database.getEmploye) {
                if (employee.getPosition().equals(Position.teller)){
                    teller.add(employee);
                }
            }
            return teller;
        }
        System.err.println("Position Not-Found!");
        return null;
    }


}
