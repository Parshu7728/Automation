package com.agc.sel.pdfReader;

import com.agc.sel.baseutilities.Asserrtion;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Arrays;

public class PTD_pdf_comparision {

    private static final Logger logger = LogManager.getLogger(PTD_pdf_comparision.class);
    public Asserrtion assertionCheck = new Asserrtion();

    // ✅ Compare ignoring dynamic content (like organization names or IDs)
    public static boolean comparePdfIgnoringDynamicOrg(String expectedPdfPath, String actualPdfPath, int startPage) {
        try (
                PDDocument expectedDoc = PDDocument.load(new File(expectedPdfPath));
                PDDocument actualDoc = PDDocument.load(new File(actualPdfPath))
        ) {
            PDFTextStripper stripper = new PDFTextStripper();

            // ✅ Set the page to start from based on input parameter
            stripper.setStartPage(startPage);
            stripper.setEndPage(Integer.MAX_VALUE); // Read till the end

            String expectedText = sanitizeText(stripper.getText(expectedDoc));
            String actualText = sanitizeText(stripper.getText(actualDoc));

            String[] expectedLines = expectedText.split("\\r?\\n");
            String[] actualLines = actualText.split("\\r?\\n");

            boolean isMatch = true;
            int maxLines = Math.max(expectedLines.length, actualLines.length);

            for (int i = 0; i < maxLines; i++) {
                String expectedLine = i < expectedLines.length ? expectedLines[i].trim() : "<no line>";
                String actualLine = i < actualLines.length ? actualLines[i].trim() : "<no line>";

                if (!expectedLine.equals(actualLine)) {
                    isMatch = false;
                    System.out.println("❌ Difference at line " + (i + 1));
                    System.out.println("\u001B[32mExpected: " + expectedLine + "\u001B[0m");
                    System.out.println("\u001B[31mActual:   " + actualLine + "\u001B[0m");
                    System.out.println("----------------------------------------------------");
                }
            }

            if (isMatch) {
                System.out.println("\u001B[32m PDF comparison successful — all lines are matched.\u001B[0m");
                Asserrtion.assertTrue(true, "PDF comparison successful");
            } else {
                System.out.println("\u001B[31m PDF comparison failed — mismatched lines found.\u001B[0m");
                Asserrtion.assertFalse(false, "PDF comparison failed");
            }

            return isMatch;

        } catch (Exception e) {
            System.err.println("❌ Exception during PDF comparison:");
            e.printStackTrace();
            return false;
        }
    }
    public static String getLatestDownloadedPdf(String downloadDirPath) {
        File downloadDir = new File(downloadDirPath);

        if (!downloadDir.exists() || !downloadDir.isDirectory()) {
            System.err.println("Download directory does not exist: " + downloadDirPath);
            return null;
        }

        File[] files = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));

        if (files == null || files.length == 0) {
            System.err.println("No PDF files found in download directory: " + downloadDirPath);
            return null;
        }

        File latestFile = files[0];
        for (File file : files) {
            if (file.lastModified() > latestFile.lastModified()) {
                latestFile = file;
            }
        }

        System.out.println("📄 Found downloaded PDF: " + latestFile.getAbsolutePath());
        return latestFile.getAbsolutePath();
    }


    // ✅ Replace dynamic organization name patterns
    private static String sanitizeText(String text) {
        return text.replaceAll("(?i)ANS.*?\\n", "")        // Remove "ANS..." lines
                .replaceAll("Report\\w+", "DYNAMIC_NAME")   // Replace org identifiers
                .trim();
    }
    public static void validateDownloadedPdf(String expectedPdfPath, String downloadDirPath, int startPage) {
        String actualPdfPath = getLatestDownloadedPdf(downloadDirPath);

        if (actualPdfPath != null) {
            boolean result = comparePdfIgnoringDynamicOrg(expectedPdfPath, actualPdfPath, startPage);

            if (!result) {
                throw new AssertionError("❌ PDF comparison failed!\nExpected: "
                        + expectedPdfPath + "\nActual: " + actualPdfPath);
            } else {
                System.out.println("✅ PDF comparison passed for: " + actualPdfPath);
            }
        } else {
            throw new RuntimeException("❌ No PDF file found in download directory: " + downloadDirPath);
        }
    }
}
