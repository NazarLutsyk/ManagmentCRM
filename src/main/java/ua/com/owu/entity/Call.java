package ua.com.owu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"company","offers","result"})
@EqualsAndHashCode(exclude = {"company","offers","result"})
@Builder
@Entity(noClassnameStored = true, value = "call")
public class Call {
    @Id
    private ObjectId id;
    private Date date;
    private String description;
    private boolean executed = false;

    @JsonIgnore
    @Reference
    private Company company;

    @JsonIgnore
    @Reference
    private List<Offer> offers = new ArrayList<>();

    @JsonIgnore
    @Reference
    private Result result;

}
