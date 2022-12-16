package org.example.lab2;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.example.lab1.employee;


import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class XmlS implements InterfaceS<employee> {

    private ObjectMapper objectMapper;

    public XmlS() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void writeObject(String fileName, employee object) {
        try{
            objectMapper.writeValue(new File(fileName), object);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public employee readObject(String fileName) {
        try{
            var res = objectMapper.readValue(new File(fileName), employee.class);
            return (employee) res;
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeList(String fileName, List<employee> object) {
        try{
            objectMapper.writeValue(new File(fileName), object);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<employee> readObjectsList(String fileName) {
        try{
            return objectMapper.readerForListOf(employee.class).readValue(new File(fileName));
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
