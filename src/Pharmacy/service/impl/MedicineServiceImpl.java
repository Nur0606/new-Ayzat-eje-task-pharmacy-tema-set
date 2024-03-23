package Pharmacy.service.impl;

import Pharmacy.db.Database;
import Pharmacy.model.Medicine;
import Pharmacy.model.Pharmacy;
import Pharmacy.service.MedicineService;

import java.util.Comparator;
import java.util.List;

public class MedicineServiceImpl implements MedicineService {

    @Override
    public String addMedicineToPharmasyById(Long pharmacyId, Medicine medicine) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)){
                pharmacy.getMedicines().add(medicine);
                return "Success Saved!✅";
            }
        }
        return "Not-Correct!❌";
    }

    @Override
    public List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)){
                return pharmacy.getMedicines();
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }

    @Override
    public Medicine getMedicineByIdToPharmacyId(Long pharmasyId, Long medicineId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmasyId)){
                for (Medicine medicine: pharmacy.getMedicines()){
                    if (medicine.getId().equals(medicineId)){
                        return medicine;
                    }
                }
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }

    @Override
    public String updateMedicineToPharmacyId(Long pharmacyId, Long medicineId, Medicine newmedicine) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)){
                for (Medicine medicine: pharmacy.getMedicines()){
                    if (medicine.getId().equals(medicineId)){
                        medicine.setName(newmedicine.getName());
                        medicine.setPrice(newmedicine.getPrice());
                        medicine.setDescriotion(newmedicine.getDescriotion());
                        medicine.setQuantity(newmedicine.getQuantity());
                        medicine.setDateOfDelivery(newmedicine.getDateOfDelivery());
                        medicine.setExprationDate(newmedicine.getExprationDate());
                        return "Success updates!✅";
                    }
                }
            }
        }
        return "Not-Correct!❌";
    }

    @Override
    public String deleteMedicineByIdToPharmacyId(Long pharmacyId, Long medicineId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)){
                for (Medicine medicine: pharmacy.getMedicines()){
                    if (medicine.getId().equals(medicineId)){
                        pharmacy.getMedicines().remove(medicine);
                        return "Success Deleted!✅";
                    }
                }
            }
        }
        return "Not-Found!❌";
    }

    @Override
    public List<Medicine> sortByPrice(String ascOrdesc) {
        for (Pharmacy pharmacy: Database.getPharmacy) {
            if (ascOrdesc.equalsIgnoreCase("asc")) {
                pharmacy.getMedicines().sort(Comparator.comparingInt(Medicine::getPrice));
                return pharmacy.getMedicines();
            } else if (ascOrdesc.equalsIgnoreCase("desc")) {
                pharmacy.getMedicines().sort(Comparator.comparingInt(Medicine::getPrice).reversed());
                return pharmacy.getMedicines();
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }

    @Override
    public List<Medicine> ortByDeliveryDate(String ascOrdesc) {
        for (Pharmacy pharmacy: Database.getPharmacy) {
            if (ascOrdesc.equalsIgnoreCase("asc")) {
                pharmacy.getMedicines().sort(Comparator.comparing(Medicine::getDateOfDelivery));
                return pharmacy.getMedicines();
            } else if (ascOrdesc.equalsIgnoreCase("desc")) {
                pharmacy.getMedicines().sort(Comparator.comparing(Medicine::getDateOfDelivery).reversed());
                return pharmacy.getMedicines();
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }

    @Override
    public List<Medicine> sortByExpirationDate(String ascOrdesc) {
        for (Pharmacy pharmacy: Database.getPharmacy) {
            if (ascOrdesc.equalsIgnoreCase("asc")) {
                pharmacy.getMedicines().sort(Comparator.comparing(Medicine::getExprationDate));
                return pharmacy.getMedicines();
            } else if (ascOrdesc.equalsIgnoreCase("desc")) {
                pharmacy.getMedicines().sort(Comparator.comparing(Medicine::getExprationDate).reversed());
                return pharmacy.getMedicines();
            }
        }
        System.out.println("Not-Found!❌");
        return null;
    }
}
