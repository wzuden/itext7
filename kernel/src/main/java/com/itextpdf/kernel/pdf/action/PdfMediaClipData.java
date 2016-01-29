package com.itextpdf.kernel.pdf.action;

import com.itextpdf.kernel.pdf.PdfDictionary;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfName;
import com.itextpdf.kernel.pdf.PdfObjectWrapper;
import com.itextpdf.kernel.pdf.PdfString;
import com.itextpdf.kernel.pdf.filespec.PdfFileSpec;

public class PdfMediaClipData extends PdfObjectWrapper<PdfDictionary> {

    private static final PdfString TEMPACCESS = new PdfString("TEMPACCESS");

    public PdfMediaClipData(PdfDictionary pdfObject, PdfDocument pdfDocument) {
        super(pdfObject);
        makeIndirect(pdfDocument);
    }

    public PdfMediaClipData(PdfDocument pdfDocument, String file, PdfFileSpec fs, String mimeType) {
        this(new PdfDictionary(), pdfDocument);
        PdfDictionary dic = new PdfDictionary().makeIndirect(pdfDocument);
        dic.put(PdfName.TF, TEMPACCESS);
        put(PdfName.Type, PdfName.MediaClip).put(PdfName.S, PdfName.MCD).
                put(PdfName.N, new PdfString(String.format("Media clip for %s", file))).
                put(PdfName.CT, new PdfString(mimeType)).
                put(PdfName.P, dic).
                put(PdfName.D, fs.getPdfObject());
    }

}