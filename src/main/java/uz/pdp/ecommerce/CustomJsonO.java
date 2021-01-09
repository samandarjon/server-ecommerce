package uz.pdp.ecommerce;

public class CustomJsonO {
    private StringBuilder obj;

    public CustomJsonO() {
        this.obj = new StringBuilder();
    }

    public void put(String key, String value) {
        if (obj.length() == 0) {
            obj.append(String.format("\"%s\":\"%s\"", key, value));
        } else {
            obj.append(String.format(",\n\"%s\":\"%s\"", key, value));
        }
    }

    @Override
    public String toString() {
        return "{" + obj +
                '}';
    }
}
