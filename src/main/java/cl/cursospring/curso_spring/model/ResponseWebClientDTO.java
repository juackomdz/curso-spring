package cl.cursospring.curso_spring.model;

public class ResponseWebClientDTO {

    private Integer id;
    private String title;
    private boolean completed;
    private String userId;
    private Object extra;
    
    public ResponseWebClientDTO(Integer id, String title, boolean completed, String userId, Object extra) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userId = userId;
        this.extra = extra;
    }

    public ResponseWebClientDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }

    
}
