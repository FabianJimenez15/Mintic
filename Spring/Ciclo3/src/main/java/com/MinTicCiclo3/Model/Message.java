package com.MinTicCiclo3.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String messageText;

    @ManyToOne
    @JoinColumn(name="skateId")
    @JsonIgnoreProperties({"message","reservation"})
    private Skates skates;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties({"message","reservation"})
    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Skates getSkates() {
        return skates;
    }

    public void setSkates(Skates skates) {
        this.skates = skates;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }




    
    

}
