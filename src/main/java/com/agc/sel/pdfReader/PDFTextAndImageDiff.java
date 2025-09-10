package com.agc.sel.pdfReader;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class PDFTextAndImageDiff {

    public static void main(String[] args) {
        String pdfPath1 = "E:/AutomationAGC/Automation/src/main/resources/Expected-PDF/BP_AnsellPTD.pdf";
        String pdfPath2 = "E:\\AutomationAGC\\Automation\\Pdfdownload\\Ansell_OrgNBUlXGLv (1).pdf";

        try {
            PDDocument doc1 = PDDocument.load(new File(pdfPath1));
            PDDocument doc2 = PDDocument.load(new File(pdfPath2));

            // Extract and compare text
            PDFTextStripper stripper = new PDFTextStripper();
            String text1 = stripper.getText(doc1);
            String text2 = stripper.getText(doc2);
            System.out.println("📝 TEXT DIFFERENCE:");
            printColoredDifferences(text1, text2);

            // Compare first page images
            PDFRenderer renderer1 = new PDFRenderer(doc1);
            PDFRenderer renderer2 = new PDFRenderer(doc2);

            BufferedImage img1 = renderer1.renderImageWithDPI(0, 100);
            BufferedImage img2 = renderer2.renderImageWithDPI(0, 100);

            System.out.println("\n🖼️ IMAGE COMPARISON RESULT:");
            if (!compareImagesAndSaveDiff(img1, img2, "C:/Users/ParashuramRY/Downloads/image_diff_output.png")) {
                System.out.println("❌ Images are different! See image_diff_output.png");
            } else {
                System.out.println("✅ Images are identical.");
            }

            doc1.close();
            doc2.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printColoredDifferences(String text1, String text2) {
        String[] lines1 = text1.split("\n");
        String[] lines2 = text2.split("\n");

        int maxLines = Math.max(lines1.length, lines2.length);
        for (int i = 0; i < maxLines; i++) {
            String line1 = i < lines1.length ? lines1[i].trim() : "";
            String line2 = i < lines2.length ? lines2[i].trim() : "";

            if (!line1.equals(line2)) {
                System.out.println("Line " + (i + 1) + ":");
                System.out.println("PDF1: \u001B[32m" + line1 + "\u001B[0m"); // Red
                System.out.println("PDF2: \u001B[31m" + line2 + "\u001B[0m"); // Green
                System.out.println();
            }
        }
    }

    public static boolean compareImagesAndSaveDiff(BufferedImage img1, BufferedImage img2, String outputPath) {
        if (img1.getWidth() != img2.getWidth() || img1.getHeight() != img2.getHeight()) {
            System.out.println("🛑 Image sizes are different.");
            return false;
        }

        int width = img1.getWidth();
        int height = img1.getHeight();
        boolean imagesAreSame = true;

        BufferedImage diffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = diffImg.createGraphics();
        g.drawImage(img1, 0, 0, null);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int rgb1 = img1.getRGB(x, y);
                int rgb2 = img2.getRGB(x, y);
                if (rgb1 != rgb2) {
                    imagesAreSame = false;
                    diffImg.setRGB(x, y, Color.RED.getRGB());  // Highlight differences
                }
            }
        }

        if (!imagesAreSame) {
            try {
                ImageIO.write(diffImg, "png", new File(outputPath));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return imagesAreSame;
    }
}
