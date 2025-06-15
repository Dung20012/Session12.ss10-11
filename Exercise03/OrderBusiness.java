package Exercise03;

import java.util.*;
import java.util.stream.Collectors;

public class OrderBusiness {
    private static List<Order> orderList = new ArrayList<>();

//    1. Thêm đơn hàng
    public static void addOrder(Scanner scanner){
        Order order = new Order();
        order.inputData(scanner);
        orderList.add(order);
        System.out.println("Đơn hàng được thêm thành công");
    }
//    2. Hiển thị danh sách đơn hàng
    public static void displayOrders(){
        if (orderList.isEmpty()){
            System.out.println("Danh sách đơn hàng trống");
            return;
        }
        orderList.stream() // khởi tạo stream
//                sắp xếp, đảo ngược thứ tự sắp xếp hiện tại
                .sorted(Comparator.comparing(Order::getOrderAmount).reversed())
                .forEach(System.out::println); // duyệt phần tử
    }
//    3. Cập nhật trạng thái đơn hàng
    public static void updateOrdeStatus(Scanner scanner){
        System.out.println("Nhập mã đơn hàng cần cập nhật:");
        int orderId = Integer.parseInt(scanner.nextLine());
        Optional<Order> optional = orderList.stream()
                .filter(order -> order.getOrderId() == orderId) // lọc dữ liệu theo đk, s/d biểu thức lambda
                .findFirst(); // tìm phần tử đầu tiên trong luồng stream
        optional.ifPresentOrElse(order ->{
            System.out.println("Trạng thái hiện tại: " + order.getStatus());
            switch (order.getStatus()){
                case "Pending":
                    order.setStatus("Shipped");
                    break;
                case "Shipped":
                    order.setStatus("Delivered");
                    break;
                case "Delivered":
                    System.out.println("Đơn hàng đã giao, không thể cập nhật");
                    return;
            }
            System.out.println("Đã cập nhật trạng thái: " +order.getStatus());
        },()->System.out.println("Không tìm thấy đơn hàng có ID: " + orderId));
    }
//    4. Xóa đơn hàng theo mã (chỉ xóa nếu là trạng thái Pending)
    public static void deleteOrder(Scanner scanner){
        System.out.println("Nhập mã đơn hàng cần xóa:");
        int orderId = Integer.parseInt(scanner.nextLine());
        Optional<Order> optional = orderList.stream()
                .filter(order -> order.getOrderId() == orderId && order.getStatus().equals("Pending"))
                .findFirst();
        optional.ifPresentOrElse(order -> {
            orderList.remove(order);
            System.out.println("Đã xóa đơn hàng");
        },()-> System.out.println("Không tìm thấy mã đơn hàng có ID: "
                + orderId + " hoặc không thể xóa (phải là Pending)"));
    }
//    5. Tìm kiếm tên khách hàng (không phân biệt hoa thường)
    public static void searchByCustomerName(Scanner scanner){
        System.out.println("Nhập tên khách hàng cần tìm");
        String name = scanner.nextLine();
        List<Order> result = new ArrayList<>();
        for (Order order : orderList) {
            if (order.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                result.add(order);
            }
        }
        if (result.isEmpty()){
            System.out.println("Không tìm thấy đơn hàng");
        }else {
            result.forEach(System.out::println);
        }
    }
//    6. Thống kê tổng số đơn hàng
    public static void totalOrder(){
        System.out.println("Tổng số đơn hàng: " + orderList.size());
    }
//    7. Thống kê tổng doanh thu đơn hàng Delivered
    public static void totalRevenue(){
        double total = orderList.stream()
                .filter(order -> order.getStatus().equals("Delivered"))
                .mapToDouble(Order::getOrderAmount) // chuyển đổi sang giá trị double
                .sum();
        System.out.println("Tổng doanh thu (Delivered): " + total);
    }
//    8. Thống kê số lượng đơn hàng theo từng trạng thái
    public static void countByStatus(){
        Map<String, Long> map = orderList.stream()
                .collect(Collectors.groupingBy(Order::getStatus, Collectors.counting()));
        System.out.println("Số lượng đơn hàng theo trạng thái");
        map.forEach((string, aLong) -> System.out.println(" - " + string + " : " + aLong));
    }
//    9. Tìm đơn hàng có giá trị lớn nhất
    public static void findMaxOrder(){
        Optional<Order> max = orderList.stream()
                .max(Comparator.comparing(Order::getOrderAmount));
        max.ifPresentOrElse(order -> {
            System.out.println("Đơn hàng có giá trị lớn nhất:");
            System.out.println(order);
        },() -> System.out.println("Không có đơn hàng nào"));
    }
}
