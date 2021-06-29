/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agm;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 *
 * @author 2018.1.08.025
 */
public class LeituraArquivo {

    private static double[][] matrizPontos;
    private static double[][] matrizDistancias;
    private static String[][] matrizOperacoes;

    public static String[][] getMatrizOp() {
        if (matrizOperacoes == null) {
            lerOperacoes();
        }
        return matrizOperacoes;
    }

    private static LeituraArquivo lA = new LeituraArquivo();

    private LeituraArquivo() {
    }

    public static void lerArquivo() {
        int i, j;
        try {
            File arquivo = new File("/home/2018.1.08.025/Desktop/pontos.agm1");
            Scanner sc = new Scanner(arquivo);

            matrizPontos = new double[58][2];

            for (i = 0; i < matrizPontos.length; i++) {
                for (j = 0; j < matrizPontos[i].length; j++) {
                    matrizPontos[i][j] = sc.nextDouble();

                }

            }

            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void calcularDistancia() {
        int i, j;
        double coordx, coordy;
        matrizDistancias = new double[58][58];
        for (i = 0; i < matrizDistancias.length; i++) {
            for (j = i + 1; j < matrizDistancias.length; j++) {
                coordx = matrizPontos[j][0] - matrizPontos[i][0];
                coordy = matrizPontos[j][1] - matrizPontos[i][1];
                matrizDistancias[i][j] = Math.sqrt(Math.pow(coordx, 2) + Math.pow(coordy, 2));
                matrizDistancias[j][i] = matrizDistancias[i][j];
            }
        }
    }

    private static void lerOperacoes() {
       String arquivoCSV = "/home/2018.1.08.025/Desktop/operacoes.agm1";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ";";
		try {
			br = new BufferedReader(new FileReader(arquivoCSV));
			int i = 0;
			matrizOperacoes = new String[3192][3];
			while ((linha = br.readLine()) != null && i < matrizOperacoes.length) {

				String[] texto;
				texto = linha.split(csvDivisor);
				for (int j = 0; j < texto.length && j < matrizOperacoes[i].length; j++) {
					matrizOperacoes[i][j] = texto[j];
				}
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}


    public static LeituraArquivo getlA() {
        return lA;
    }

    /**
     * @return the matrizPontos
     */
    public static double[][] getMatrizPontos() {
        if (matrizPontos == null) {
            lerArquivo();
        }
        return matrizPontos;
    }

    /**
     * @return the matrizDistancias
     */
    public static double[][] getMatrizDistancias() {
        if (matrizPontos == null || matrizDistancias == null) {
            lerArquivo();
            calcularDistancia();
        }
        return matrizDistancias;
    }

}