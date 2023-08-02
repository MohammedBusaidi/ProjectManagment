package com.projectManagment.projectManagment.BaseEntity;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createdDate;
    private boolean isActive;
    private LocalDateTime updatedDate;
}
