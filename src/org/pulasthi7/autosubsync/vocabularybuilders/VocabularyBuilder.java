package org.pulasthi7.autosubsync.vocabularybuilders;

import org.pulasthi7.autosubsync.AutoSubSyncException;

public interface VocabularyBuilder {
	/**
	 * Prepare the subtitle file to generate the vocabulary model by extracting it's words
	 * The implementation varies according to the subtitle format
	 * @param subtitleFilePath Path to Subtitle File
	 * @param destinationFilePath Path to save resulting vocabulary file
	 * @throws AutoSubSyncException If something goes wrong
	 */
	void buildVocabulary(String subtitleFilePath, String destinationFilePath) throws AutoSubSyncException;
}
