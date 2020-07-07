package uz.pdp.ecommerce.entity;

import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.Entity;

@Entity
public class Attachment extends AGenerator {
    private String name;
    private long size;
    private String contentType;

    public Attachment() {
    }

    public Attachment(String name, long size, String contentType) {
        this.name = name;
        this.size = size;
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
