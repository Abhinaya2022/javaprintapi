# Java Print API Documentation

This guide provides comprehensive instructions on how to use the Java Print API, including its three main controller endpoints for managing printers and printing PDF files. Follow the outlined steps for seamless integration and usage.

---

## Table of Contents
- [Overview](#overview)
- [API Endpoints](#api-endpoints)
  - [Get All Printers](#1-get-all-printers)
  - [Get Default Printer](#2-get-default-printer)
  - [Print PDF File](#3-print-pdf-file)
- [Usage Instructions](#usage-instructions)
  - [Step 1: Get the Printer Name](#step-1-get-the-printer-name)
  - [Step 2: Prepare the Request Body](#step-2-prepare-the-request-body)
  - [Step 3: Submit the Print Job](#step-3-submit-the-print-job)
- [Example Workflow](#example-workflow)
- [Additional Notes](#additional-notes)
- [Support](#support)
- [License](#license)
- [Contributing](#contributing)

---

## Overview
The Java Print API allows applications to manage printers and submit PDF files for direct printing. It features endpoints to retrieve printer information and execute print jobs efficiently. This documentation outlines the steps required to use the API effectively.

---

## API Endpoints

### 1. Get All Printers
- **Endpoint:** `/api/printer/all`
- **Method:** `GET`
- **Description:** Retrieves a list of all available printers on the system.
- **Sample Response:**
  ```json
  [
      "Microsoft Print to PDF",
      "HP LaserJet Pro MFP",
      "Canon Inkjet Printer"
  ]
  ```

### 2. Get Default Printer
- **Endpoint:** `/api/printer/default`
- **Method:** `GET`
- **Description:** Retrieves the name of the default printer configured on the system.
- **Sample Response:**
  ```json
  {
      "defaultPrinter": "Microsoft Print to PDF"
  }
  ```

### 3. Print PDF File
- **Endpoint:** `/api/printer/print`
- **Method:** `POST`
- **Description:** Sends a PDF file to the specified printer for direct printing.
- **Request Body:**
  ```json
  {
      "printerName": "Microsoft Print to PDF",
      "printType": "test",
      "applicationName": "Application Name",
      "filePath": "filePath",
      "chromacityType": "Monochrome",
      "mediaSize": "A4",
      "fromPageNbr": 1,
      "toPageNbr": 1
  }
  ```
- **Sample Response:**
  ```json
  {
      "status": "Success",
      "message": "Print job submitted successfully"
  }
  ```

---

## Usage Instructions

### Step 1: Get the Printer Name
If you are unsure about the printer name:
1. Call the `Get All Printers` endpoint to retrieve the list of available printers.
2. If a default printer is preferred, call the `Get Default Printer` endpoint.

### Step 2: Prepare the Request Body
Create a JSON model for the `Print PDF File` endpoint based on the following fields:
- `printerName`: Name of the printer (e.g., "Microsoft Print to PDF").
- `printType`: Type of print operation (e.g., "test").
- `applicationName`: Name of the application initiating the print job (e.g., "BRMS").
- `filePath`: Full file path of the PDF file to be printed.
- `chromacityType`: Chromacity setting (e.g., "Monochrome" or "Color").
- `mediaSize`: Size of the media (e.g., "A4").
- `fromPageNbr`: Start page number for printing.
- `toPageNbr`: End page number for printing.

### Step 3: Submit the Print Job
1. Use the prepared JSON model as the request body.
2. Call the `Print PDF File` endpoint with the request body to submit the print job.
3. Check the response for the status and message of the print job.

---

## Example Workflow

1. **Retrieve Printer Names:**
   - Call `/api/printer/all`.
   - Example Response:
     ```json
     [
         "Microsoft Print to PDF",
         "HP LaserJet Pro MFP"
     ]
     ```

2. **Select or Get Default Printer:**
   - Call `/api/printer/default` if unsure about the default printer.
   - Example Response:
     ```json
     {
         "defaultPrinter": "Microsoft Print to PDF"
     }
     ```

3. **Print a PDF File:**
   - Prepare the JSON request body:
     ```json
     {
         "printerName": "Microsoft Print to PDF",
         "printType": "test",
         "applicationName": "BRMS",
         "filePath": "C:\\Users\\ABCD_2345671-01-00.pdf",
         "chromacityType": "Monochrome",
         "mediaSize": "A4",
         "fromPageNbr": 1,
         "toPageNbr": 1
     }
     ```
   - Submit a POST request to `/api/printer/print` with the above JSON body.
   - Example Response:
     ```json
     {
         "message": "Printed successfully"
         "status": "Success",
     }
     ```

---

## Additional Notes
- Ensure the printer is connected and configured correctly before submitting a print job.
- Provide the correct file path; otherwise, the API will return an error.
- For best results, match the `mediaSize` and `chromacityType` with the printer's capabilities.

---

## Support
For any issues or queries, contact the development team or refer to the API documentation.

---

## License
This project is licensed under the [MIT License](LICENSE).

---

## Contributing
Contributions are welcome! Please follow the steps below:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-name`).
3. Make your changes and commit them (`git commit -m 'Add feature'`).
4. Push to the branch (`git push origin feature-name`).
5. Open a Pull Request.

For any questions, feel free to reach out!

