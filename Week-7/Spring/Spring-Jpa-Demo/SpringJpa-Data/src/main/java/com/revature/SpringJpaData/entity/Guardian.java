package com.revature.SpringJpaData.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(
                name = "name",
                column = @Column(name="guardianName")
        ),
        @AttributeOverride(
                name = "email",
                column = @Column(name="guardianEmail")
        ),
        @AttributeOverride(
                name = "mobile",
                column = @Column(name="guardianMobile")
        )
})
public class Guardian {

    private String name;
    private String email;
    private String mobile;
}
