package Exercise03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("***** QUẢN LÝ ĐƠN HÀNG *****");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Hiển thị danh sách đơn hàng");
            System.out.println("3. Cập nhật trạng thái đơn hàng theo mã đơn hàng");
            System.out.println("4. Xóa đơn hàng theo mã đơn hàng");
            System.out.println("5. Tìm kiếm đơn hàng theo tên khác hàng");
            System.out.println("6. Thống kê tổng số đơn hàng");
            System.out.println("7. Thống kê tổng doanh thu các đơn hàng Devivered");
            System.out.println("8. Thống kê số lượng đơn hàng theo từng trạng thái");
            System.out.println("9. Tìm kiếm đơn hàng có giá trị lớn nhất");
            System.out.println("0. Thoát");
            System.out.println("Lựa chọn của bạn: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e){
                System.err.println("Vui lòng nhập số hợp lệ từ 0 - 9");
                continue;
            }
            switch (choice){
                case 1:
                    OrderBusiness.addOrder(scanner);
                    break;
                case 2:
                    OrderBusiness.displayOrders();
                    break;
                case 3:
                    OrderBusiness.updateOrdeStatus(scanner);
                    break;
                case 4:
                    OrderBusiness.deleteOrder(scanner);
                    break;
                case 5:
                    OrderBusiness.searchByCustomerName(scanner);
                    break;
                case 6:
                    OrderBusiness.totalOrder();
                    break;
                case 7:
                    OrderBusiness.totalRevenue();
                    break;
                case 8:
                    OrderBusiness.countByStatus();
                    break;
                case 9:
                    OrderBusiness.findMaxOrder();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1 - 9");
            }
        }while (true);
    }
}
