package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import pojo.BasePOJO;

import java.io.File;
import java.io.IOException;

public class TestDataHolder {

    public BasePOJO fetchDataFromJSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File jsonFile = new File( System.getProperty("user.dir") + "/src/testdata/test.json");
        return objectMapper.readValue(jsonFile, BasePOJO.class);
    }
}
