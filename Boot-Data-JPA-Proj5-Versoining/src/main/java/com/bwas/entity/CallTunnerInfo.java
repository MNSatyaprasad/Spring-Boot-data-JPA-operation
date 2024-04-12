package com.bwas.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "Call_Tunner_info")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class CallTunnerInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer tuneId;
	@NonNull
	private String tuneName;
	@NonNull
	private String movieName;
	@Version
	@Column(name = "updated_Count")
	private Integer updateCount;
	@Column(name = "Service_Opted_on")
	@CreationTimestamp
	private LocalDateTime serviceOptedOn;
	@Column(name = "Lastly_Updated_on")
	@UpdateTimestamp
	private LocalDateTime lastlyUpdatedOn;
	
}
