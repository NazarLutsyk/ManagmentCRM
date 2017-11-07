package ua.com.owu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"contactPeople","statuses","tasks","calls"})
@EqualsAndHashCode(exclude = {"contactPeople","statuses","tasks","calls"})
@Builder
@Entity(noClassnameStored = true, value = "company")
public class Company {
    @Id
    private ObjectId id;
    private String name;
    private String phone;
    private String email;
    private String adress;
    private String url;

    @JsonIgnore
    @Reference
    private List<Status> statuses = new ArrayList<>();
    @JsonIgnore
    @Reference
    private List<Task> tasks = new ArrayList<>();
    @JsonIgnore
    @Reference
    private List<Call> calls = new ArrayList<>();
    @JsonIgnore
    @Reference
    private List<ContactPerson> contactPeople = new ArrayList<>();
}
