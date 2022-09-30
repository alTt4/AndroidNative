package edu.fbansept.dfsr_presentation;

import org.json.JSONException;
import org.json.JSONObject;

public class Animal {
    private Integer animal_id;
    private String animal_name;
    private String animal_image_link;

    public Animal(Integer animal_id, String animal_name, String animal_image_link) {
        this.animal_id = animal_id;
        this.animal_name = animal_name;
        this.animal_image_link = animal_image_link;
    }

    public Integer getAnimal_id() {
        return animal_id;
    }

    public void setAnimal_id(Integer animal_id) {
        this.animal_id = animal_id;
    }

    public String getAnimal_name() {
        return animal_name;
    }

    public void setAnimal_name(String animal_name) {
        this.animal_name = animal_name;
    }

    public String getAnimal_image_link() {
        return animal_image_link;
    }

    public void setAnimal_image_link(String animal_image_link) {
        this.animal_image_link = animal_image_link;
    }

    public Animal(JSONObject json) {

        try {
            this.animal_id = json.getInt("id");
            this.animal_name = json.getString("name");
            this.animal_image_link = json.getString("image_link");
        } catch (JSONException e) {
            e.printStackTrace();
            this.animal_id = 0;
            this.animal_name = "";
            this.animal_image_link = "";
        }
    }
}
