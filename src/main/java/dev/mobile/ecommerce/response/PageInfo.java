package dev.mobile.ecommerce.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageInfo {
    private int totalPages;
    private int currentPage;
    private int size;
}

