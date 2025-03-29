package com.order.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

	private Integer pamentId;
	private String paymentStatus;
	private String transactionId;
	private Integer orderId;
	private Double amount;
	private String message;
}
