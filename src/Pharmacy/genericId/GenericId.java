package Pharmacy.genericId;

public class GenericId {
    public  static  Long pharmacyid = 0L;
    public  static  Long employeid = 0L;
    public  static  Long medicineid = 0L;

    public static long genericPharmacyId(){
        return ++pharmacyid;
    }
    public static long genericEmployeId(){
        return ++employeid;
    }
    public static long genericMedicineId(){
        return ++medicineid;
    }



}
