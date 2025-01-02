package com.audree.audreeprintservice.service;

import com.audree.audreeprintservice.dto.PrintRequestDto;
import com.audree.audreeprintservice.dto.ResponseDto;

public interface PrintService {

	String printServieTest();

	ResponseDto getDefaultPrinter();

	ResponseDto getAllPrinters();

	ResponseDto printPdfFile(PrintRequestDto printRequest);
}
