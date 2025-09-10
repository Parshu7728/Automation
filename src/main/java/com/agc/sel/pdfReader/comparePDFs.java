package com.agc.sel.pdfReader;//DEPS com.github.difflib:java-diff-utils:4.11
//DEPS org.apache.pdfbox:pdfbox:2.0.30

import java.io.*;
import java.nio.file.*;
import java.util.*;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import com.github.difflib.DiffUtils;
import com.github.difflib.patch.Patch;



public class comparePDFs {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Usage: jbang comparePDFs.java baseline.pdf target.pdf output.html");
            return;
        }

        var baselinePDF = args[0];
        var targetPDF = args[1];
        var outputHTML = args[2];

        var text1 = extractText(baselinePDF);
        var text2 = extractText(targetPDF);

        var original = List.of(text1.split("\\R"));
        var revised = List.of(text2.split("\\R"));

        var patch = DiffUtils.diff(original, revised);

        try (var writer = Files.newBufferedWriter(Paths.get(outputHTML))) {
            writer.write("<html><body><pre style='font-family:monospace;'>\n");

            for (var delta : patch.getDeltas()) {
                for (var line : delta.getSource().getLines()) {
                    writer.write("<span style='background-color:#ffcccc; color:red;'>- " + escape(line) + "</span>\n");
                }
                for (var line : delta.getTarget().getLines()) {
                    writer.write("<span style='background-color:#ccffcc; color:green;'>+ " + escape(line) + "</span>\n");
                }
                writer.write("\n");
            }

            writer.write("</pre></body></html>");
        }

        System.out.println("✅ HTML diff generated at: " + outputHTML);
    }

    static String extractText(String pdfPath) throws IOException {
        try (var doc = PDDocument.load(new File(pdfPath))) {
            var stripper = new PDFTextStripper();
            return stripper.getText(doc);
        }
    }

    static String escape(String text) {
        return text.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
    }
}
