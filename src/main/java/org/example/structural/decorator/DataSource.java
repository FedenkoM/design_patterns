package org.example.structural.decorator;

public interface DataSource {

    void writeData(String data);
    String readData();
}
