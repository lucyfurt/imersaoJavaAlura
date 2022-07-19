import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

    // fazer uma conexao HTTP e buscar os top 250 filmes

        String url = "https://alura-imdb-api.herokuapp.com/movies";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        System.out.println(body);

        //extrair so os dados que interessam (titulo, poster, clasificacao)
        var parser = new JsonParser();
        List<Map<String, String>> listDeFilmes = parser.parse(body);

        //exibir e manipular os dados
        for (Map<String, String> filme : listDeFilmes
             ) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }

}
