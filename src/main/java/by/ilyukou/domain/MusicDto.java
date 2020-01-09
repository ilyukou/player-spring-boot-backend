package by.ilyukou.domain;
import org.springframework.core.io.Resource;

public class MusicDto {

    private Resource resource;
    private String contentType;

    public MusicDto(Resource resource, String contentType) {
        this.resource = resource;
        this.contentType = contentType;
    }

    public MusicDto(){

    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
