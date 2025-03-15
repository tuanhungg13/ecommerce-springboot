package dev.mobile.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Status {
    private int code;
    private String message;
    private String label;
    private String requestId;

    public static Status success() {
        return new Status(200, "Thành công", "API_STATUS_SUCCESS", UUID.randomUUID().toString());
    }

    public static Status error(int code, String message, String label) {
        return new Status(code, message, label, UUID.randomUUID().toString());
    }
}
