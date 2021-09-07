import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        ProductComparator productComparator = new ProductComparator();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    productManager.showProduct();
                    break;
                }
                case 2: {
                    addNewProduct(productManager, scanner);
                    break;
                }
                case 3: {
                    updateProductById(productManager, scanner);
                    break;
                }
                case 4: {
                    removeProductById(productManager, scanner);
                    break;
                }
                case 5: {
                    sortProductAscendingOrDescending(productManager, scanner, choice);
                    break;
                }
                case 6: {
                    int index = productManager.findProductByPrice();
                    System.out.println("Sản phẩm có giá đắt nhất :");
                    System.out.println(productManager.getProductList().get(index));
                    break;
                }
                case 7: {
                    productManager.readFile();
                    break;
                }
                case 8:{
                    DataHandler.writeToFile();
                    break;
                }
                case 9: {
                    System.exit(0);
                    break;
                }
            }
        } while (choice != 9);
    }

    private static void sortProductAscendingOrDescending(ProductManager productManager, Scanner scanner, int choice) {
        int choice1;
        do {
            menuSort();
            choice1 = scanner.nextInt();
            switch (choice1) {
                case 1: {
                    productManager.sortUp();
                    break;
                }
                case 2: {
                    Collections.sort(productManager.getProductList());
                    productManager.showProduct();
                    break;
                }
                case 3: {
                    menu();
                    break;
                }
            }
        } while (choice != 3);
    }

    private static void menuSort() {
        System.out.println("1. Sắp xếp theo giá tăng dần");
        System.out.println("2. Sắp xếp theo giá giảm dần");
        System.out.println("3. Quay lại");
    }

    private static void addNewProduct(ProductManager productManager, Scanner scanner) {
        Product product = inputProduct(scanner);
        productManager.addProduct(product);
    }

    private static void removeProductById(ProductManager productManager, Scanner scanner) {
        System.out.println("Nhập mã sản phầm cần xóa");
        scanner.nextLine();
        String id = scanner.nextLine();
        int index = productManager.findProductById(id);
        if (index != -1) {
            System.out.println("Bạn có chắc chắn muốn xóa :");
            System.out.println("Nhập Y để xóa (Nhập chữ bất kỳ để quay lại menu chính)");
            String choice = scanner.nextLine();
            switch (choice){
                case "y":
                case "Y":{
                    productManager.removeProduct(index);
                    break;
                }
                default:{
                    menu();
                    break;
                }
            }

        } else {
            System.err.println("Không tìm được sản phẩm với mã sản phẩm trên");
        }
    }

    private static void updateProductById(ProductManager productManager, Scanner scanner) {
        System.out.println("Nhập id sản phẩm cần sửa");
        scanner.nextLine();
        String id = scanner.nextLine();
        int index = productManager.findProductById(id);
        if (index != -1) {
            Product product = inputProduct(scanner);
            productManager.updateProduct(index, product);
        } else {
            System.err.println("Không tìm được sản phẩm với mã sản phẩm trên");
        }
    }

    private static Product inputProduct(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm");
        scanner.nextLine();
        String id = scanner.nextLine();
        System.out.println("Nhập tên sản2 phầm");
        String name = scanner.nextLine();
        System.out.println("Nhập giá sản phầm");
        int price = scanner.nextInt();
        System.out.println("Nhập số lượng sản phầm");
        int quantity = scanner.nextInt();
        System.out.println("Nhập mô tả sản phầm");
        scanner.nextLine();
        String description = scanner.nextLine();
        return new Product(id, name, price, quantity, description);
    }

    private static void menu() {
        System.out.println("---- Chương trình quản lí sản phẩm ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục)");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập Nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào file");
        System.out.println("9. Thoát");
        System.out.println("Chọn chức năng :");
    }
}