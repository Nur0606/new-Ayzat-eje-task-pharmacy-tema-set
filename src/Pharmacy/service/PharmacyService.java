package Pharmacy.service;

import Pharmacy.model.Pharmacy;

import java.util.List;

public interface PharmacyService {
    String savePharmacy(Pharmacy pharmacy);

    List<Pharmacy> getAllPharmacy();

    Pharmacy getbyIdPharmacy(Long pharmasyId);

    String  updatePharmacyById(Long pharmacyId, Pharmacy newpharmasy);

    String deletePharmacy(Long pharmacyId);
}
