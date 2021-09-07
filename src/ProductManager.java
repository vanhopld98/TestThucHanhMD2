

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductManager {
    private static List<Product> productList = new ArrayList<>();

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void updateProduct(int index, Product product) {
        productList.set(index, product);
    }

    public void removeProduct(int index) {
        productList.remove(index);
    }

    public void showProduct() {
        for (Product products : productList) {
            System.out.println(products);
        }
    }

    public int findProductById(String id) {
        int index = -1;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int findProductByPrice() {
        int index = -1;
        int productMax = productList.get(0).getPrice();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getPrice() > productMax) {
                productMax = productList.get(i).getPrice();
                index = i;
            }
        }
        return index;
    }

    public void sortUp() {
        ProductComparator productComparator = new ProductComparator();
        Collections.sort(productList, productComparator);
        for (Product products : productList) {
            System.out.println(products);
        }
    }

    public void readFile() {
        List<Product> productList1 = DataHandler.readDataFromFile();
        productList.addAll(productList1);
    }
}
