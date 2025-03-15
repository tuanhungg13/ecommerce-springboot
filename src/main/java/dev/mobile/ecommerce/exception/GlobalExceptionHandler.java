package dev.mobile.ecommerce.exception;

import dev.mobile.ecommerce.response.ApiResponse;
import dev.mobile.ecommerce.response.Status;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý lỗi chung (Exception)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGlobalException(Exception ex) {
        Status errorStatus = Status.error(500, "Lỗi hệ thống", "API_STATUS_ERROR");
        return new ResponseEntity<>(new ApiResponse<>(errorStatus, null), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Xử lý lỗi Bad Request (ví dụ: Request sai format)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<Void>> handleBadRequest(IllegalArgumentException ex) {
        Status errorStatus = Status.error(400, ex.getMessage(), "API_STATUS_BAD_REQUEST");
        return new ResponseEntity<>(new ApiResponse<>(errorStatus, null), HttpStatus.BAD_REQUEST);
    }

    // Xử lý lỗi NOT FOUND (404) khi tài nguyên không tồn tại
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFound(ResourceNotFoundException ex) {
        Status errorStatus = Status.error(404, ex.getMessage(), "API_STATUS_NOT_FOUND");
        return new ResponseEntity<>(new ApiResponse<>(errorStatus, null), HttpStatus.NOT_FOUND);
    }
}