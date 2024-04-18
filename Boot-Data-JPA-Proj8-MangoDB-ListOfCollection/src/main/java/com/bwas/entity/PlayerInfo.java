package com.bwas.entity;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collation = "Player_Info")
@Data
public class PlayerInfo {
	@Id
	private String id;
	private String playerName;
	private Integer jerseyNo;
	private String paddrs;
	private List<String> nickNames;
	private Set<Integer> contactNumbers;
	private Map<String, Object> impKoncks;
	private Properties idDetails;

}
