package io;

import static util.BibliotecaMetodos.isStringValida;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class ProcessarArquivoSaidaJobConferenciaExecucoesOrcamentarias {
	
	public static void processar( InputStream pIs ) {
		BufferedReader bf = 
			new BufferedReader(
				new InputStreamReader(pIs
			)
		);
		
		
		try {
			String linha = "";
			for ( int indice = 0; (linha = bf.readLine()) != null; indice = indice + 1 ) {
				System.out.println(linha);
				if ( indice >=4 ) {
					String[] palavras = linha.split(" ");
					
					int tipoValorDado = 0;
					for ( int indicePalavra = 0; indicePalavra < palavras.length; indicePalavra = indicePalavra + 1 ) {
						String[] subPalavras = palavras[indicePalavra].split("\t");
						
						for ( int indiceSubPalavra = 0; indiceSubPalavra < subPalavras.length; indiceSubPalavra = indiceSubPalavra + 1 ) {
							if ( isStringValida(subPalavras[indiceSubPalavra]) ) {
								System.out.println(subPalavras[indiceSubPalavra]);
								tipoValorDado = tipoValorDado + 1;
							}
						}
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}