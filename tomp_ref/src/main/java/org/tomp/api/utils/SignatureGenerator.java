package org.tomp.api.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Signature;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Base64;
import java.util.Enumeration;

public class SignatureGenerator {

	public String generateSignature(String httpMethod, String url, String sensorID, String thumbprint, String msgBody,
			String toID, String timestamp, String pfx, String pw)
			throws FileNotFoundException, KeyStoreException, CertificateException, UnrecoverableKeyException,
			UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
		KeyStore ks = loadKeyStore(pfx, pw);
		Key maasHubKey = null;
		String alias = "";
		try {
			Enumeration<String> enumeration = ks.aliases();
			while (enumeration.hasMoreElements()) {
				alias = enumeration.nextElement();
				System.out.println("alias name: " + alias);
				break;
			}

			maasHubKey = ks.getKey(alias, pw.toCharArray());
		} catch (KeyStoreException | NoSuchAlgorithmException | UnrecoverableKeyException e) {
			throw new UnrecoverableKeyException("Error loading key");
		}

		thumbprint = "";
		String toEncode = httpMethod + "|" + url.toUpperCase() + "|" + sensorID + "|" + toID + "|TO|" + timestamp + "|"
				+ thumbprint.toUpperCase() + "|" + msgBody;
		System.out.println(toEncode);

		byte[] byteConcString = toEncode.getBytes("UTF8");
		Signature sig = Signature.getInstance("SHA256withRSA");
		sig.initSign((PrivateKey) maasHubKey);
		sig.update(byteConcString);
		byte[] sigInBytes = sig.sign();

		return Base64.getEncoder().encodeToString(sigInBytes);
	}

	private KeyStore loadKeyStore(String pfx, String pw)
			throws FileNotFoundException, KeyStoreException, CertificateException {
		KeyStore keyStore = KeyStore.getInstance("PKCS12");
		// String pfx =
		// getClass().getClassLoader().getResource("reference_environment.pfx").getFile();
		File ksFile = new File(pfx);
		InputStream keyStoreData = new FileInputStream(ksFile);

		try {
			keyStore.load(keyStoreData, pw.toCharArray());
		} catch (IOException | NoSuchAlgorithmException | CertificateException e) {
			throw new CertificateException("Error loading certificate");
		}

		return keyStore;
	}
}
