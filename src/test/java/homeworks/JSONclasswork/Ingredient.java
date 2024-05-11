package homeworks.JSONclasswork;

public class Ingredient {
    private String itemdescription;
    private int quantity;

    public Ingredient(String itemdescription, int quantity) {
        this.itemdescription = itemdescription;
        this.quantity = quantity;
    }
    public Ingredient() {
    }
    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "itemdescription='" + itemdescription + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
