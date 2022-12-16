package org.example.lab2;

import java.io.IOException;
import java.util.List;

public interface InterfaceO<T> {
    void writeObject(String fileName, T object) throws IOException;

    T readObject(String fileName, Class<T> tClass) throws IOException, InstantiationException, IllegalAccessException;

    void writeList(String fileName, List<T> object);

    List<T> readObjectsList(String fileName, Class<T> tClass);

}
