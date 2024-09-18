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
import { Encounter } from "../models/Encounter";
import { FormsModule } from "@angular/forms";

@Component({
  selector: "app-encounter",
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: "./encounter.component.html",
  styleUrls: ["./encounter.component.scss"],
})
export class EncounterComponent implements OnInit, OnChanges {
  constructor(private service: DataService) {}

  @Input()
  id: string = "";

  @Output()
  encounterModified = new EventEmitter<boolean>();

  encounter: Encounter = new Encounter();

  ngOnInit(): void {
    this.getEncounter();
  }

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.getEncounter();
  }

  getEncounter() {
    this.service.getEncounter(this.id).subscribe((data: Encounter) => {
      console.log(data);
      this.encounter = data;
    });
  }

  deleteEncounter() {
    this.service
      .deleteEncounter(this.encounter.id!) //! => Promise, dass es nicht null ist.
      .subscribe((x) => this.encounterModified.emit(true));
  }

  updateEncounter() {
    var newEncounter: Encounter = this.encounter;
    this.service
      .updateEncounter(newEncounter)
      .subscribe((encounter) => {
        console.log("Encounter aktualisiert");
        this.encounter = encounter;
        this.encounterModified.emit(false);
      });
  }

  addStatus() {
    this.encounter.status = "planned";
    console.log(this.encounter.status);
  }

  get periodStart() {
    return this.encounter.period?.start || '';
  }

  set periodStart(value: string) {
    if (this.encounter.period) {
      this.encounter.period.start = value;
    } else {
      this.encounter.period = { start: value, end: '' };
    }
  }

  get periodEnd() {
    return this.encounter.period?.end || '';
  }

  set periodEnd(value: string) {
    if (this.encounter.period) {
      this.encounter.period.end = value;
    } else {
      this.encounter.period = { start: '', end: value };
    }
  }

  get typeText() {
    return this.encounter.type?.[0]?.text || '';
  }

  set typeText(value: string) {
    if (this.encounter.type && this.encounter.type[0]) {
      this.encounter.type[0].text = value;
    } else {
      this.encounter.type = [{ text: value }];
    }
  }

  get diagnosisText() {
    return this.encounter.diagnosis?.[0]?.condition?.text || '';
  }

  set diagnosisText(value: string) {
    if (this.encounter.diagnosis && this.encounter.diagnosis[0] && this.encounter.diagnosis[0].condition) {
      this.encounter.diagnosis[0].condition.text = value;
    } else {
      this.encounter.diagnosis = [{ condition: { text: value } }];
    }
  }

  get individual() {
    return this.encounter.participant?.[0]?.individual?.display || '';
  }

  set individual(value: string) {
    if (this.encounter.participant && this.encounter.participant[0] && this.encounter.participant[0].individual) {
      this.encounter.participant[0].individual.display = value;
    } else {
      this.encounter.participant = [{ individual: { display: value } }];
    }
    }

}
