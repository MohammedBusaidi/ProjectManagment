package com.projectManagment.projectManagment.Models;

import com.projectManagment.projectManagment.BaseEntity.BaseEntity;
import com.projectManagment.projectManagment.Enum.Section;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Card extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cardId;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Section section;
    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;
}
