package api;

public interface ApiRequest {
    RequestMethod getMethod();
    String getUrl();
}
