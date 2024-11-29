package com.audree.audreeprintservice.service;

import java.util.Arrays;
import java.util.List;

import javax.print.DocFlavor;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashAttributeSet;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.Locale;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Chromaticity;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PageRanges;
import javax.print.attribute.standard.PrinterName;
import javax.print.attribute.HashPrintRequestAttributeSet;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPrintable;
import org.apache.pdfbox.printing.Scaling;
import org.apache.pdfbox.Loader;
import org.springframework.stereotype.Service;
import com.audree.audreeprintservice.dto.PrintRequestDto;
import com.audree.audreeprintservice.dto.ResponseDto;

@Service
public class PrintServiceImpl implements PrintService {

	@Override
	public String printMessage() {
		// TODO Auto-generated method stub
		return "Print Service is Running!";
	}

	@Override
	public ResponseDto getDefaultPrinter() {

		ResponseDto res = new ResponseDto();

		// Fetch the default print service
		javax.print.PrintService defaultPrintService = PrintServiceLookup.lookupDefaultPrintService();

		// Prepare the response message
		String message = "Default Printer: ";

		if (defaultPrintService != null) {
			message = message + defaultPrintService.getName();
		} else {
			message = message + "No default printer found.";
		}

		res.setSuccess(true);
		res.setMessage(message);
		return res;
	}

	@Override
	public ResponseDto getAllPrinters() {
		ResponseDto response = new ResponseDto();

		// HashAttributeSet can be used to filter by certain attributes (optional)
		HashAttributeSet has = new HashAttributeSet();

		// Lookup all printers
		DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
		javax.print.PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, has);

		String message = "Available Printers: ";

		// Collect names of all available printers
		if (printServices.length > 0) {
			for (javax.print.PrintService printService : printServices) {
				message = message + printService.getName() + "; ";
			}
		} else {
			message = message + "No printers found.";
		}

		response.setSuccess(true);
		response.setMessage(message);
		return response;
	}

	@Override
	public ResponseDto printPdfFile(PrintRequestDto printRequest) {
		ResponseDto response = new ResponseDto();

		try {
			// Load the PDF document
			File pdfFile = new File(printRequest.getFilePath());
			PDDocument document = Loader.loadPDF(pdfFile);

			// Define print service attributes
			HashAttributeSet has = new HashAttributeSet();
			has.add(new PrinterName(printRequest.getPrinterName(), Locale.getDefault()));
			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
			javax.print.PrintService[] printServices = PrintServiceLookup.lookupPrintServices(flavor, has);

			if (printServices == null || printServices.length == 0) {
				throw new PrinterException("No matching printer found for name: " + printRequest.getPrinterName());
			}

			// Configure Printer Job
			PrinterJob job = PrinterJob.getPrinterJob();
			job.setPrintService(printServices[0]);

			PDFPrintable pageableDoc = new PDFPrintable(document, Scaling.SHRINK_TO_FIT);
			job.setPrintable(pageableDoc);

			// Set additional print attributes
			PrintRequestAttributeSet attr = new HashPrintRequestAttributeSet();
			attr.add(new PageRanges(printRequest.getFromPageNbr(), printRequest.getToPageNbr()));
			attr.add(MediaSizeName.ISO_A4); // Set paper size to A4
			attr.add(OrientationRequested.LANDSCAPE); // Set orientation to landscape

			if ("COLOR".equalsIgnoreCase(printRequest.getChromacityType())) {
				attr.add(Chromaticity.COLOR);
			} else if ("MONOCHROME".equalsIgnoreCase(printRequest.getChromacityType())) {
				attr.add(Chromaticity.MONOCHROME);
			}

			// Perform the print
			job.print(attr);

			response.setMessage("Print successful!");
			response.setSuccess(true);
			return response;

		} catch (IOException e) {
			response.setMessage("Failed to load PDF file: " + e.getMessage());
		} catch (PrinterException e) {
			response.setMessage("Printer error: " + e.getMessage());
		} catch (NullPointerException e) {
			response.setMessage("Null value encountered: " + e.getMessage());
		} catch (Exception e) {
			response.setMessage("Unexpected error: " + e.getMessage());
		}

		response.setSuccess(false);
		return response;
	}
}
