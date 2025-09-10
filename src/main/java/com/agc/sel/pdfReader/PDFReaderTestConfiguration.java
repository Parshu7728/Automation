package com.agc.sel.pdfReader;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 * The PDFReaderTestConfiguration class provides functionality to read and
 * extract text from PDF documents using the Apache PDFBox library. It includes
 * methods to load a PDF from a URL and retrieve its text content.
 */
public class PDFReaderTestConfiguration {
	// Object representing the loaded PDF document
	PDDocument pdfdocument;

	// Object used to extract text from the PDF document
	PDFTextStripper pdfStiper;

	/**
	 * Loads a PDF document from the specified URL.
	 *
	 * @param URL The URL of the PDF document to be loaded.
	 * @throws IOException          If an I/O error occurs while loading the PDF.
	 * @throws InterruptedException If the thread is interrupted during execution.
	 */
	public void pefReder(String URL) throws IOException, InterruptedException {
		// Create a URL object for the specified PDF URL
		URL pdfUrl = new URL(URL);

		// Open a stream to the PDF URL
		InputStream ip = pdfUrl.openStream();

		// Wrap the input stream in a BufferedInputStream for efficient reading
		BufferedInputStream bf = new BufferedInputStream(ip);

		// Load the PDF document from the buffered input stream
		pdfdocument = PDDocument.load(bf);
	}

	/**
	 * Extracts and returns the text content of the loaded PDF document.
	 *
	 * @return The text content of the PDF document.
	 * @throws IOException If an I/O error occurs while reading the PDF.
	 */
	public String ReadPdf() throws IOException {
		// Get the number of pages in the PDF document
		int pagecount = pdfdocument.getNumberOfPages();
		System.out.println(pagecount);

		// Initialize the PDFTextStripper for extracting text
		pdfStiper = new PDFTextStripper();

		// Extract the text content from the PDF document
		String pdfText = pdfStiper.getText(pdfdocument);

		// Print the extracted text to the console
		System.err.println(pdfText);

		// Close the PDF document to release resources
		pdfdocument.close();

		// Return the extracted text
		return pdfText;
	}

	/**
	 * Closes the resources used by the PDFReaderTestConfiguration, including
	 * the loaded PDF document.
	 */
	public void closeResources() {
		try {
			if (pdfdocument != null) {
				pdfdocument.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
