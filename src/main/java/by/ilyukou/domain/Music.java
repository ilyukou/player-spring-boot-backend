package by.ilyukou.domain;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Document(indexName = "blog", type = "music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    private String fileNameOnDisk;

    public Music() {

    }

    public Music(String name, String fileNameOnDisk, String type) {
        this.name = name;
        this.fileNameOnDisk = fileNameOnDisk;
        this.type = type;
    }

    public String getName() {
        return name;
    }


    public void setName(String value) {
        this.name = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileNameOnDisk() {
        return fileNameOnDisk;
    }

    public void setFileNameOnDisk(String fileNameOnDisk) {
        this.fileNameOnDisk = fileNameOnDisk;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
