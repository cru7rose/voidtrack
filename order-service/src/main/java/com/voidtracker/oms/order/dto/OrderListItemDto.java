package com.voidtracker.oms.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
public class OrderListItemDto {
    @NotNull
    private String orderId;

    @NotNull
    @Pattern(regexp = "PENDING|NEW|PICKUP|PSIP|LOAD|TERM|POD")
    private String status;

    @NotNull
    @Pattern(regexp = "NORMAL|URGENT")
    private String priority;

    @NotNull
    @Size(min = 1, max = 100)
    private String customer;

    @NotNull
    @Size(min = 1, max = 100)
    private String cityFrom;

    @NotNull
    @Size(min = 1, max = 100)
    private String cityTo;

    @NotNull
    private String created;

    private String assignedDriver;
}
