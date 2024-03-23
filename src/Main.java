import Pharmacy.db.Database;
import Pharmacy.enums.Gender;
import Pharmacy.enums.Position;
import Pharmacy.genericId.GenericId;
import Pharmacy.model.Employee;
import Pharmacy.model.Medicine;
import Pharmacy.model.Pharmacy;
import Pharmacy.service.EmployeeService;
import Pharmacy.service.MedicineService;
import Pharmacy.service.PharmacyService;
import Pharmacy.service.impl.EmployeeServiceimpl;
import Pharmacy.service.impl.MedicineServiceImpl;
import Pharmacy.service.impl.PharmacyServiceImpl;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Employee> employees = new ArrayList<>(Arrays.asList(
                new Employee(GenericId.genericEmployeId(), "Nurmuhammed", "nur@gmail.com", "+996220180752", 10.10, Position.admin, Gender.male),
                new Employee(GenericId.genericEmployeId(), "Nurtilek", "nurti@gmail.com", "+996868622", 6.9, Position.phatmacist, Gender.male),
                new Employee(GenericId.genericEmployeId(), "Adyl", "adyl@gmail.com", "+996220640751", 3.6, Position.phatmacist, Gender.female),
                new Employee(GenericId.genericEmployeId(), "Abu", "abu@gmail.com", "+996229087757", 8.3, Position.teller, Gender.male),
                new Employee(GenericId.genericEmployeId(), "Lolo", "lolo@gmail.com", "+996229870759", 2, Position.teller, Gender.female)
        ));
        List<Medicine> medicines = new ArrayList<>(Arrays.asList(
                new Medicine(GenericId.genericMedicineId(), "parastamol", 20, 10, "opasnyi", LocalDate.of(2020, 1, 1), LocalDate.of(2026, 12, 31)),
                new Medicine(GenericId.genericMedicineId(), "sitramol", 50, 5, "haha", LocalDate.of(2010, 1, 1), LocalDate.of(2030, 12, 31)),
                new Medicine(GenericId.genericMedicineId(), "trimol", 25, 2, "yad", LocalDate.of(202015, 1, 1), LocalDate.of(2039, 12, 31)),
                new Medicine(GenericId.genericMedicineId(), "tailonhod", 45, 1, "groznyi", LocalDate.of(2022, 1, 1), LocalDate.of(2025, 12, 31)),
                new Medicine(GenericId.genericMedicineId(), "ysyk chay!", 2000, 100, "dary", LocalDate.of(2024, 1, 1), LocalDate.of(2027, 12, 31))
        ));
        List<Pharmacy> pharmacies = new ArrayList<>(Arrays.asList(
                new Pharmacy(GenericId.genericPharmacyId(), "Apteka", "vostok 5", employees, medicines),
                new Pharmacy(GenericId.genericPharmacyId(), "Neman", "dordoy", employees, medicines),
                new Pharmacy(GenericId.genericPharmacyId(), "Doktor ay bolit", "bishkek", employees, medicines),
                new Pharmacy(GenericId.genericPharmacyId(), "daary kana", "ay", employees, medicines),
                new Pharmacy(GenericId.genericPharmacyId(), "vrach", "shaar", employees, medicines)
        ));
        Database.getPharmacy.addAll(pharmacies);
        Database.getEmploye.addAll(employees);

        EmployeeService employeeService = new EmployeeServiceimpl();
        MedicineService medicineService = new MedicineServiceImpl();
        PharmacyService pharmacyService = new PharmacyServiceImpl();
        System.out.println("  Welcome! ");
        while (true) {
            System.out.println("""
                    1.Employee
                    2.Medicine
                    3.Pharmacy
                    4.Stop
                    """);
            switch (scanner.nextInt()) {
                case 1:
                    boolean Employeewhile = true;
                    while (Employeewhile) {
                        System.out.println("""
                                1.Add Employee
                                2.Assign Employee To Pharmacy Id
                                3.Get All Employee to Pharmacy Id
                                4.Update Employee To Pharmacy Id
                                5.Delete Employee To Pharmacy Id
                                6.Filter Position(admin/phatmacist/teller);
                                7.Exit
                                
                                    """);
                        switch (scanner.nextInt()) {
                            case 1 -> {
                                Employee employee = new Employee();
                                employee.setId(GenericId.genericEmployeId());
                                System.out.println("Enter Employee Full Name: ");
                                String name = scanner.next();
                                employee.setFullName(name);
                                System.out.println("Enter Employee E-mail: ");
                                String email = scanner.next();
                                employee.setEmail(email);
                                System.out.println("Enter Employee Phone Number: ");
                                String ph = scanner.next();
                                employee.setPhoneNumber(ph);
                                System.out.println("Enter Employee Exprirence: ");
                                double ex = scanner.nextDouble();
                                employee.setExprirence(ex);
                                System.out.println("Enter Employee Position:(admin,phatmacist,teller)");
                                Position position = Position.valueOf(scanner.next());
                                employee.setPosition(position);
                                System.out.println("Enter Employee Gender:(male/female)");
                                Gender gn = Gender.valueOf(scanner.next());
                                employee.setGender(gn);
                                System.out.println(employeeService.saveEmployee(employee));
                            }
                            case 2 -> {
                                System.out.println("Enter Pharmacy id: ");
                                Long phid = scanner.nextLong();
                                System.out.println("Enter Employee id: ");
                                Long emid = scanner.nextLong();
                                System.out.println(employeeService.assignEmployeeToPharmacy(phid, emid));
                            }
                            case 3 -> {
                                System.out.println("Enter Pharmacy id: ");
                                Long id = scanner.nextLong();
                                System.out.println(employeeService.getAllEmployeeToPharmacyId(id));
                            }
                            case 4 -> {
                                Employee employee = new Employee();
                                System.out.println("Enter Pharmacy Id: ");
                                Long phid = scanner.nextLong();
                                System.out.println("Enter Employee Id: ");
                                Long emid = scanner.nextLong();
                                System.out.println("Enter Employee new Name: ");
                                String name = scanner.next();
                                employee.setFullName(name);
                                System.out.println("Enter Employee new E-mail: ");
                                String email = scanner.next();
                                employee.setEmail(email);
                                System.out.println("Enter Employee new Phone Number: ");
                                String ph = scanner.next();
                                employee.setPhoneNumber(ph);
                                System.out.println("Enter Employee new experence: ");
                                double ex = scanner.nextDouble();
                                employee.setExprirence(ex);
                                System.out.println("Enter Employee new Position:(admin,phatmacist,teller)");
                                Position position = Position.valueOf(scanner.next());
                                employee.setPosition(position);
                                System.out.println("Enter Employee new Gender:(male/female)");
                                Gender gender = Gender.valueOf(scanner.next());
                                employee.setGender(gender);
                                System.out.println(employeeService.updateEmployeeToPharmacyid(phid, emid, employee));
                            }
                            case 5 -> {
                                System.out.println("Enter Pharmacy Id: ");
                                Long phid = scanner.nextLong();
                                System.out.println("Enter Employee Id to delete: ");
                                Long emid = scanner.nextLong();
                                System.out.println(employeeService.deleteEmployeeToPharmacyid(emid, phid));
                            }
                            case 6->{
                                System.out.println("Enter Employee Filter Position(admin/phatmacist/teller)");
                                String position =scanner.next();
                                System.out.println(employeeService.filterEmployeeByPosition(position));
                            }
                            case 7 -> Employeewhile = false;
                            default -> System.out.println("Родной мындай сан жок!");
                        }
                    }
                    break;
                case 2:
                    boolean twoCaseWhile = true;
                    while (twoCaseWhile){
                        System.out.println("""
                             1.Add Medicine To Pharmacy Id
                             2.Get All Medicine To Pharmacy Id
                             3.Get Medicine To Pharmacy Id
                             4.Update Medicine To Pharmacy Id
                             5.Delete Medicine To Pharmacy Id
                             6.Sort Medicine By Price (asc or desc)
                             7.Sort Medicine By Delivery Date (asc or desc)
                             8.Sort Medicine By Expiration Date (asc or desc)
                             9.Exit
                                """);
                        switch (scanner.nextInt()){
                            case 1->{
                                Medicine medicine = new Medicine();
                                System.out.println("Enter Pharmacy Id: ");
                                Long id = scanner.nextLong();
                                medicine.setId(GenericId.genericMedicineId());
                                System.out.println("Enter Medicine Name: ");
                                String name = scanner.next();
                                medicine.setName(name);
                                System.out.println("Enter Medicine price: ");
                                int price = scanner.nextInt();
                                medicine.setPrice(price);
                                System.out.println("Enter Medicine quantity: ");
                                int q = scanner.nextInt();
                                medicine.setQuantity(q);
                                System.out.println("Enter Medicine Description: ");
                                String dec = scanner.next();
                                medicine.setDescriotion(dec);
                                System.out.println("Medicine Date Of Delivery:");
                                System.out.println("Enter year: ");
                                int year = scanner.nextInt();
                                System.out.println("Enter month: ");
                                int month = scanner.nextInt();
                                System.out.println("Enter day: ");
                                int day = scanner.nextInt();
                                medicine.setDateOfDelivery(LocalDate.of(year,month,day));
                                System.out.println("Medicine Expration Date:");
                                System.out.println("Enter year: ");
                                int year1 = scanner.nextInt();
                                System.out.println("Enter month: ");
                                int month1 = scanner.nextInt();
                                System.out.println("Enter day: ");
                                int day1 = scanner.nextInt();
                                medicine.setExprationDate(LocalDate.of(year1,month1,day1));
                                System.out.println(medicineService.addMedicineToPharmasyById(id, medicine));
                            }
                            case 2->{
                                System.out.println("Enter Pharmacy Id: ");
                                Long id = scanner.nextLong();
                                System.out.println(medicineService.getAllMedicineByPharmacyId(id));
                            }
                            case 3->{
                                System.out.println("Enter Pharmacy Id: ");
                                Long id = scanner.nextLong();
                                System.out.println("Enter Medicine Id: ");
                                Long mId = scanner.nextLong();
                                System.out.println(medicineService.getMedicineByIdToPharmacyId(id, mId));
                            }
                            case 4->{
                                Medicine medicine = new Medicine();
                                System.out.println("Enter Pharmacy Id: ");
                                Long id = scanner.nextLong();
                                System.out.println("Enter Medicine Id: ");
                                Long mId = scanner.nextLong();
                                System.out.println("Enter Medicine new Name: ");
                                String name = scanner.next();
                                medicine.setName(name);
                                System.out.println("Enter Medicine new price: ");
                                int price = scanner.nextInt();
                                medicine.setPrice(price);
                                System.out.println("Enter Medicine new quantity: ");
                                int q = scanner.nextInt();
                                medicine.setQuantity(q);
                                System.out.println("Enter Medicine new Description: ");
                                String dec = scanner.next();
                                medicine.setDescriotion(dec);
                                System.out.println("Medicine new Date Of Delivery:");
                                System.out.println("Enter new year: ");
                                int year = scanner.nextInt();
                                System.out.println("Enter new month: ");
                                int month = scanner.nextInt();
                                System.out.println("Enter new day: ");
                                int day = scanner.nextInt();
                                medicine.setDateOfDelivery(LocalDate.of(year,month,day));
                                System.out.println("Medicine new Expration Date:");
                                System.out.println("Enter new year: ");
                                int year1 = scanner.nextInt();
                                System.out.println("Enter new month: ");
                                int month1 = scanner.nextInt();
                                System.out.println("Enter new day: ");
                                int day1 = scanner.nextInt();
                                medicine.setExprationDate(LocalDate.of(year1,month1,day1));
                                System.out.println(medicineService.updateMedicineToPharmacyId(id, mId, medicine));
                            }
                            case 5->{
                                System.out.println("Enter Pharmacy Id: ");
                                Long id = scanner.nextLong();
                                System.out.println("Enter Medicine Id: ");
                                Long mId = scanner.nextLong();
                                System.out.println(medicineService.deleteMedicineByIdToPharmacyId(id, mId));
                            }
                            case 6->{
                                System.out.println("Enter Medicine Sort By Price:(ascOrdesc)");
                                String s = scanner.next();
                                System.out.println(medicineService.sortByPrice(s));
                            }
                            case 7->{
                                System.out.println("Enter Medicine Sort By Delivery Date:(asc or desc)");
                                String s = scanner.next();
                                System.out.println(medicineService.ortByDeliveryDate(s));
                            }
                            case 8->{
                                System.out.println("Enter Medicine Sort ByExpiration Date:(asc or desc)");
                                String s = scanner.next();
                                System.out.println(medicineService.ortByDeliveryDate(s));
                            }
                            case 9-> twoCaseWhile = false;
                            default -> System.out.println("Родной мындай сан жок!");
                        }
                    }
                    break;
                case 3:
                   boolean PharmacyWhile = true;
                    while (PharmacyWhile){
                        System.out.println("""
                           1.Add Pharmacy
                           2.Get All Pharmacy
                           3.Get Pharmacy By Id
                           4.Update Pharmacy By Id
                           5.Delete Pharmacy By Id
                           6.Exit
                                """);
                      switch (scanner.nextInt()){
                          case 1->{
                              Pharmacy pharmacy = new Pharmacy();
                              pharmacy.setId(GenericId.genericPharmacyId());
                              System.out.println("Enter Pharmacy Name: ");
                              String name = scanner.next();
                              pharmacy.setName(name);
                              System.out.println("Enter Pharmacy Address: ");
                              String adres = scanner.next();
                              pharmacy.setAddress(adres);
                              System.out.println(pharmacyService.savePharmacy(pharmacy));
                          }
                          case 2->System.out.println(pharmacyService.getAllPharmacy());
                          case 3->{
                              System.out.println("Enter Pharmacy Id: ");
                              Long id= scanner.nextLong();
                              System.out.println(pharmacyService.getbyIdPharmacy(id));
                          }
                          case 4->{
                              Pharmacy pharmacy = new Pharmacy();
                              System.out.println("Enter Pharmacy Id: ");
                              Long id = scanner.nextLong();
                              System.out.println("Enter Pharmacy new Name: ");
                              String name = scanner.next();
                              pharmacy.setName(name);
                              System.out.println("Enter Pharmacy new Address: ");
                              String adres = scanner.next();
                              pharmacy.setAddress(adres);
                              System.out.println(pharmacyService.updatePharmacyById(id, pharmacy));
                          }
                          case 5->{
                              System.out.println("Enter Pharmacy Id: ");
                              Long id = scanner.nextLong();
                              System.out.println(pharmacyService.deletePharmacy(id));
                          }
                          case 6-> PharmacyWhile = false;
                          default -> System.out.println("Родной мындай сан жок!");
                      }
                    }
                    break;
                case 4:
                    return;
            }
        }
    }
}