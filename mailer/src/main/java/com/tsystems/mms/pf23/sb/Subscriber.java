package com.tsystems.mms.pf23.sb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Marco Grunert (marco.grunert@t-systems.com)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Subscriber {
    private String email;

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

    @Override public String toString() {
        final StringBuffer sb = new StringBuffer("Subscriber{");
        sb.append("email='").append(email).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
