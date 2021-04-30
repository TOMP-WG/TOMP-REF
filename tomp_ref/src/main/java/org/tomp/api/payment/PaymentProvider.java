package org.tomp.api.payment;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.ExtraCosts;
import io.swagger.model.JournalEntry;
import io.swagger.model.JournalState;

public interface PaymentProvider {

	JournalEntry claimExtraCosts(String acceptLanguage, String api, String apiVersion, String id, ExtraCosts body);

	List<JournalEntry> getJournalEntries(String acceptLanguage, String api, String apiVersion,
			@NotNull @Valid OffsetDateTime from, @NotNull @Valid OffsetDateTime to, JournalState state, String category, String id,
			String maasId);

}
