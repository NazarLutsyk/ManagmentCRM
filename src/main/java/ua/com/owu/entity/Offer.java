package ua.com.owu.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "")
@EqualsAndHashCode(exclude = "")
@Builder
@Entity(noClassnameStored = true, value = "offer")
public class Offer {
    private ObjectId id;
    private String name;
}
