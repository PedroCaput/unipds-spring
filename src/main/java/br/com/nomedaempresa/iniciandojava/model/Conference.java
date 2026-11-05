package br.com.nomedaempresa.iniciandojava.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tbl_conference")
public class Conference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_conference")
    private Integer idConference;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "address", length = 255, nullable = false)
    private String address;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL)
    private List<Session> sessions;

    public Integer getIdConference() { return idConference; }
    public void setIdConference(Integer idConference) { this.idConference = idConference; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    @Override
    public String toString() {
        return "Conference{" +
                "idConference=" + idConference +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", sessions=" + sessions +
                '}';
    }
}
