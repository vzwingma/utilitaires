/**
 * 
 */
package com.terrier.boxcryptor.filters;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Filter permettant de remonter les r�pertoires ou les fichiers
 * @author vzwingma
 *
 */
public class FileFilter implements Filter<Path> {

	
	/* (non-Javadoc)
	 * @see java.nio.file.DirectoryStream.Filter#accept(java.lang.Object)
	 */
	@Override
	public boolean accept(Path entry) throws IOException {
		return !Files.isDirectory(entry);
	}

}