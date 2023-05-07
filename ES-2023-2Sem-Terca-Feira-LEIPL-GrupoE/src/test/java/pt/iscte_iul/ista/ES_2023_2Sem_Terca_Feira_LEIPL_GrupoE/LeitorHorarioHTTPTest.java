package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LeitorHorarioHTTPTest {

    @Test
    public void testConverterWebcalHttp() {
	String webcalUrl = "webcal://example.com/test.ics";
	String expectedHttpsUrl = "https://example.com/test.ics";

	String convertedUrl = LeitorHorarioHTTP.converterWebcalHttp(webcalUrl);

	assertEquals(expectedHttpsUrl, convertedUrl, "A URL convertida deve ser igual à esperada");
    }

    @Test
    public void testConverterWebcalHttpNoConversion() {
	String httpsUrl = "https://example.com/test.ics";

	String convertedUrl = LeitorHorarioHTTP.converterWebcalHttp(httpsUrl);

	assertEquals(httpsUrl, convertedUrl, "A URL convertida deve ser igual à URL original");
    }
}