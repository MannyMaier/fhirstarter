import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Encounter, Identifier } from '../models/Encounter';
import { CommonModule } from '@angular/common';
import { EncounterComponent } from '../encounter/encounter.component';

@Component({
  selector: 'app-encounters',
  standalone: true,
  imports: [CommonModule, EncounterComponent],
  templateUrl: './encounters.component.html',
  styleUrls: ['./encounters.component.scss']
})
export class EncountersComponent implements OnInit {
  constructor(private service: DataService) { }

  // Verwende encounterArr$ für Konsistenz mit Practitioner
  encounterArr$: Encounter[] = [];
  selectedEncounter: Encounter = new Encounter();

  ngOnInit(): void {
    this.getEncounters();
  }

  getEncounters() {
    this.service.getEncounters().subscribe((data: Encounter[]) => {
      console.log(data);
      this.encounterArr$ = data;
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

    // Erstellen Sie ein neues Identifier-Objekt
    var newIdentifier: Identifier = new Identifier('Ihre ID hier');

    // Fügen Sie das Identifier-Objekt zur identifier-Liste des Encounters hinzu
    newEncounter.identifier = [newIdentifier];

    // Fügen Sie ggf. weitere Initialisierungen für den neuen Encounter hinzu

    this.service.addEncounter(newEncounter).subscribe((encounter) => {
      console.log("Encounter created");
      this.onEncounterModified(true);
    });
  }
}
