package com.MinTicCiclo3.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "score")
public class Score {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer messageText;
    private String starts;
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getMessageText() {
        return messageText;
    }
    public void setMessageText(Integer messageText) {
        this.messageText = messageText;
    }
    public String getStarts() {
        return starts;
    }
    public void setStarts(String starts) {
        this.starts = starts;
    }

}
