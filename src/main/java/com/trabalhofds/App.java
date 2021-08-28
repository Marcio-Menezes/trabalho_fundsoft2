package com.trabalhofds;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

    private static final String SAMPLE_CSV_FILE_PATH = "veiculos.csv";

    public static void main(String[] args) throws IOException {
        try (
                 Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));  CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);) {
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String placa = csvRecord.get(0);
                String marca = csvRecord.get(1);
                String modelo = csvRecord.get(2);
                int ano = Integer.parseInt(csvRecord.get(3));
                double preco = Double.parseDouble(csvRecord.get(4));
                double consumoKH = Double.parseDouble(csvRecord.get(5));
                System.out.println("Record No - " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Placa : " + placa);
                System.out.println("Marca : " + marca);
                System.out.println("Modelo : " + modelo);
                System.out.println("Ano : " + ano);
                System.out.println("Preco : " + preco);
                System.out.println("Consumo por Kh : " + consumoKH);
                System.out.println("---------------\n\n");
            }
        }
    }
}
