package org.tomp.api.utils;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.tomp.api.configuration.ExternalConfiguration;
import org.tomp.api.model.MaasOperator;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.client.ApiException;

@Component
public class RouterUtil {

	private static final Logger log = LoggerFactory.getLogger(RouterUtil.class);

	@Autowired
	ExternalConfiguration configuration;
	@Autowired
	ObjectMapper mapper;
	@Autowired
	ClientUtil clientUtil;

	public HttpHeaders createHeadersToMP(String method, String localVarPath, String body, String mpId)
			throws UnrecoverableKeyException, InvalidKeyException, FileNotFoundException, KeyStoreException,
			CertificateException, UnsupportedEncodingException, NoSuchAlgorithmException, SignatureException {
		String url = configuration.getRouterUrl();

		if (url == null) {
			return new HttpHeaders();
		}
		String thumbprint = configuration.getThumbprint();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSZ");

		MaasOperator router = new MaasOperator();
		router.setName("Router");
		router.setUrl(url);

		SignatureGenerator generator = new SignatureGenerator();
		String msgBody = "";
		try {
			if (body != null && !body.equals("")) {
				msgBody = mapper.writeValueAsString(body);
			}
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		if (msgBody == null) {
			msgBody = "";
		}

		if (mpId == null) {
			mpId = "";
		}

		String timestamp = formatter.format(ZonedDateTime.now());
		String signature = generator.generateSignature(method, (url + localVarPath.substring(1)).toUpperCase(),
				mpId.replace("-", ""), thumbprint, msgBody, configuration.getToID(), timestamp, configuration.getPfx(),
				configuration.getPw());

		HttpHeaders headers = new HttpHeaders();
		headers.put("Client-Signature", Arrays.asList(signature));
		headers.put("CertifacteThumbprint", Arrays.asList(thumbprint));
		headers.put("MPID", Arrays.asList(mpId));
		headers.put("TOID", Arrays.asList(configuration.getToID()));
		headers.put("DEST", Arrays.asList("MP"));
		headers.put("timestamp", Arrays.asList(timestamp));
		return headers;
	}

	public <T> T sendToTO(String method, String localVarPath, Class<T> valueType, Object body, String acceptLanguage)
			throws UnrecoverableKeyException, InvalidKeyException, FileNotFoundException, KeyStoreException,
			CertificateException, UnsupportedEncodingException, NoSuchAlgorithmException, SignatureException,
			JsonProcessingException {
		String url = configuration.getRouterUrl();
		String sensorId = configuration.getSensorId();
		String toID = configuration.getToID();
		String thumbprint = configuration.getThumbprint();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSSZ");

		MaasOperator router = new MaasOperator();
		router.setName("Router");
		router.setUrl(url);

		SignatureGenerator generator = new SignatureGenerator();
		String msgBody = "";
		try {
			if (body != null && !body.equals("")) {
				msgBody = mapper.writeValueAsString(body);
			}
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		if (msgBody == null) {
			msgBody = "";
		}

		String timestamp = formatter.format(ZonedDateTime.now());
		String signature = generator.generateSignature(method, (url + localVarPath.substring(1)).toUpperCase(),
				sensorId.replace("-", ""), thumbprint, msgBody, toID, timestamp, configuration.getPfx(),
				configuration.getPw());

		HashMap<String, String> headers = new HashMap<>();
		headers.put("TOID", toID);
		headers.put("Client-Signature", signature);
		headers.put("CertifacteThumbprint", thumbprint);
		headers.put("MPID", sensorId);
		headers.put("DEST", "TO");
		headers.put("timestamp", timestamp);

		try {
			log.info("Request body ({}) : {}", method, msgBody);

			String json = method.equals("POST")
					? clientUtil.post(router, acceptLanguage, "1.1.0", localVarPath, configuration.getMaasId(), headers,
							msgBody, String.class)
					: clientUtil.get(router, acceptLanguage, "1.1.0", localVarPath, configuration.getMaasId(),
							String.class, headers);

			log.info("Response: {}", json);

			ObjectMapper m = new ObjectMapper();
			if (json.startsWith("{")) {
				Map map = m.readValue(json, HashMap.class);
				Object object = map.get("validUntil");
				if (object != null) {
					String validUntil = object.toString();
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
					json = json.replace(validUntil, simpleDateFormat.format(new Date()));
				}
			}

			return mapper.readValue(json, valueType);
		} catch (ApiException e) {
			e.printStackTrace();
		}
		return null;
	}
}
