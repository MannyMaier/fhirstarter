import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Identifier, Practitioner } from '../models/Practitioner';
import { CommonModule } from '@angular/common';
import { PractitionerComponent } from '../practitioner/practitioner.component'; // import the PractitionerComponent

@Component({
  selector: 'app-practitioners',
  standalone: true,
  imports: [CommonModule, PractitionerComponent],
  templateUrl: './practitioners.component.html',
  styleUrls: ['./practitioners.component.scss']
})
export class PractitionersComponent implements OnInit {
  constructor(private service: DataService) { }

  practitionerArr$: Practitioner[] = [];
  selectedPractitioner: Practitioner = new Practitioner();

  ngOnInit(): void {
    this.getPractitioners();
  }

  getPractitioners() {
    this.service.getPractitioners().subscribe((data: Practitioner[]) => {
      console.log(data);
      this.practitionerArr$ = data;
    });
  }

  selectPractitioner(selected: Practitioner) {
    console.log("clicked Practitioner" + selected.id);
    this.selectedPractitioner = selected;
  }

  onPractitionerModified(hidePractitioner: boolean) {
    console.log("Practitioner modified " + hidePractitioner);
    if (hidePractitioner) {
      this.selectedPractitioner = new Practitioner();
    }
    this.getPractitioners();
  }

  createPractitioner() {
    var newPractitioner: Practitioner = new Practitioner();
    
    // Erstellen Sie ein neues Identifier-Objekt
    var newIdentifier: Identifier = new Identifier('Ihre ID hier');
    
    // Fügen Sie das Identifier-Objekt zur identifier-Liste des Practitioner hinzu
    newPractitioner.identifier = [newIdentifier];
    
    this.service.addPractitioner(newPractitioner).subscribe((practitioner) => {
      console.log("Practitioner created");
      this.onPractitionerModified(true);
    });
  }
}
