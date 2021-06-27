package ru.fitkb.nkharin.taxservice.dto;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.fitkb.nkharin.taxservice.dto.entity.PersonInfo;
import ru.fitkb.nkharin.taxservice.dto.mapper.PersonInfoMapper;
import ru.fitkb.nkharin.taxservice.model.PersonSaveRq;

@Repository
@RequiredArgsConstructor
public class PersonInfoDto {

	private final JdbcTemplate jdbcTemplate;

	public void savePerson(PersonSaveRq personSaveRq) {

		String query = "INSERT INTO person_info (inn, lastname, firstname, patronymic, serial_number, " +
				"now_credit,voucher, realty, company, company_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, " +
				"?, ?)";

		jdbcTemplate.update(query, personSaveRq.getInn(), personSaveRq.getLastname(),
				personSaveRq.getFirstname(), personSaveRq.getPatronymic(),
				personSaveRq.getSerialNumber(), personSaveRq.getNowCredit(),
				personSaveRq.getVoucher(), personSaveRq.getRealty(), personSaveRq.getCompany(),
				personSaveRq.getCompanyTime());
	}

	public PersonInfo getPerson(String inn) {

		String query = "SELECT * FROM person_info WHERE inn = " + "\'" + inn + "\'";

		return jdbcTemplate.queryForObject(query, new PersonInfoMapper());
	}
}
