/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author thiag
 */
public class GerarId {

    public static int GerarIdArquivo(String caminho) throws FileNotFoundException, IOException {
        try (BufferedReader arquivo = new BufferedReader(new FileReader(caminho))) {
            String linha;
            String ultima = null;

            if (arquivo != null) {
                while ((linha = arquivo.readLine()) != null) {
                    ultima = linha;
                }
                if (ultima != null) {

                    int id = Integer.parseInt(ultima.split(";")[0]);

                    return id + 1;
                }
            }

            return 0;
        }
    }
}
