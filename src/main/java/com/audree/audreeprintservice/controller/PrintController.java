package com.audree.audreeprintservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.audree.audreeprintservice.dto.PrintRequestDto;
import com.audree.audreeprintservice.dto.ResponseDto;
import com.audree.audreeprintservice.service.PrintService;
import io.swagger.v3.oas.annotations.Operation;


@RestController()
@RequestMapping("/print/")
public class PrintController {

	@Autowired
	private PrintService printService;	

	@GetMapping("test")
	public String printMessage() {
		return printService.printServieTest();
	}

	@GetMapping("get-default-printer")
	public ResponseDto getDefaultPrinter() {
		return printService.getDefaultPrinter();
	}

	@GetMapping("get-all-printer")
	public ResponseDto getAllPrinter() {
		return printService.getAllPrinters();
	}

	@Operation(summary = "Print PDF", description = "Prints the provided PDF file")
	@PostMapping("print-pdf-file")
	public ResponseDto printPdfFile(@RequestBody PrintRequestDto printRequest) {
		return printService.printPdfFile(printRequest);
	}
}