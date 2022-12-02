package com.alexGarcia.app.dto;

import com.alexGarcia.app.entity.Oportunity;

import javax.persistence.*;
import java.util.List;

public class ClientDTO {
    private Long id;
    private String name;
    private List<OportunityDTO2> oportunities;

    public ClientDTO(Long id, String name, List<OportunityDTO2> oportunities) {
        this.id = id;
        this.name = name;
        this.oportunities = oportunities;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<OportunityDTO2> getOportunities() {
        return oportunities;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOportunities(List<OportunityDTO2> oportunities) {
        this.oportunities = oportunities;
    }
}
