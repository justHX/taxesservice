package ru.fitkb.nkharin.taxservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.fitkb.nkharin.taxservice.dto.PersonInfoDto;
import ru.fitkb.nkharin.taxservice.dto.entity.PersonInfo;
import ru.fitkb.nkharin.taxservice.model.CanCreditRs;
import ru.fitkb.nkharin.taxservice.model.PersonSaveRq;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaxesService {

	private final PersonInfoDto personInfoDto;

	public CanCreditRs takePersonInfoTaxesByInn(String inn) {

		PersonInfo person = personInfoDto.getPerson(inn);

		CanCreditRs canCreditRs = new CanCreditRs();
		if (person.getNowCredit() || !person.getVoucher() || !person.getRealty()) {
			canCreditRs.setApprovedCredit(false);
			return canCreditRs;
		}

		canCreditRs.setApprovedCredit(true);
		log.debug("approvedLimit: " + canCreditRs.getApprovedCredit());
		return canCreditRs;
	}

	public void saveNewPerson(PersonSaveRq personSaveRq) {

		personInfoDto.savePerson(personSaveRq);
	}
}
