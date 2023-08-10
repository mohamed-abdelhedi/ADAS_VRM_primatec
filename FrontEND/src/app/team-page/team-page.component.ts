import { Component } from '@angular/core';

interface Employee {
  id: string; // UUID
}
interface Team {
  name: string;
  department: string;
  group: string;
  totalProjects: number;
  employees: Employee[];
}
@Component({
  selector: 'team-page',
  templateUrl: './team-page.component.html',
  styleUrls: ['./team-page.component.css']
})
export class TeamPageComponent {

   teams: Team[] = [
    {
      name: 'John Doe',
      department: 'HR',
      group: 'Team A',
      totalProjects: 5,
      employees: [
        { id: 'employee-1' },
        { id: 'employee-2' },
        { id: 'employee-3' },
      ],
    },
    {
      name: 'Jane Smith',
      department: 'IT',
      group: 'Development',
      totalProjects: 8,
      employees: [
        { id: 'employee-4' },
        { id: 'employee-5' },
      ],
    },
    {
      name: 'Jane Smith',
      department: 'HR',
      group: 'Team A',
      totalProjects: 5,
      employees: [
        { id: 'employee-6' },
        { id: 'employee-7' },
      ],
    },
    {
      name: 'John Doe',
      department: 'Finance',
      group: 'Team B',
      totalProjects: 8,
      employees: [
        { id: 'employee-8' },
        { id: 'employee-9' },
      ],
    },
    // ... and so on
  ];
  p: number = 1; // Current page number
  itemsPerPage: number = 10; // Number of items to display per page
  addEmployee() {
    // You can implement the logic to add a new employee here.
  }

  getStatusClass(status: string) {
    return {
      'online-status': status === 'Online',
      'offline-status': status === 'Offline'
    };
  }


  isModalOpen = false;

  openModal() {
    this.isModalOpen = true;
  }

  closeModal() {
    this.isModalOpen = false;
  }
}
