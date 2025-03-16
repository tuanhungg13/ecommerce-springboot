package dev.mobile.ecommerce.models;
import jakarta.persistence.*;

@Entity
@Table(name = "payments") // Ánh xạ với bảng trong DB
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tương ứng với AUTO_INCREMENT
    @Column(name = "paymentId") // Đảm bảo trùng với tên cột trong DB
    private Long paymentId;

    @Column(name = "paymentMethod") // Đảm bảo trùng với tên cột trong DB
    private String paymentMethod;

    // Constructors
    public Payment() {}

    public Payment(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    // Getters và Setters
    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}

