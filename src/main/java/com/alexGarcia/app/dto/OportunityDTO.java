package com.alexGarcia.app.dto;

public class OportunityDTO {
    /**
     * "name":"AlexLanero1",
     * "BussinessName": "Solera",
     * "email":"alex09945@gmail.com",
     * "phone":"+34638731011",
     * "description":"cosa3",
     * "futureClient":"F",
     * "futureAction":"T",
     * "dateAction":""
     */
    private Long id;
    private String name;
    private String BussinesName;
    private String email;
    private String phone;
    private String description;
    private String futureClient;
    private String futureAction;
    private String dateAction;

    public OportunityDTO(Long id, String name, String bussinesName, String email, String phone, String description, String furtureClient, String futureAction, String dateAction) {
        this.id = id;
        this.name = name;
        BussinesName = bussinesName;
        this.email = email;
        this.phone = phone;
        this.description = description;
        this.futureClient = furtureClient;
        this.futureAction = futureAction;
    }

    public OportunityDTO() {
    }

    public void setBussinesName(String bussinesName) {
        BussinesName = bussinesName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setFutureClient(String furtureClient) {
        this.futureClient = furtureClient;
    }

    public void setFutureAction(String futureAction) {
        this.futureAction = futureAction;
    }


    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBussinesName() {
        return BussinesName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDescription() {
        return description;
    }

    public String getFurtureClient() {
        return futureClient;
    }

    public String getFutureAction() {
        return futureAction;
    }


}
