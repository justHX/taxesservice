package ru.fitkb.nkharin.taxservice.dto.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.fitkb.nkharin.taxservice.dto.entity.PersonInfo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonInfoMapper  implements RowMapper<PersonInfo> {

	@Override
	public PersonInfo mapRow(ResultSet resultSet, int i) throws SQLException {

		PersonInfo personInfo = new PersonInfo();
		personInfo.setInn(resultSet.getString("inn"));
		personInfo.setLastname(resultSet.getString("lastname"));
		personInfo.setFirstname(resultSet.getString("firstname"));
		personInfo.setPatronymic(resultSet.getString("patronymic"));
		personInfo.setSerialNumber(resultSet.getString("serial_number"));
		personInfo.setNowCredit(resultSet.getBoolean("now_credit"));
		personInfo.setVoucher(resultSet.getBoolean("voucher"));
		personInfo.setRealty(resultSet.getBoolean("realty"));
		personInfo.setCompany(resultSet.getString("company"));
		personInfo.setCompanyTime(resultSet.getString("company_time"));
		return personInfo;
	}
}
