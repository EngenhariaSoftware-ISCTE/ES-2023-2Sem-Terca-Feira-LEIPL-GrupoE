package pt.iscte_iul.ista.ES_2023_2Sem_Terca_Feira_LEIPL_GrupoE;

import java.net.URL;
import java.net.URLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LeitorHorarioHTTP {

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
        return content.toString();
    }

    private static String converterWebcalHttp(String urlString) {
        if (urlString.startsWith("webcal://")) {
            return "https://" + urlString.substring(9);
        }
        return urlString;
    }

}
