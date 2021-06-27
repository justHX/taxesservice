package ru.fitkb.nkharin.taxservice.model;

import lombok.Data;

@Data
public class PersonSaveRq {

	private String inn;
	private String lastname;
	private String firstname;
	private String patronymic;
	private String serialNumber;
	private Boolean nowCredit;
	private Boolean voucher;
	private Boolean realty;
	private String company;
	private String companyTime;

}
