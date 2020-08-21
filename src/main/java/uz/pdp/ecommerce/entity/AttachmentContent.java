package uz.pdp.ecommerce.entity;

import uz.pdp.ecommerce.entity.template.AGenerator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class AttachmentContent extends AGenerator {
    @OneToOne(cascade = CascadeType.ALL)
    private Attachment attachment;

    private byte[] content;

    public AttachmentContent() {
    }

    public AttachmentContent(Attachment attachment, byte[] content) {
        this.attachment = attachment;
        this.content = content;
    }

    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment attachment) {
        this.attachment = attachment;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
