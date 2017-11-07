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
@ToString(exclude = {"offers","company"})
@EqualsAndHashCode(exclude = {"offers","company"})
@Builder
@Entity(noClassnameStored = true, value = "status")
public class Status {
    @Id
    private ObjectId id;
    private String value;
    @JsonIgnore
    @Reference
    private List<Offer> offers = new ArrayList<>();
    @JsonIgnore
    @Reference
    private Company company;
}
