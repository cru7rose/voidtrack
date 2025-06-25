package com.voidtracker.oms.order.mobile;

import lombok.Data;

@Data
public class EpodDto {
    private String epodId;
    private String orderId;
    private String signature;
    private String photoUrl;
    private String deliveredBy;
    private String deliveredAt;
}
