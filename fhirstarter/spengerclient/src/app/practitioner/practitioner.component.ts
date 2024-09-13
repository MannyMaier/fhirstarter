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
import { HumanName, Practitioner, Qualification } from "../models/Practitioner";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-practitioner",
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: "./practitioner.component.html",
  styleUrls: ["./practitioner.component.scss"],
})
export class PractitionerComponent implements OnInit, OnChanges {
  constructor(private service: DataService) {}

  // Input parameter from practitioner list, which practitioner details should be displayed;
  @Input()
  id: string = "";

  // Notify the parent View to refresh the list
  @Output()
  practitionerModified = new EventEmitter<boolean>();

  practitioner: Practitioner = new Practitioner();

  ngOnInit(): void {
    this.getPractitioner();
  }

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.getPractitioner();
  }

  getPractitioner() {
    this.service.getPractitioner(this.id).subscribe((data: Practitioner) => {
      console.log(data);
      this.practitioner = data;
    });
  }

  deletePractitioner() {
    this.service
      .deletePractitioner(this.practitioner.id!) //! => Promise, that it will not be null.
      .subscribe((x) => this.practitionerModified.emit(true));
  }

  updatePractitioner() {
    var newPractitioner: Practitioner = this.practitioner;
    this.service
      .updatePractitioner(newPractitioner)
      .subscribe((practitioner) => {
        console.log("Practitioner updated");
        this.practitioner = practitioner;
        this.practitionerModified.emit(false);
      });
  }

  addName() {
    let newName = new HumanName();
    newName.prefix.push("");
    newName.given.push("");
    newName.suffix.push("");
    this.practitioner.name?.push(newName);
    console.log(this.practitioner.name);
  }

  deleteName(name: HumanName) {
    const index = this.practitioner.name?.indexOf(name, 0);
    if (index !== undefined && index > -1) {
      this.practitioner.name?.splice(index, 1);
    }
  }

  deletePrefix(name: HumanName, index: number) {
    name.prefix.splice(index, 1);
  }

  deleteGiven(name: HumanName, index: number) {
    name.given.splice(index, 1);
  }

  deleteSuffix(name: HumanName, index: number) {
    name.suffix.splice(index, 1);
  }

  addPrefix(name: HumanName) {
    name.prefix.push("");
  }

  addGiven(name: HumanName) {
    name.given.push("");
  }

  addSuffix(name: HumanName) {
    name.suffix.push("");
  }

  addQualification() {
    this.practitioner.qualification?.push(new Qualification());
}

deleteQualification(index: number) {
    this.practitioner.qualification?.splice(index, 1);
}


  trackByFn(index: any, item: any) {
    return index;
 }
 
}
