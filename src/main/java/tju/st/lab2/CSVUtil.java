package tju.st.lab2;

import com.csvreader.CsvReader;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gmy on 16/4/13.
 */
public class CSVUtil {
    public static List<String[]> readCSV(String filePath) throws IOException {
        ArrayList<String[]> dataList = new ArrayList<>();
        CsvReader reader = new CsvReader(filePath, ',', Charset.forName("SJIS"));
        while (reader.readRecord()) {
            dataList.add(reader.getValues());
        }
        return dataList;
    }

    public static void main(String[] args) throws IOException {
        List<String[]> strings = readCSV("info.csv");
        for (String[] str : strings) {
            for (String s : str) {
                System.out.println(s);
            }
        }
    }
}
