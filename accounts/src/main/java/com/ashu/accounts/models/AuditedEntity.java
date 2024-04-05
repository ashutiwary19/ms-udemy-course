package com.ashu.accounts.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass
@Getter
@Setter
@ToString
public class AuditedEntity {

	@Column(updatable = false)
	private LocalDateTime createdAt;
	
	@Column(updatable = false)
	private String createdBy;
	
	@Column(insertable = false)
	private LocalDateTime updatedTime;
	
	@Column(insertable = false)
	private String updatedBy;

}
