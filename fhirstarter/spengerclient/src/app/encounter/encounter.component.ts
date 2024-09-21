import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Encounter, Diagnosis, Participant, Period, Reference, Identifier, EncounterStatus, CodeableConcept, Coding } from '../models/Encounter';
import { DataService } from '../data.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-encounter',
  standalone: true,
  imports: [CommonModule, FormsModule], // Stelle sicher, dass FormsModule hier importiert ist
  templateUrl: './encounter.component.html',
  styleUrls: ['./encounter.component.scss'],
})
export class EncounterComponent implements OnInit {
  @Input() id: string = '';
  @Output() encounterModified = new EventEmitter<boolean>();

  encounter: Encounter = new Encounter();

  constructor(private service: DataService) {}

  ngOnInit(): void {
    this.getEncounter();
  }

  ngOnChanges(changes: import("@angular/core").SimpleChanges): void {
    this.getEncounter();
  }

  getEncounter() {
    this.service.getEncounter(this.id).subscribe((data: Encounter) => {
      this.encounter = data;

      console.log('Encounter:', this.encounter);

      if (!this.encounter.period) {
        this.encounter.period = new Period('', '');
        console.log(this.encounter.period) // Stelle sicher, dass period initialisiert wird
      }
    });
  }

  deleteEncounter() {
    this.service.deleteEncounter(this.encounter.id!).subscribe(() => {
      this.encounterModified.emit(true);
    });
  }

  updateEncounter() {
    if (this.encounter.period) {
        // Verwende die bestehende Periode
        this.encounter.period = new Period(this.encounter.period.start, this.encounter.period.end);
    } else {
        // Setze eine neue Periode, falls keine existiert
        this.encounter.period = new Period('2024-01-01T00:00:00Z', '2024-12-31T23:59:59Z');
    }
    
    this.service.updateEncounter(this.encounter).subscribe(
        (updatedEncounter) => {
            console.log("Encounter updated", updatedEncounter);
            this.encounter = updatedEncounter;
            this.encounterModified.emit(false);
        },
        (error) => {
            console.error('Error updating encounter:', error);
        }
    );
}


   /* updateEncounter() {

     // Stelle sicher, dass die Period-Instanz korrekt ist
     if (!this.encounter.period) {
         this.encounter.period = new Period(/* setze hier die Werte für start und end );
     }
     console.log('E:', this.encounter);


     this.service.updateEncounter(this.encounter).subscribe(
         () => {
             console.log('Encounter updated');
             console.log('EncounterU:', this.encounter);
             this.encounterModified.emit(false);
         },
         (error) => {
             console.error('Error updating encounter:', error);
         }
     );
 }  
     */


  addDiagnosis() {
    this.encounter.diagnosis.push(new Diagnosis());
  }

  deleteDiagnosis(index: number) {
    this.encounter.diagnosis.splice(index, 1);
  }

  addParticipant() {
    if (!this.encounter.participant) {
      this.encounter.participant = []; // Initialisiere das Array, falls es undefined ist
    }
  
    const newParticipant: Participant = {
      type: [
        new CodeableConcept(
          [
            new Coding('http://example.com/system', '1.0', 'example-code', 'Example Display', false)
          ],
          'Example Codeable Concept'
        ),
      ],
      period: new Period(/* setze start und end hier */),
      individual: new Reference('', '', new Identifier('identifier_value')),
    };
  
    this.encounter.participant.push(newParticipant);
  }
  
  

  deleteParticipant(index: number) {
    this.encounter.participant.splice(index, 1);
  }

  getStatusValues(): string[] {
    return Object.values(EncounterStatus);
  }

   
  addType(participantIndex: number) {
    const newType = new CodeableConcept([], ''); // Neue CodeableConcept instanz
    this.encounter.participant[participantIndex].type.push(newType);
  }
  
  removeType(participantIndex: number, typeIndex: number) {
    this.encounter.participant[participantIndex].type.splice(typeIndex, 1);
  }
  

}
