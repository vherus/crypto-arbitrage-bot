package api;

import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.io.UnsupportedEncodingException;

public interface ApiPostRequest extends ApiRequest {
    UrlEncodedFormEntity getParameters() throws UnsupportedEncodingException;
}
