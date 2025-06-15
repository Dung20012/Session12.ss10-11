package Exercise03;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Order {
    private int orderId; // mã đơn hàng
    private String customerName; // tên khách hàng
    private String phoneNumber; // SĐT
    private String address; // địa chỉ giao hàng
    private float orderAmount; // giá trị đơn hàng
    private String status; // trạng thái đơn hàng

//    Constructor k tham số
    public Order() {
    }
//    Constructor có tham số
    public Order(int orderId, String customerName, String phoneNumber, String address, float orderAmount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderAmount = orderAmount;
        this.status = status;
    }
//    Getter/Setter
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(float orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    Phương thức nhập đầy đủ thông tin đơn hàng
    public void inputData(Scanner scanner){
        System.out.println("Nhập tên khác hàng (6-100 ký tự):");
        while (true){
            customerName = scanner.nextLine();
            if (customerName.length() >=6 && customerName.length() <=100){
                break;
            }
            System.err.println("Tên khác hàng phải từ 6 - 100 ký tự");
        }

        System.err.println("Nhập số điện thoại (đúng định dạng VN):");
        while (true){
            phoneNumber = scanner.nextLine();
            if (Pattern.matches("^(0|84)(3[2-9]|5[6|8|9]|7[06-9]|8[1-9]|9[0-9])[0-9]{7}$", phoneNumber)){
                break;
            }
            System.err.println("Số điện thoại không đúng định dạng !");
        }

        System.out.println("Nhập địa chỉ giao hàng:");
        while (true){
            address = scanner.nextLine();
            if (!address.isEmpty()){
                break;
            }
            System.err.println("Địa chỉ không được để trống");
        }

        System.out.println("Nhập giá trị đơn hàng (>0):");
        while (true){
            try {
                orderAmount = Float.parseFloat(scanner.nextLine());
                if (orderAmount > 0){
                    break;
                }
                System.err.println("Giá trị phải >0");
            }catch (Exception e){
                System.err.println("Giá trị không hợp lệ !");
            }
        }
        status = "Pending"; // mặc định
    }
//    Thông tin đối tượng đơn hàng
    @Override
    public String toString() {
        return String.format("ID: %d - Tên: %s - SĐT: %s - Địa chỉ: %s - Giá trị: %.2f - Trạng thái: %s",
                orderId, customerName, phoneNumber, address, orderAmount,status);
    }
}
