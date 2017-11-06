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
@ToString(exclude = "call")
@EqualsAndHashCode(exclude = "call")
@Builder
@Entity(noClassnameStored = true, value = "result")
public class Result {
    @Id
    private ObjectId id;
    private String status;
    private Date answerDate;

    @JsonIgnore
    @Reference
    private Call call;
}
