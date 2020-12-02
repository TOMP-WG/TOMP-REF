package org.tomp.read.generic;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;
import org.tomp.ready.generic.TestCaseInterface;
import org.tomp.ready.generic.TestProcessor;
import org.tomp.ready.testcases.operator.information.RegionsValidation;
import org.tomp.ready.utils.ApiClient;
import org.tomp.ready.utils.ApiException;
import org.tomp.ready.validation.ValidationResult;

@RunWith(SpringRunner.class)
public class TestTestProcessor {

	@Spy
	ApiClient client = new ApiClient();

	@InjectMocks
	TestProcessor processor = new TestProcessor();

	@Test
	public void testFirstClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException, ApiException {
		List<ValidationResult> results = processor.validateProcess("0.9.0", "1", "https://tomp.dat.nl/taxi");

		Comparator<? super ValidationResult> c = (o1, o2) -> {
			boolean ok1 = o1.isOk();
			boolean ok2 = o2.isOk();
			return ok1 == ok2 ? 0 : ok1 && !ok2 ? 1 : -1;
		};
		results.sort(c);
		String previous = "";
		for (ValidationResult result : results) {
			String header = result.getHttpMethod() + " " + result.getEndpoint();
			if (!previous.equals(header)) {
				System.out.println(header);
				previous = header;
			}
			System.out.println(result);
		}

		assertEquals(0, results.size());
	}

	@Test
	public void testRegions() throws ApiException {
		TestCaseInterface bean = new RegionsValidation(client, "https://tomp.dat.nl/taxi", "0.9.0", "1");
		Collection<ValidationResult> results = processor.doTest(bean);
		assertEquals(1, results.size());
	}
}
