package com.itextpdf.core.parser;

import com.itextpdf.basics.geom.Rectangle;
import com.itextpdf.core.pdf.PdfDocument;
import com.itextpdf.core.pdf.PdfReader;
import com.itextpdf.test.ExtendedITextTest;

import org.junit.Assert;
import org.junit.Test;

public class TextMarginFinderTest extends ExtendedITextTest {

    private static final String sourceFolder = "./src/test/resources/com/itextpdf/core/parser/TextMarginFinderTest/";

    @Test
    public void test() throws Exception {
        TextMarginFinder finder = new TextMarginFinder();
        PdfDocument pdfDocument = new PdfDocument(new PdfReader(sourceFolder + "in.pdf"));
        new PdfContentStreamProcessor(finder).processPageContent(pdfDocument.getPage(1));

        Rectangle textRect = finder.getTextRectangle();
        Assert.assertEquals(1.42f * 72f, textRect.getX(), 0.01f);
        Assert.assertEquals(7.42f * 72f, textRect.getX() + textRect.getWidth(), 0.01f);
        Assert.assertEquals(2.42f * 72f, textRect.getY(), 0.01f);
        Assert.assertEquals(10.42f * 72f, textRect.getY() + textRect.getHeight(), 0.01f);
    }
}