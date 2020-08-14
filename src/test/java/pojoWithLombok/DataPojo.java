package pojoWithLombok;

import lombok.Data;

@Data
public class DataPojo {
    private String id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
