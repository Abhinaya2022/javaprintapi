package com.audree.audreeprintservice.dto;

import org.springframework.web.multipart.MultipartFile;

public class PrintRequestDto {
	private String printerName;
    private String printType;
    private String applicationName;
    private String chromacityType;
    private String mediaSize;    
    private String filePath;
    private int fromPageNbr;
    private int toPageNbr;

    // Getters and Setters

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public String getPrintType() {
        return printType;
    }

    public void setPrintType(String printType) {
        this.printType = printType;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getChromacityType() {
        return chromacityType;
    }

    public void setChromacityType(String chromacityType) {
        this.chromacityType = chromacityType;
    }

    public String getMediaSize() {
        return mediaSize;
    }

    public void setMediaSize(String mediaSize) {
        this.mediaSize = mediaSize;
    }    

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String fileName) {
        this.filePath = fileName;
    }

    public int getFromPageNbr() {
        return fromPageNbr;
    }

    public void setFromPageNbr(int fromPageNbr) {
        this.fromPageNbr = fromPageNbr;
    }

    public int getToPageNbr() {
        return toPageNbr;
    }

    public void setToPageNbr(int toPageNbr) {
        this.toPageNbr = toPageNbr;
    }

}
