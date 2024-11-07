package labs.lab2;
import labs.lab1.Animal;
import labs.lab1.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PetStoreService {

    public List<Animal> getSortedAnimalsByAge(List<Animal> animals) {
        return animals.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Product> getSortedProductsByPrice(List<Product> products) {
        return products.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public Map<String, List<Animal>> groupAnimalsBySpecies(List<Animal> animals) {
        return animals.stream()
                .collect(Collectors.groupingBy(Animal::getSpecies));
    }

    public boolean updateAnimalById(List<Animal> animals, int id, Animal newAnimal) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getId() == id) {
                animals.set(i, newAnimal);
                return true;
            }
        }
        return false;
    }

    public boolean updateProductById(List<Product> products, int id, Product newProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                products.set(i, newProduct);
                return true;
            }
        }
        return false; о
    }

    public void clearCollections(List<Animal> animals, List<Product> products) {
        animals.clear();
        products.clear();
    }
}