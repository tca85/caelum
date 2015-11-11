package br.com.caelum.banco;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class TestaEntrada {
	public static void main(String[] args) throws IOException {

		try {
			InputStream inputStream = new FileInputStream("testa-io/arquivo.txt");
			OutputStream outputStream = new FileOutputStream("saida.txt");

			OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
			BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
			Scanner entrada = new Scanner(inputStream);

			while (entrada.hasNextLine()) {
				String linha = entrada.nextLine();
				bufferedWriter.write(linha);
				bufferedWriter.newLine();
			}
			
			entrada.close();
			bufferedWriter.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}