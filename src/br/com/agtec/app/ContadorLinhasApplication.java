package br.com.agtec.app;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import br.com.agtec.app.impl.FileVisitorImpl;
import br.com.agtec.app.util.ContadorArquivos;

public class ContadorLinhasApplication {

	public static void main(String[] args) throws IOException {
	
		Path path = Paths.get(System.getProperty("user.dir"));
		Path pathWrite = Paths.get(System.getProperty("user.dir") + "Result.txt");

		Files.walkFileTree(path, new FileVisitorImpl());
		BufferedWriter writer = null;
		try {
			writer = Files.newBufferedWriter(pathWrite, StandardOpenOption.CREATE);
			writer.append(ContadorArquivos.resultado);
			writer.newLine();
			writer.newLine();
			writer.append("Total de linhas: " + ContadorArquivos.quantidadeLinhasTotal);
			writer.flush();
		}
		catch(Exception e){ e.printStackTrace();}
		finally {
			if(writer != null)
				writer.close();
		}

		
	}


}
