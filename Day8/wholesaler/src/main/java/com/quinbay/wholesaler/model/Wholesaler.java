package com.quinbay.wholesaler.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Wholesaler {
    @Id
    @Column(name="id")
    int id;

    @Column(name="whname")
    String whname;

    @Column(name="whcode")
    int whcode;


    public Wholesaler(int id, int whcode, String whname) {
        this.id = id;
        this.whname = whname;
        this.whcode = whcode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWhname() {
        return whname;
    }

    public void setWhname(String whname) {
        this.whname = whname;
    }

    public int getWhcode() {
        return whcode;
    }

    public void setWhcode(int whcode) {
        this.whcode = whcode;
    }


}

