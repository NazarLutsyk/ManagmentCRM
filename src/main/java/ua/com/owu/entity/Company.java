package ua.com.owu.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "contactPeople")
@EqualsAndHashCode(exclude = "contactPeople")
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

    @Reference
    private List<ContactPerson> contactPeople;
}
