package Exercise01;

import java.util.Scanner;

public class Product implements Comparable<Product>{
    private int productId;
    private String productName;
    private float price;
    private String category;
    private int quantity;

    public Product() {
    }

    public Product(int productId, String productName, float price, String category, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void inputData(Scanner scanner){
        this.productId = increseProductId();
        this.productName = inputProductName(scanner);
        this.price = inputPrice(scanner);
        this.category = inputCategory(scanner);
        this.quantity = inputQuantity(scanner);
    }

//     Tự tăng
    public int increseProductId(){
//        Lấy mã sản phẩm lớn nhất trong proudctList --> tăng 1
        if (ProductBusiness.productList.isEmpty()){
            return 1;
        }
        int maxId = ProductBusiness.productList.get(0).getProductId();
        for (int i = 0; i<ProductBusiness.productList.size();i++){ // size lấy ra tổng số phần tử của danh sách
            if (maxId<ProductBusiness.productList.get(i).getProductId()){
                maxId = ProductBusiness.productList.get(i).getProductId();
            }
        }
        return maxId +1;
    }

    public String inputProductName(Scanner scanner){
        System.out.println("Nhập vào tên sản phẩm: ");
        do {
            String productName = scanner.nextLine();
//            Validate bắt buộc nhập tên sản phẩm
            if (productName!=null && !productName.trim().isEmpty()){
                if (productName.trim().length()>=10 && productName.trim().length() <=50){
                    boolean isExist = false; // chưa tồn tại
                    for (Product product : ProductBusiness.productList){
                        if (product.getProductName().equals(productName)){
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist){
                        System.err.println("Tên sản phẩm đã tồn tại, vui lòng nhập lại");
                    }else {
//                        nếu đã tồn tại return lại productName
                        return productName;
                    }
                }else {
                    System.err.println("Tên sản phẩm phải từ 10 - 50 ký, tự vui lòng nhập lại ");
                }
            }else {
                System.err.println("Vui lòng nhập vào tên sản phẩm");
            }
        }while (true);
    }
    public float inputPrice(Scanner scanner){
        do {
            String price = scanner.nextLine();
//            Bắt buộc là kiểu float
            try {
                float priceFloat = Float.parseFloat(price);
                if (priceFloat>0){
                    return priceFloat;
                }else {
                    System.err.println("Giá sản phẩm phải >0, vui lòng nhập lại");
                }
            }catch (Exception e){
//                Xảy ra lỗi ngoại lệ convert từ String --> float
                System.err.println("Giá sản phẩm là số thực float, vui lòng nhập lại");
            }
        }while (true);
    }
    public String inputCategory(Scanner scanner){
        System.out.println("Nhập vào danh mục của sản phẩm:");
        do {
            String category = scanner.nextLine();
            if (category.trim().length()<=200){
                return category;
            }
            System.err.println("Danh mục sản phẩm có tối đa 200 ký tự, vui lòng nhập lại");
        }while (true);
    }

    public int inputQuantity(Scanner scanner){
        System.out.println("Nhập vào số lượng tồn kho của sản phẩm:");
        do {
            String quantity = scanner.nextLine();
            try {
                int quantityInt = Integer.parseInt(quantity);
                if (quantityInt >= 0){
                    return quantityInt;
                }
                System.err.println("Số lượng sản phẩm phải >=0, vui lòng nhập lại");
            }catch (Exception e){
                System.err.println("Số lượng sản phẩm phải là số nguyên, vui lòng nhập lại");
            }
        }while (true);
    }
//    Trả về thông tin số lượng sản phẩm

    @Override
    public String toString() {
//        sử dụng định dạng dữ liệu để trả ra
        return String.format("ProductId: %d - ProductName: %s - Price: %f - Category: %s - Quantity: %d",
        this.productId, this.productName, this.price, this.category,this.quantity);
    }

    @Override
    public int compareTo(Product o) {
//        Sắp xếp tăng dần
//        if (this.price>o.price){
//            return 1;
//        }else if (this.price==o.price){
//            return 0;
//        }else {
//            return -1;
//        }
        return Float.compare(this.price,o.price);
    }
}
