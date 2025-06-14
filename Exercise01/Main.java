package Exercise01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("***QUẢN LÝ SẢN PHẨM***");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Danh sách sản phẩm");
            System.out.println("3. Cập nhật sản phẩm theo mã");
            System.out.println("4. Xóa sản phẩm theo mã");
            System.out.println("5. Tìm kiếm sản phẩm theo tên");
            System.out.println("6. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("7. Sắp xếp sản phẩm theo số lượng giảm dần");
            System.out.println("8. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    ProductBusiness.addProduct(scanner);
                    break;
                case 2:
                    ProductBusiness.displayProducts();
                    break;
                case 3:
                    ProductBusiness.updateProduct(scanner);
                    break;
                case 4:
                    ProductBusiness.deleteProduct(scanner);
                    break;
                case 5:
                    ProductBusiness.searchProductByName(scanner);
                    break;
                case 6:
                    ProductBusiness.sortProductByPriceASC();
                    break;
                case 7:
                    ProductBusiness.sortProductByQuantity();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.err.println("VUI LÒNG CHỌN TỪ 1 - 8");
            }
        }while (true);
    }
}
