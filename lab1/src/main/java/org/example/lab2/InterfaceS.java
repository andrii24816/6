package org.example.lab2;

import org.example.lab1.employee;
import java.io.IOException;
import java.util.List;

public interface InterfaceS<T> {
    void writeObject(String fileName, T object) throws IOException;

    employee readObject(String fileName) throws IOException, InstantiationException, IllegalAccessException;

    void writeList(String fileName, List<T> object);

    List<T> readObjectsList(String fileName);
}
