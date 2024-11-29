package com.audree.audreeprintservice.service;

import java.util.List;

import com.audree.audreeprintservice.dto.PrintRequestDto;
import com.audree.audreeprintservice.dto.ResponseDto;

public interface PrintService {
	String printMessage();

	ResponseDto getDefaultPrinter();

	ResponseDto getAllPrinters();

	ResponseDto printPdfFile(PrintRequestDto printRequest);
}
