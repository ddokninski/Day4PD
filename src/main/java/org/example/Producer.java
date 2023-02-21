package org.example;

public class Producer {
    private String model;
    private String type;

    public Producer(String model, String type) {
        this.model = model;
        this.type = type;
    }

    public Producer() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Producer{" +
                "model='" + model + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
