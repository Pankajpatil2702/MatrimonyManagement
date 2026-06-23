package com.example.MatrimonyManagement.security;

import java.io.File;
import java.io.InputStream;

import org.springframework.stereotype.Service;

import com.example.MatrimonyManagement.entities.CustomerProfile;
import com.itextpdf.io.font.PdfEncodings;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.io.source.ByteArrayOutputStream;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;  
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.geom.Rectangle;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfPage;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

@Service
public class PdfGeneratorutil {

	private static final DeviceRgb PAGE_BG = new DeviceRgb(255, 252, 245);
	private static final DeviceRgb BROWN = new DeviceRgb(139, 69, 19);
	private static final DeviceRgb DARK_BROWN = new DeviceRgb(101, 40, 5);
	private static final DeviceRgb TEXT_DARK = new DeviceRgb(50, 30, 10);
	private static final DeviceRgb BORDER_OUTER = new DeviceRgb(160, 82, 45);
	private static final DeviceRgb PHOTO_BORDER = new DeviceRgb(160, 82, 45);

	public byte[] generateBiodata(CustomerProfile customer) throws Exception {

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		PdfWriter writer = new PdfWriter(out);

		PdfDocument pdfDoc = new PdfDocument(writer);

		pdfDoc.setDefaultPageSize(PageSize.A4);

		PdfPage page = pdfDoc.addNewPage();

		PdfCanvas canvas = new PdfCanvas(page);

		Rectangle rect = pdfDoc.getDefaultPageSize();

		canvas.saveState().setFillColor(PAGE_BG).rectangle(rect).fill().restoreState();

		float margin = 18f;

		canvas.saveState().setStrokeColor(BORDER_OUTER).setLineWidth(3f)

				.rectangle(margin, margin, rect.getWidth() - 2 * margin, rect.getHeight() - 2 * margin).stroke()

				.setLineWidth(1f).rectangle(margin + 5, margin + 5, rect.getWidth() - 2 * (margin + 5),
						rect.getHeight() - 2 * (margin + 5))
				.stroke().restoreState();

		float cSize = 22f;

		canvas.saveState().setFillColor(BORDER_OUTER)

				.rectangle(margin - 3, margin - 3, cSize, cSize)
				.rectangle(rect.getWidth() - margin - cSize + 3, margin - 3, cSize, cSize)
				.rectangle(margin - 3, rect.getHeight() - margin - cSize + 3, cSize, cSize)
				.rectangle(rect.getWidth() - margin - cSize + 3, rect.getHeight() - margin - cSize + 3, cSize, cSize)
				.fill().restoreState();

		Document document = new Document(pdfDoc);

		document.setMargins(40, 45, 40, 45);

		PdfFont hindiFont = null;

		try {

			InputStream fontStream = getClass().getClassLoader()
					.getResourceAsStream("static/fonts/NotoSansDevanagari-Bold.ttf");

			if (fontStream != null) {

				byte[] fontBytes = fontStream.readAllBytes();
				fontStream.close();

				hindiFont = PdfFontFactory.createFont(fontBytes, PdfEncodings.IDENTITY_H,
						PdfFontFactory.EmbeddingStrategy.PREFER_EMBEDDED);
			}

		} catch (Exception ignored) {
		}

		try {

			InputStream ganeshStream = getClass().getClassLoader().getResourceAsStream("static/images/ganesh.png");

			if (ganeshStream != null) {

				byte[] ganeshBytes = ganeshStream.readAllBytes();
				ganeshStream.close();

				ImageData ganeshData = ImageDataFactory.create(ganeshBytes);

				Image ganeshImg = new Image(ganeshData).setWidth(60).setHeight(72)
						.setHorizontalAlignment(HorizontalAlignment.CENTER).setMarginBottom(4);

				document.add(ganeshImg);
			}

		} catch (Exception ignored) {
		}

		String omText = "\u0950 \u0917\u0923\u0947\u0936\u093E\u092F \u0928\u092E\u0903";

		Paragraph omPara = new Paragraph(omText).setFontSize(22).setBold().setFontColor(BROWN)
				.setTextAlignment(TextAlignment.CENTER).setMarginBottom(6).setMarginTop(2);

		if (hindiFont != null) {
			omPara.setFont(hindiFont);
		}

		document.add(omPara);

		Table divider = new Table(UnitValue.createPercentArray(new float[] { 1 }))
				.setWidth(UnitValue.createPercentValue(80)).setHorizontalAlignment(HorizontalAlignment.CENTER)
				.setBorderTop(new SolidBorder(BROWN, 1.5f)).setBorder(Border.NO_BORDER).setMarginBottom(12);

		document.add(divider);

		System.out.println("Photo Path = " + customer.getProfilePhoto());

		if (customer.getProfilePhoto() != null) {

			File photoFile = new File(customer.getProfilePhoto());

			if (photoFile.exists()) {

				ImageData imgData = ImageDataFactory.create(photoFile.getAbsolutePath());

				Image img = new Image(imgData).setWidth(130).setHeight(155)
						.setHorizontalAlignment(HorizontalAlignment.CENTER).setBorder(new SolidBorder(PHOTO_BORDER, 2))
						.setMarginBottom(10);

				document.add(img);

			} else {

				document.add(noPhotoPlaceholder());
			}

		} else {

			document.add(noPhotoPlaceholder());
		}

		String customerName = (customer.getCustomerName() != null) ? customer.getCustomerName() : "N/A";

		document.add(new Paragraph(customerName).setFontSize(24).setBold().setFontColor(DARK_BROWN)
				.setTextAlignment(TextAlignment.CENTER).setMarginBottom(10));

		String religion = customer.getReligionId() != null ? customer.getReligionId().getName() : "N/A";

		String caste = "N/A";

		if (customer.getCasteId() != null)
			caste = customer.getCasteId().getCasteName();
		else if (customer.getSubCasteId() != null)
			caste = customer.getSubCasteId().getCasteId().getCasteName();

		String subCaste = customer.getSubCasteId() != null ? customer.getSubCasteId().getSubCasteName() : "N/A";

		String education = val(customer.getEducation());
		String occupation = val(customer.getOccupation());

		document.add(buildInfoTable(new String[][] {

				{ "Religion", religion }, { "Caste", caste }, { "Sub Caste", subCaste }, { "Education", education },
				{ "Occupation", occupation } }));

		document.add(sectionHeading("Contact Details"));

		document.add(buildInfoTable(new String[][] {

				{ "Phone no.", val(customer.getPhoneNo()) }, { "Address", val(customer.getCity()) } }));

		document.add(new Paragraph(" ").setFontSize(6));

		document.add(new Paragraph("Generated by Matrimony Management System").setFontSize(8).setFontColor(BROWN)
				.setTextAlignment(TextAlignment.CENTER));

		document.close();

		return out.toByteArray();
	}

	private String val(String s) {
		return s != null ? s : "N/A";
	}

	private Paragraph noPhotoPlaceholder() {
		return new Paragraph("No Photo").setFontColor(TEXT_DARK).setFontSize(10).setTextAlignment(TextAlignment.CENTER)
				.setMarginBottom(10);
	}

	private Table buildInfoTable(String[][] rows) {

		Table table = new Table(UnitValue.createPointArray(new float[] { 120, 20, 300 }))
				.setWidth(UnitValue.createPercentValue(100)).setBorder(Border.NO_BORDER).setMarginBottom(2);

		for (String[] row : rows) {

			String key = (row[0] != null) ? row[0] : "N/A";
			String value = (row[1] != null) ? row[1] : "N/A";

			table.addCell(new Cell().setBorder(Border.NO_BORDER)
					.add(new Paragraph(key).setFontSize(11).setFontColor(TEXT_DARK)));

			table.addCell(new Cell().setBorder(Border.NO_BORDER)
					.add(new Paragraph(":").setFontSize(11).setFontColor(TEXT_DARK)));

			table.addCell(new Cell().setBorder(Border.NO_BORDER)
					.add(new Paragraph(value).setFontSize(11).setFontColor(TEXT_DARK)));
		}

		return table;
	}

	private Paragraph sectionHeading(String text) {

		return new Paragraph(text).setFontSize(14).setBold().setFontColor(BROWN).setUnderline(1f, -2f).setMarginTop(10)
				.setMarginBottom(4);
	}

}
