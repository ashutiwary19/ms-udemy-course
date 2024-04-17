package com.ashu.loans.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Loans extends AuditedEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loanId;

	private String mobileNumber;

	private String loanNumber;

	private String loanType;

	private int totalLoan;

	private int amountPaid;

	private int outstandingAmount;

}