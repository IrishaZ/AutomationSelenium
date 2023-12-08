package models;

import java.util.List;

public class Rules {
    private long id;
    private String model;
    private String operator;
    private List<String> value;

    public Rules(long id, String model, String operator, List<String> value) {
        this.id = id;
        this.model = model;
        this.operator = operator;
        this.value = value;
    }
    public Rules() {};

        public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public List<String> getValue() {
        return value;
    }

    public void setValue(List<String> value) {
        this.value = value;
    }
}
