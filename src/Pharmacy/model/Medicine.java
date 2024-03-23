package Pharmacy.model;

import java.time.LocalDate;

public class Medicine {
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String descriotion;
   private LocalDate dateOfDelivery;
   private LocalDate exprationDate;

    public Medicine() {
    }

    public Medicine(Long id, String name, int price, int quantity, String descriotion, LocalDate dateOfDelivery, LocalDate exprationDate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.descriotion = descriotion;
        this.dateOfDelivery = dateOfDelivery;
        this.exprationDate = exprationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescriotion() {
        return descriotion;
    }

    public void setDescriotion(String descriotion) {
        this.descriotion = descriotion;
    }

    public LocalDate getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(LocalDate dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public LocalDate getExprationDate() {
        return exprationDate;
    }

    public void setExprationDate(LocalDate exprationDate) {
        this.exprationDate = exprationDate;
    }

    @Override
    public String toString() {
        return "Medicine{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               ", descriotion='" + descriotion + '\'' +
               ", dateOfDelivery=" + dateOfDelivery +
               ", exprationDate=" + exprationDate +
               '}';
    }
}
