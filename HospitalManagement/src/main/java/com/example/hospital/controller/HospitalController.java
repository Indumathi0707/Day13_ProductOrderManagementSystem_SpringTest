package com.example.hospital.controller;

import com.example.hospital.entity.*;
import com.example.hospital.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HospitalController {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private DoctorRepository doctorRepo;

    @Autowired
    private AppointmentRepository appointmentRepo;

    @Autowired
    private MedicalRecordRepository medicalRecordRepo;

    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepo.save(patient);
    }

    @GetMapping("/patients")
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    // ========== DOCTOR ==========
    @PostMapping("/doctors")
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @GetMapping("/doctors")
    public List<Doctor> getAllDoctors() {
        return doctorRepo.findAll();
    }

    @PostMapping("/appointments")
    public Appointment addAppointment(@RequestBody Appointment appointment) {
        return appointmentRepo.save(appointment);
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllAppointments() {
        return appointmentRepo.findAll();
    }

    @PostMapping("/medical-records")
    public MedicalRecord addMedicalRecord(@RequestBody MedicalRecord record) {
        return medicalRecordRepo.save(record);
    }

    @GetMapping("/medical-records")
    public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecordRepo.findAll();
    }
}
