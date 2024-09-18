import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Encounter } from '../models/Encounter';
import { CommonModule } from '@angular/common';
import { EncounterComponent } from '../encounter/encounter.component'; // import the EncounterComponent

@Component({
  selector: 'app-encounters',
  standalone: true,
  imports: [CommonModule, EncounterComponent],
  templateUrl: './encounters.component.html',
  styleUrls: ['./encounters.component.scss']
})
export class EncountersComponent implements OnInit {
  constructor(private service: DataService) { }

  encounters: Encounter[] = [];
  selectedEncounter: Encounter = new Encounter();

  ngOnInit(): void {
    this.getEncounters();
  }

  getEncounters() {
    this.service.getEncounters().subscribe((data: Encounter[]) => {
      console.log(data);
      this.encounters = data;
    });
  }

  selectEncounter(selected: Encounter) {
    console.log("clicked Encounter " + selected.id);
    this.selectedEncounter = selected;
  }

  onEncounterModified(hideEncounter: boolean) {
    console.log("Encounter modified " + hideEncounter);
    if (hideEncounter) {
      this.selectedEncounter = new Encounter();
    }
    this.getEncounters();
  }

  createEncounter() {
    var newEncounter: Encounter = new Encounter();

    // Add any necessary initialization for the new Encounter here

    this.service.addEncounter(newEncounter).subscribe((encounter) => {
      console.log("Encounter created");
      this.onEncounterModified(true);
    });
  }
}
