package ua.com.owu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "company")
@EqualsAndHashCode(exclude = "company")
@Builder
@Entity(noClassnameStored = true, value = "task")
public class Task {
    @Id
    private ObjectId id;
    private String description;
    private Date dateExec;
    private boolean checker = false;
    @JsonIgnore
    @Reference
    private Company company;
}
