import { RouterModule, Routes } from "@angular/router";
/* import { UsersComponent } from "./users/users.component";
import { UserdetailsComponent } from "./userdetails/userdetails.component";
import { PostsComponent } from "./posts/posts.component"; */
import { PatientsComponent } from "./patients/patients.component";
import { Practitioner } from "./models/Practitioner";
import { PractitionerComponent } from "./practitioner/practitioner.component";
import { NgModule } from '@angular/core';
import { PractitionersComponent } from "./practitioners/practitioners.component";
import { ContractsComponent } from "./contracts/contracts.component";
import {EncounterComponent} from "./encounter/encounter.component";
import {EncountersComponent} from "./encounters/encounters.component";


export const routes: Routes = [
  {
    path: "",
    title: "Patienten",
    component: PatientsComponent,
  },
  {
    path: "patients",
    title: "Patienten",
    component: PatientsComponent,
  },
  {
    path: "practitioners",
    title: "Practitioners",
    component: PractitionersComponent,
  },
  {
    path: "contracts",
    title: "Contracts",
    component: ContractsComponent,
  },
  {
    path: "encounters",
    title: "Encounters",
    component: EncountersComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)], // <-- Hier importieren wir das RouterModule mit den definierten Routen
  exports: [RouterModule]
})
export class AppRoutingModule { }
