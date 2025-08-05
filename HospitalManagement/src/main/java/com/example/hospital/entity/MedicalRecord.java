package com.example.hospital.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String diagnosis;
    private String treatment;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public MedicalRecord() {}

    public MedicalRecord(Long id, String diagnosis, String treatment, LocalDate date, Patient patient) {
        this.id = id;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.date = date;
        this.patient = patient;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDiagnosis() { return diagnosis; }
    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }

    public String getTreatment() { return treatment; }
    public void setTreatment(String treatment) { this.treatment = treatment; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}
