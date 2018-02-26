package be.lemonade.reactive.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    private String id;
    //read-only
    private List<Approval> approvals;
    private List<Team> memberships;
    //read-only
    private PersonalData personalData;

}
