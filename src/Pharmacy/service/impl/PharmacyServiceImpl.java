package Pharmacy.service.impl;

import Pharmacy.db.Database;
import Pharmacy.model.Pharmacy;
import Pharmacy.service.PharmacyService;

import java.util.List;

public class PharmacyServiceImpl implements PharmacyService {


    @Override
    public String savePharmacy(Pharmacy pharmacy) {
        Database.getPharmacy.add(pharmacy);
        return "Success saved!✅";
    }

    @Override
    public List<Pharmacy> getAllPharmacy() {
        return Database.getPharmacy;
    }

    @Override
    public Pharmacy getbyIdPharmacy(Long pharmasyId) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmasyId)){
                return pharmacy;
            }
        }
        System.out.println("Not-Found!");
        return null;
    }

    @Override
    public String updatePharmacyById(Long pharmacyId, Pharmacy newpharmasy) {
        for (Pharmacy pharmacy : Database.getPharmacy) {
            if (pharmacy.getId().equals(pharmacyId)){
                pharmacy.setName(newpharmasy.getName());
                pharmacy.setAddress(newpharmasy.getAddress());
                return "Success updated!✅";
            }
        }
        return "Not-Correct!❌";
    }

    @Override
    public String deletePharmacy(Long pharmacyId) {
        for (Pharmacy pharmacy:Database.getPharmacy){
            if (pharmacy.getId().equals(pharmacyId)){
                pharmacy.getEmployees().clear();
                pharmacy.getMedicines().clear();
                Database.getPharmacy.remove(pharmacy);
                return "Success Deleted!✅";
            }
        }
        return "Not-Correct!❌";
    }
}
