package com.tsystems.mms.pf23.sb;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@Entity
public class Subscriber {
    @NotNull
    @Size(min = 5, max = 100)
    @Id
    private String email;

    @NotNull
    @Size(min = 1, max = 100)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
