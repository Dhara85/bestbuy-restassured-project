package com.bestbuy.model;

public class ProductPojo {
     private String name;
     private String type;
     private double price;
     private String description;
     private String model;
     private String upc;
     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public String getType() {
          return type;
     }

     public void setType(String type) {
          this.type = type;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }

     public String getUpc() {
          return upc;
     }

     public void setUpc(String upc) {
          this.upc = upc;
     }

     public String getModel() {
          return model;
     }

     public void setModel(String model) {
          this.model = model;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }


}
