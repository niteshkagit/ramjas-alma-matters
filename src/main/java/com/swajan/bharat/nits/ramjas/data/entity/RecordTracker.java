package com.swajan.bharat.nits.ramjas.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "record_tracker")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecordTracker {

    @Id
    @Column(name = "notification_pointer", nullable = false)
    String notificationPointer;
    @Column(name = "count", nullable = false)
    String count;
}
