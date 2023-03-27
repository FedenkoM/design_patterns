package org.example.structural.decorator;

public class Demo {

    private static final String PATH = "C:\\Users\\Fedenko\\Desktop\\PatternsGOF\\src\\main\\resources\\OutputDemo";
    public static void main(String[] args) {
        String salaryRecords = "Name,Salary\nJohn Smith,100000\nSteven Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                                         new EncryptionDecorator(
                                             new FileDataSource(PATH)));
        encoded.writeData(salaryRecords);
        DataSource plain = new FileDataSource(PATH);

        System.out.println("- Input ----------------");
        System.out.println(salaryRecords);
        System.out.println("- Encoded --------------");
        System.out.println(plain.readData());
        System.out.println("- Decoded --------------");
        System.out.println(encoded.readData());
    }
}