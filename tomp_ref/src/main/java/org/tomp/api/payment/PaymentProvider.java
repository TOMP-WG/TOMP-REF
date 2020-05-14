package org.tomp.api.payment;

import java.math.BigDecimal;
import java.util.List;

import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;

public interface PaymentProvider {

	JournalEntry claimExtraCosts(String acceptLanguage, String api, String apiVersion, String id, ExtraCosts body);

	List<JournalEntry> getJournalEntries(String acceptLanguage, String api, String apiVersion, BigDecimal from,
			BigDecimal to, JournalState state, String category, String maasId);

}
