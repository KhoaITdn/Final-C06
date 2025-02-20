package com.example.demo20022025.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class NewProduct {

    @NotNull(message = "Tên không được để trống")
    @Size(min = 5, max = 50, message = "Tên phải dài từ 5 đến 50 kí tự")
    private String name;

    @NotNull(message = "Giá không được để trống")
    @Min(value = 100000, message = "Giá bắt đầu phải lớn hơn hoặc bằng 100000")
    private Long price;

    @NotNull(message = "Loại sản phẩm không được để trống")
    private Long categoryId;

    @NotNull(message = "Trạng thái không được để trống")
    private String status; // Thêm thuộc tính status
}
