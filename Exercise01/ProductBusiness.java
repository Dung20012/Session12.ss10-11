package Exercise01;

import java.util.*;

public class ProductBusiness {
//    Quản lý danh sách sản phm - List - ArrayList
    public static List<Product> productList = new ArrayList<>();

    public static void addProduct(Scanner scanner){
        Product product = new Product();
        product.inputData(scanner);
//        Thêm product vào danh sách productList
        /*
        * add(int index, Object o): chèn đối tượng o vào vị trí index
        * add(Object o): thêm đối tượng o vào cuối danh sách
        * get(int index): trả ra phẩn tử ở trị trí index của danh sách
        * set(int index, Object o): Đè đối tượng o vào vị trí index
        * remove(Object o): Xóa phẩn tử o trong danh sách
        * remove(int index): Xóa phần tử vị trí index
        * size(): trả ra số lượng phần tử trong danh sách
        * */
        productList.add(product); // thêm 1 sản phẩm vào cuối danh sách
    }
//    Hiển thị danh sách sản phm
    public static void displayProducts(){
        if (productList.isEmpty()){ // ktra xem có phần tử trong danh sách chưa?
            System.out.println("Chưa có sản phẩm nào trong danh sách");
            return;
        }
        for (Product product : productList){
//            tự hiểu là product.toString()
            System.out.println(product);
        }
    }
//    Ktra xem productId có tồn tại trong productList hay không
    public static int findIndexById(int productId){
        for (int i =0; i<productList.size();i++){
            if (productList.get(i).getProductId()==productId){
                return i;
            }
        }
        return -1;
    }
//    Cập nhật sản phẩm theo mã sản phẩm
    public static void updateProduct(Scanner scanner){
        System.out.println("Nhập vào mã sản phẩm cần cập nhật:");
        int productId = Integer.parseInt(scanner.nextLine());
        int indexUpdate = findIndexById(productId);
        if (indexUpdate != -1){
            boolean isExit = true;
            do {
                System.out.println("********CẬP NHẬT SẢN PHẨM********");
                System.out.println("1. Cập nhât tên sản phẩm");
                System.out.println("2. Cập nhât giá sản phẩm");
                System.out.println("3. Cập nhât danh mục sản phẩm");
                System.out.println("4. Cập nhật số lượng sản phẩm");
                System.out.println("5. Thoát");
                System.out.println("Lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập vào tên sản phẩm cần cập nhật");
                        productList.get(indexUpdate).setProductName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào giá mới sản phẩm: ");
                        productList.get(indexUpdate).setPrice(Float.parseFloat(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào danh mục cần cập nhật: ");
                        productList.get(indexUpdate).setCategory(scanner.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập vào số lượng sản phẩm: ");
                        productList.get(indexUpdate).setQuantity(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 5:
                        isExit = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn 1-5");
                }
            }while (true);
        }else {
            System.out.println("Mã sản phẩm không tồn tại");
        }
    }
//    Xóa sản phẩm theo mã sản phẩm
    public static void deleteProduct(Scanner scanner){
        System.out.println("Nhập vào mã sản phẩm cần xóa:");
        int productId = Integer.parseInt(scanner.nextLine());
        int indexDelete = findIndexById(productId);
        if (indexDelete != -1){
            productList.remove(indexDelete);
        }else {
            System.err.println("Mã sản phẩm không tồn tại");
        }
    }
//    Tìm kiếm sản phẩm theo tên
    public static void searchProductByName(Scanner scanner){
        System.out.println("Nhập vào tên sản phẩm cần tìm:");
        String productName = scanner.nextLine();
        for (Product product : productList){
            if (product.getProductName().toLowerCase().contains(productName.toLowerCase())){
                System.out.println(product);
            }
        }
    }
//    Sắp xếp sản phẩm theo giá tăng dần (sử dụng Comparable)
    /*
    * B1: Lớp sắp xếp phải đc kế thừa Comparable Interface
    * B2: Triển khai phương thức compareTo để cài đặt sắp xếp
    * B3: Sử dụng phương thức sort của Collection để tiến hành sắp xếp
    * */
    public static void sortProductByPriceASC(){
        Collections.sort(productList); // sắp xếp sort đối tượng của lớp
    }
//    Sắp xếp sản phẩm theo số lượng giảm dần sử dụng Compareble
//    B1: s/d phương thức sort của Collections để sắp xếp với 1 đối tượng đc khởi tạo dán tiếp từ Comparator
//    B2: cài đặt phương thức compare để sắp xếp
    public static void sortProductByQuantity(){
        Collections.sort(productList, new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (o1.getQuantity() - o2.getQuantity()); // sắp xếp tăng dần
            }
        });
    }
}
