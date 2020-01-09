package by.ilyukou.domain;

public class HttpDto<T> {
    HttpDtoResponseStatus status;
    T response;

    public HttpDto() {
    }

    public HttpDto(HttpDtoResponseStatus status, T response) {
        this.status = status;
        this.response = response;
    }

    public HttpDtoResponseStatus getStatus() {
        return status;
    }

    public void setStatus(HttpDtoResponseStatus status) {
        this.status = status;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
