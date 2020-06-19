package org.tomp.api.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.threeten.bp.OffsetDateTime;
import org.tomp.api.repository.DummyRepository;

import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;

@Component
@ConditionalOnProperty(value = "tomp.providers.payment", havingValue = "generic", matchIfMissing = true)
public class GenericPaymentProvider implements PaymentProvider {

	@Autowired
	DummyRepository repository;

	@Override
	public JournalEntry claimExtraCosts(String acceptLanguage, String api, String apiVersion, String id,
			ExtraCosts body) {
		JournalEntry extraCosts = new JournalEntry();
		extraCosts.setAmount(body.getAmount());
		extraCosts.setAmountExVat(body.getAmountExVat());
		extraCosts.setComment(body.getDescription());
		extraCosts.setCurrencyCode(body.getCurrencyCode());
		extraCosts.setDetails(body);
		// extraCosts.setExpirationDate(body.get);
		extraCosts.setJournalId(id);
		extraCosts.setState(JournalState.TO_INVOICE);
		extraCosts.setVatCountryCode(body.getVatCountryCode());
		extraCosts.setVatRate(body.getVatRate());
		return extraCosts;
	}

	@Override
	public List<JournalEntry> getJournalEntries(String acceptLanguage, String api, String apiVersion,
			OffsetDateTime from, OffsetDateTime to, JournalState state, String category, String maasId) {
		return repository.getJournalEntries(acceptLanguage, from, to, state, category, maasId);
	}

}
