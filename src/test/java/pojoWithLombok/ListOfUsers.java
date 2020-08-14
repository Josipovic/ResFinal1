package pojoWithLombok;

import lombok.Data;

import java.util.List;

@Data
public class ListOfUsers {
    private String page;
    private String per_page;
    private  String total;
    private String total_pages;
    private List<DataPojo> data;
    private Ad ad;
}
