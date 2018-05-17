package com.tulu.poc.exel_csv.exporter.controller;

import com.tulu.poc.exel_csv.exporter.model.Customer;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.Arrays;
import java.util.List;

@RestController
public class ExportController {
    List<Customer> customers = Arrays.asList(new Customer[]{
            new Customer(1,"Tran","Khai","tran.khai@ascendcorp.com", "male"),
            new Customer(2,"Pham","Viet","pham.viet@ascendcorp.com", "male"),
            new Customer(3,"Vu","Dat","vu.dat@ascendcorp.com", "male"),
            new Customer(4,"Bui","Hoa","bui.hoa@ascendcorp.com", "male"),
            new Customer(5,"Do","Trang","do.trang@ascendcorp.com", "female"),
    });

    @RequestMapping(value = "/export", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<StreamingResponseBody> exportApis() {
        return ResponseEntity.ok()
                .header("Content-disposition", "attachment; filename=test.xls")
                .body(outputStream -> {
                    HSSFWorkbook workbook = new HSSFWorkbook();
                    HSSFSheet worksheet = workbook.createSheet("Customers");

                    for (int i =0;i<customers.size();i++){
                        int colNum = 0;
                        Customer customer = customers.get(i);
                        Row row = worksheet.createRow(i);

                        Cell cell;
                        cell = row.createCell(colNum++);
                        cell.setCellValue(customer.getId());
                        cell = row.createCell(colNum++);
                        cell.setCellValue(customer.getFirstname());
                        cell = row.createCell(colNum++);
                        cell.setCellValue(customer.getLastname());
                        cell = row.createCell(colNum++);
                        cell.setCellValue(customer.getEmail());
                        cell = row.createCell(colNum++);
                        cell.setCellValue(customer.getGender());
                    }

                    workbook.write(outputStream);
                });
    }

}
