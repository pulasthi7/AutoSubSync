package org.pulasthi7.autosubsync.vocabularybuilders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.pulasthi7.autosubsync.AutoSubSyncException;

public class SRTVocabularyBuilder implements VocabularyBuilder {

	@Override
	public void buildVocabulary(String subtitleFilePath,
			String destinationFilePath) throws AutoSubSyncException {
		File srtFile;
		try {
			srtFile = new File(subtitleFilePath);
			Scanner reader = new Scanner(srtFile);
			File vocabFile = new File(destinationFilePath);
			if (!vocabFile.createNewFile()) {
				throw new AutoSubSyncException("Destination File "
						+ destinationFilePath + " already exists");
			}
			PrintWriter writer = new PrintWriter(vocabFile);
			while (reader.hasNextLine()) {
				StringBuilder speechPart = new StringBuilder();
				String lineRead = reader.nextLine(); // ignored : the
														// incrementing
														// identifier
				lineRead = reader.nextLine(); // ignored : the timestamp
				while (!(lineRead = reader.nextLine()).equals("")) {
					lineRead = lineRead.trim();
					if (lineRead.startsWith("(") && lineRead.endsWith(")")) {
						continue;
					}
					if (lineRead.startsWith("[") && lineRead.endsWith("]")) {
						continue;
					}
					// TODO Check brackets in multiple lines
					speechPart.append(lineRead);
				}
				// Get the words
				String[] words = getValidWords(speechPart.toString());
				for (String word : words) {
					writer.println(word);
				}
			}
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			throw new AutoSubSyncException(e.getMessage(), e);
		} catch (IOException e) {
			throw new AutoSubSyncException(e.getMessage(), e);
		}
	}

	protected String[] getValidWords(String string) {
		String[] words = string.toString().replaceAll("[^a-zA-Z0-9']", " ")
				.split("\\s+");
		for (int i = 0; i < words.length; i++) {
			if (words[i].endsWith("'s")) {
				words[i] = words[i].substring(0, words[i].length() - 2);
			}
		}
		return words;
	}

}
