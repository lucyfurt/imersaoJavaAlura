import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.awt.Font;
import java.io.InputStream;


public class geradoraFigurinhas {
public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
//leitura da imagem
   // InputStream inputStream = new FileInputStream(new File("entrada/filmes.jpg"));
//    InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMjIxNDU2Njk0OV5BMl5BanBnXkFtZTgwODc3Njc3NjE@.jpg").openStream();

    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    //cria nova imagem em memoria com transparencia e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = altura + 200;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
    //copiar a imagem original pra novo imagem (em memoria)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);
    //configurar fonte
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setFont(fonte);
    graphics.setColor(Color.red);

    //escrever uma frase na nova imagem
    graphics.drawString("TOPZERA",100,novaAltura - 100);
    //escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));

}



}
