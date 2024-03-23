package Pharmacy.service;

import Pharmacy.model.Medicine;

import java.util.List;

public interface MedicineService {
    String addMedicineToPharmasyById(Long pharmacyId, Medicine medicine);

    List<Medicine> getAllMedicineByPharmacyId(Long pharmacyId);

    Medicine getMedicineByIdToPharmacyId(Long pharmasyId, Long medicineId);

    String  updateMedicineToPharmacyId(Long pharmacyId,Long medicineId, Medicine newmedicine);

    String  deleteMedicineByIdToPharmacyId(Long pharmacyId, Long medicineId);

    List<Medicine> sortByPrice(String ascOrdesc);

    List<Medicine> ortByDeliveryDate(String ascOrdesc);

    List<Medicine> sortByExpirationDate(String ascOrdesc);
}
