package br.com.agtec.app.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ContadorArquivos {

	public static final List<String> extensoes = List.of(".java"); 
	
	public static int quantidadeArquivosComExtensao = 0;
	
	public static int quantidadeLinhasTotal = 0;
	
	public static StringBuilder resultado = new StringBuilder();
	
	public static void contarLinhasArquivo(Path arquivo) throws IOException {
		
		
		resultado.append(" -> " 
						+ arquivo.getFileName() 
						+ " possui " 
						+ Files.readAllLines(arquivo)
						.stream()
						.filter( e -> !e.trim().isEmpty())
						.collect(Collectors.toList())
						.size() + " linhas \n");
		
		quantidadeLinhasTotal += Files.readAllLines(arquivo)
								.stream()
								.filter( e -> !e.trim().isEmpty())
								.collect(Collectors.toList())
								.size();
	}
}
