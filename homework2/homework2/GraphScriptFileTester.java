package homework2;

import static org.junit.Assert.*;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * This class, along with a complete TestDriver implementation, can be used to
 * test the implementations of Graph and the path finding algorithm using the
 * script file format described in the assignment. It will find all script files
 * in the same directory as this class file (with names ending in .test)
 * and execute them.
 */
@RunWith(Parameterized.class)
public class GraphScriptFileTester {

	private final java.nio.file.Path testFile;

	/**
	 * Creates a new ScriptFileTests case, which runs the given test file.
	 * @param testFile - test file to run
	 */
	public GraphScriptFileTester(java.nio.file.Path testFile) {
		this.testFile = testFile;
	}

	/**
	 * Builds parameterized tests for all script files in the directory.
	 * @return Input arguments for the class constructor
	 */
	@Parameters
	public static Collection<Object[]> getFiles() {
		try {
			java.nio.file.Path curDirectory =
					Paths.get(GraphScriptFileTester.class.getResource(
							  "GraphScriptFileTester.class").toURI()).getParent();
		Collection<Object[]> params = new ArrayList<>();
		DirectoryStream<java.nio.file.Path> stream =
				Files.newDirectoryStream(curDirectory, "*.test");
			for (java.nio.file.Path file: stream) {
				Object[] arr = new Object[] { file };
				params.add(arr);
			}
			return params;
		} catch (IOException | URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the contents of a file.
	 * @requires the specified file exists
	 * @returns the contents of that file
	 * @throw FileNotFoundException - if an attempt to open the file has failed
	 * @throw IOException - if any other I/O exception has occurred
	 */
	private String fileContents(java.nio.file.Path file) throws IOException {
		if (file == null)
			throw new RuntimeException("No file specified");

		StringBuilder result = new StringBuilder();
		char[] data = new char[4096]; // a reasonable block size

		try (Reader reader = new FileReader(file.toFile())) {
			int charsRead;
			while ((charsRead = reader.read(data)) != -1)
				result.append(data, 0, charsRead);
		}
		
		return result.toString();
	}

	/**
	 * Runs the test in test file, and output its results.
	 * @requires there exists a valid test file indicated by testFile
	 * @effects runs the test in test file, and output its results to a file in
	 *          the same directory with name filename+".actual"; if that file
	 *          already exists, it will be overwritten.
	 * @returns the contents of the output file
	 * @throw IOException - on any I/O exception
	 */
	private String runScriptFile() throws IOException {
		if (testFile == null) {
			throw new RuntimeException("No file specified");
		}

		java.nio.file.Path actual = fileWithSuffix("actual");

		try (Reader reader = new FileReader(testFile.toFile());
			 Writer writer = new FileWriter(actual.toFile())) {
			
			TestDriver td = new TestDriver(reader, writer);
			td.runTests();

			return fileContents(actual);
		}
	}

	/**
	 * Returns a File with the same name as testFile, except that the test
	 * suffix is replaced by the given suffix.
	 * 
	 * @param newSuffix - new suffix to add
	 * @return a File with the same name as testFile, except that the test
	 *         suffix is replaced by the given suffix
	 */
	private java.nio.file.Path fileWithSuffix(String newSuffix) {
		String driverName = testFile.toString();
		String baseName = driverName.substring(0,
				driverName.length() - "test".length());
				
		return Paths.get(baseName + newSuffix);
	}

	/**
	 * The only test that is run: run a script file and test its output.
	 * @throws IOException- on any I/O exception
	 */
	@Test
	public void testWithScriptFile() throws IOException {
		java.nio.file.Path expected = fileWithSuffix("expected");

		assertEquals(testFile.toString(), fileContents(expected), runScriptFile());
	}

}
