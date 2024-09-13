import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { CommonModule } from '@angular/common';
import { ContractComponent } from '../contract/contract.component'; // import the ContractComponent
import { Contract } from '../models/Contract';

@Component({
  selector: 'app-contracts',
  standalone: true,
  imports: [CommonModule, ContractComponent],
  templateUrl: './contracts.component.html',
  styleUrls: ['./contracts.component.scss']
})
export class ContractsComponent implements OnInit {
  constructor(private service: DataService) { }

  contractArr$: Contract[] = [];
  selectedContract: Contract = new Contract();

  ngOnInit(): void {
    this.getContracts();
  }

  getContracts() {
    this.service.getContracts().subscribe((data: Contract[]) => {
      console.log(data);
      this.contractArr$ = data;
    });
  }

  selectContract(selected: Contract) {
    console.log("clicked Contract" + selected.id);
    this.selectedContract = selected;
  }

  
}
