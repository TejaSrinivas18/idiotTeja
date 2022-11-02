package com.temple.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PoojaDetails extends Auditable<String>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "oracle5")
	@SequenceGenerator(name = "oracle5",sequenceName = "pooja_seq4",allocationSize = 1)//401
	@Column(name = "poojaId")
	private Integer poojaId;
	@NotBlank(message = "poojaType should not be null")
	private String poojaType;
	@NotBlank(message = "poojaPrice should not be null")
	private String poojaPrice;


	
//	update emp1 
//	set name = 'null'
//	where id = 1;
	
	
	
	
	
	
	
//	public PoojaDetails(int poojaId, String aarti, String abhishekam, String kalyanam) {
//		super();
//		this.poojaId = poojaId;
//		this.aarti = aarti;
//		this.abhishekam = abhishekam;
//		this.kalyanam = kalyanam;
//
//	}
//
//	public PoojaDetails() {
//		super();
//	}
//
//	public int getPoojaId() {
//		return poojaId;
//	}
//
//	public void setPoojaId(int poojaId) {
//		this.poojaId = poojaId;
//	}
//
//	public String getAarti() {
//		return aarti;
//	}
//
//	public void setAarti(String aarti) {
//		this.aarti = aarti;
//	}
//
//	public String getAbhishekam() {
//		return abhishekam;
//	}
//
//	public void setAbhishekam(String abhishekam) {
//		this.abhishekam = abhishekam;
//	}
//
//	public String getKalyanam() {
//		return kalyanam;
//	}
//
//	public void setKalyanam(String kalyanam) {
//		this.kalyanam = kalyanam;
//	}
//
//	@Override
//	public String toString() {
//		return "PoojaDetails [poojaId=" + poojaId + ", aarti=" + aarti + ", abhishekam=" + abhishekam + ", kalyanam="
//				+ kalyanam + "]";
//	}

}
