package bean;

public class Blog {
    String b_id;
    String b_time;
    String b_name;
    String b_message;
    int b_state;

    public Blog(){}

    public Blog(String b_id, String b_time, String b_name, String b_message, int b_state) {
        this.b_id = b_id;
        this.b_time = b_time;
        this.b_name = b_name;
        this.b_message = b_message;
        this.b_state = b_state;
    }

    public String getB_id() {
        return b_id;
    }

    public void setB_id(String b_id) {
        this.b_id = b_id;
    }

    public String getB_time() {
        return b_time;
    }

    public void setB_time(String b_time) {
        this.b_time = b_time;
    }

    public String getB_name() {
        return b_name;
    }

    public void setB_name(String b_name) {
        this.b_name = b_name;
    }

    public String getB_message() {
        return b_message;
    }

    public void setB_message(String b_message) {
        this.b_message = b_message;
    }

    public int getB_state() {
        return b_state;
    }

    public void setB_state(int b_state) {
        this.b_state = b_state;
    }
}
