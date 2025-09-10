package com.agc.sel.pdfReader;//DEPS org.apache.pdfbox:pdfbox:2.0.30
//DEPS com.github.romankh3:image-comparison:4.4.0

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;
import com.github.romankh3.image.comparison.ImageComparison;
import com.github.romankh3.image.comparison.model.ImageComparisonResult;
import com.github.romankh3.image.comparison.model.ImageComparisonState;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class comparePDFImages {
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.out.println("Usage: jbang comparePDFImages.java baseline.pdf target.pdf outputImage.png");
            return;
        }

        String baselinePDF = args[0];
        String targetPDF = args[1];
        String outputImage = args[2];

        BufferedImage image1 = renderFirstPage(baselinePDF);
        BufferedImage image2 = renderFirstPage(targetPDF);

        ImageComparison imageComparison = new ImageComparison(image1, image2);
        imageComparison.setDifferenceRectangleColor(java.awt.Color.RED);
        imageComparison.setDrawExcludedRectangles(true);

        ImageComparisonResult result = imageComparison.compareImages();

        ImageIO.write(result.getResult(), "png", new File(outputImage));
        System.out.println("✅ Visual diff image saved to: " + outputImage);

        if (result.getImageComparisonState() != ImageComparisonState.MATCH) {
            System.out.println("❗ PDF images are different.");
        } else {
            System.out.println("✅ PDF images look the same.");
        }
    }

    static BufferedImage renderFirstPage(String pdfPath) throws Exception {
        PDDocument doc = PDDocument.load(new File(pdfPath));
        PDFRenderer renderer = new PDFRenderer(doc);
        BufferedImage image = renderer.renderImageWithDPI(0, 150); // First page, 150 DPI
        doc.close();
        return image;
    }
}
