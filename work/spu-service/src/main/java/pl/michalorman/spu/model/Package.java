package pl.michalorman.spu.model;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class Package {

    @XStreamAsAttribute
    private Integer id;

    private Position position;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

}
