import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

    // fazer uma conexao HTTP e buscar os top 250 filmes

        String url = "https://imdb-api.com/en/API/Top250Movies/k_jl3zdoft";
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
            String urlImagem = filme.get("image");
            String titulo = filme.get("title");

           InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            var geradora = new geradoraFigurinhas();
            geradora.cria(inputStream, nomeArquivo);

            System.out.println(titulo);
            System.out.println();
        }
    }

}
