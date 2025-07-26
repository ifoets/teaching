package rx.design.analysis.rx.model;

public class HttpResponse<T> {
    public int status;
    public T body;

    public HttpResponse(int status, T body) {
        this.status = status;
        this.body = body;
    }

    public static <T> HttpResponse<T> success(T body) {
        return new HttpResponse<>(200, body);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
// getters/setters
}
