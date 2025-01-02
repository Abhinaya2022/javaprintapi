package com.audree.audreeprintservice.service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class GetOnlinePrinters {

	public String GetOnlinePrinters() {
		// select printer that have state = 0 and status = 3, which indicates that
		// printer can print
		ProcessBuilder builder = new ProcessBuilder("powershell.exe",
				"get-wmiobject -class win32_printer | Select-Object Name, PrinterState, PrinterStatus | where {$_.PrinterState -eq 0 -And $_.PrinterStatus -eq 3}");
		String fullStatus = null;
		Process reg;
		builder.redirectErrorStream(true);
		try {
			reg = builder.start();
			fullStatus = getStringFromInputStream(reg.getInputStream());
			reg.destroy();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		System.out.print(fullStatus);
		
		return fullStatus;
	}

	private String getStringFromInputStream(InputStream is) {
		ByteArrayOutputStream result = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int length;
		try {
			while ((length = is.read(buffer)) != -1) {
				result.write(buffer, 0, length);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// StandardCharsets.UTF_8.name() > JDK 7
		String finalResult = "";
		try {
			finalResult = result.toString("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return finalResult;
	}
}
