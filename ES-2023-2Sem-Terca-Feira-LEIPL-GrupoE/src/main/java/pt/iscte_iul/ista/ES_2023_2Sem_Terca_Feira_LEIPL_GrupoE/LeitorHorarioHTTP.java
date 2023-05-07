package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Luis Rosa Classe LeitorHorarioHTTP que lê o conteúdo de um URL do
 *         tipo "webcal".
 */
public class LeitorHorarioHTTP {

    /**
     * Lê o conteúdo de um URL e retorna o conteúdo como uma String.
     *
     * @param urlString URL do tipo "webcal" para ler o conteúdo
     * @return String com o conteúdo do URL
     * @throws Exception se ocorrer algum erro ao ler o URL
     */
    public static String lerConteudoDeURL(String urlString) throws Exception {
	urlString = converterWebcalHttp(urlString);
	URL url = new URL(urlString);
	URLConnection connection = url.openConnection();
	BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	String inputLine;
	StringBuilder content = new StringBuilder();
	while ((inputLine = in.readLine()) != null) {
	    content.append(inputLine).append("\n");
	}
	in.close();
	return content.toString().replaceAll("(?i)\\\\n", " ").replaceAll("(\r\n|\r|\n)", "\r\n");
    }

    /**
     * Converte um URL de "webcal://" para "https://".
     *
     * @param urlString URL do tipo "webcal" a ser convertido
     * @return URL convertido para o tipo "https"
     */
    public static String converterWebcalHttp(String urlString) {
	if (urlString.startsWith("webcal://")) {
	    return "https://" + urlString.substring(9);
	}
	return urlString;
    }

}
