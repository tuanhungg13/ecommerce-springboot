package dev.mobile.ecommerce.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Bỏ qua các field null khi serialize
public class ApiResponse<T> {
    private Status status;
    private T data;
    private PageInfo pages;

    public ApiResponse(Status status, T data) {
        this.status = status;
        this.data = data;
        this.pages = null;
    }
}
