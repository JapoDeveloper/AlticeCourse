package co.japo.layoutsapp;

/**
 * Created by japodeveloper on 9/15/17.
 */

public class WebModel {

    private Integer image;
    private String description;

    public WebModel(Integer image, String description){
        this.image = image;
        this.description = description;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
