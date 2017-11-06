package ua.com.owu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "company")
@EqualsAndHashCode(exclude = "company")
@Builder
@Entity(noClassnameStored = true, value = "contactPerson")
public class ContactPerson {
    @Id
    private ObjectId id;
    private String name;
    private String lastname;
    private String position;
    private String phone;
    private String email;
    @Reference
    @JsonIgnore
    private Company company;
}
