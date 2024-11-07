package labs.lab4;
import labs.lab1.Animal;
import labs.lab1.Order;
import labs.lab1.Product;
import java.util.ArrayList;
import java.util.List;

public class OrderBuilder {
    public int id;
    public List<Animal> animalList;
    public List<Product> productList;
    public int employeeId;
    public String orderDate;

    private List<String> validationErrors = new ArrayList<>();

    public OrderBuilder setId(int id) {
        if (id <= 0) {
            validationErrors.add("Invalid ID: " + id + ". ID must be greater than 0.");
        }
        this.id = id;
        return this;
    }

    public OrderBuilder setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
        return this;
    }

    public OrderBuilder setProductList(List<Product> productList) {
        this.productList = productList;
        return this;
    }

    public OrderBuilder setEmployeeId(int employeeId) {
        if (employeeId <= 0) {
            validationErrors.add("Invalid Employee ID: " + employeeId + ". Employee ID must be greater than 0.");
        }
        this.employeeId = employeeId;
        return this;
    }

    public OrderBuilder setOrderDate(String orderDate) {
        if (orderDate == null || !orderDate.matches("\\d{4}-\\d{2}-\\d{2}")) { // Дата YYYY-MM-DD
            validationErrors.add("Invalid Order Date: '" + orderDate + "'. Order Date must be in the format YYYY-MM-DD.");
        }
        this.orderDate = orderDate;
        return this;
    }

    public Order build() {
        if (!validationErrors.isEmpty()) {
            throw new IllegalArgumentException("Invalid fields: " + String.join(", ", validationErrors));
        }

        return new Order(this);
    }
}