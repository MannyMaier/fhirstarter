import { CommonModule } from "@angular/common";
import {
  Component,
  OnInit,
  Input,
  Output,
  EventEmitter,
  OnChanges,
} from "@angular/core";
import { DataService } from "../data.service";
import { Gendercode, HumanName, Patient, StatusCode } from "../models/Patient";
import { FormsModule } from "@angular/forms";
import { combineLatest } from "rxjs";

@Component({
  selector: "app-patient",
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: "./patient.component.html",
  styleUrl: "./patient.component.scss",
})
export class PatientComponent implements OnInit, OnChanges {
  
  updateNameUse(index: number, use: StatusCode) {
    (this.patient.name as HumanName[])[index].use = use;
    
}

updateNameText(index: number, text: string) {
    (this.patient.name as HumanName[])[index].text = text;
}


  patientGender = Object.values(Gendercode);

  humanNameUse = Object.values(StatusCode);

  constructor(private service: DataService) {}
  //Input parameter from patient list, which patient details should bedisplayed;
  @Input()
  id: string = ""; //Notify the parent View to refresh the list
  @Output()
  patientModified = new EventEmitter<boolean>();
  patient: Patient = new Patient();

  ngOnInit(): void {
    this.getPatient();
  }

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.getPatient();
  }
  getPatient() {
    this.service.getPatient(this.id).subscribe((data: Patient) => {
      console.log("Von getPatient: " + data);
      this.patient = data;
    });
  }
  deletePatient() {
    this.service
      .deletePatient(this.patient.id!) //! => Promise, that it will not be null.
      .subscribe((x) => this.patientModified.emit(true));
  }
  updatePatient() {
    var newPatient: Patient = this.patient;
    
    console.log(this.patient);
    console.log("newPat:");
    console.log(newPatient);
    
    this.service.updatePatient(newPatient).subscribe((patient) => {
      console.log("Patient updated:");
      console.log(patient);
      this.patient = patient;
      this.patientModified.emit(false);
    });
  }

  addName() {
    this.patient.name?.push(new HumanName());
    console.log(this.patient.name);
  }

  deleteName(name: HumanName) {
    const index = this.patient.name?.indexOf(name, 0);
    if (index !== undefined && index > -1) {
      this.patient.name?.splice(index, 1);
    }
  }
}
