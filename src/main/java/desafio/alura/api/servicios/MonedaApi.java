package desafio.alura.api.servicios;

import io.github.cdimascio.dotenv.Dotenv;


public class MonedaApi {
    private final String API_URL;
    private final String API_KEY;

    public MonedaApi(){
        Dotenv dotenv = Dotenv.load();
        this.API_KEY = dotenv.get("API_KEY");
        this.API_URL = dotenv.get("API_URL");
    }
}
