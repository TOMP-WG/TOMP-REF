package org.tomp.api.booking;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.LookupService;
import org.tomp.api.repository.DefaultRepository;
import org.tomp.api.tripexecution.TaxiTripExecutionProvider;
import org.tomp.api.utils.ClientUtil;
import org.tomp.api.utils.MailUtil;

@Component
@ConditionalOnProperty(value = "tomp.providers.booking", havingValue = "taxi", matchIfMissing = false)
public class TaxiBookingProvider extends SharedCarBookingProvider {

	@Autowired
	TaxiTripExecutionProvider tripExecution;

	public TaxiBookingProvider(DefaultRepository repository, Optional<MailUtil> mailService,
			ExternalConfiguration configuration, ClientUtil clientUtil, LookupService lookupService) {
		super(repository, mailService, configuration, clientUtil, lookupService);
	}

	@Override
	public void saveResult(String id, boolean committed, String remark) {
		super.saveResult(id, committed, remark);
		if (committed) {
			startTripExecution(id);
		}
	}

	private void startTripExecution(String tripId) {
		tripExecution.startExecution(tripId);
	}
}
