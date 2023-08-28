import { Component } from '@angular/core';
import {Router} from "@angular/router";
import {MyApiService} from "../../services/APIs/my-api.service";

@Component({
  selector: 'app-workload-page',
  templateUrl: './workload-page.component.html',
  styleUrls: ['./workload-page.component.css']
})
export class WorkloadPageComponent {
  workloadInfo: any;
  projectid=localStorage.getItem('project_id')
  user=localStorage.getItem('user_id')
  constructor(private router: Router, private myApiService: MyApiService) {
  }
  ngOnInit(): void {
    this.fetchWorkloadInfo();
  }
  fetchWorkloadInfo(): void {

    // @ts-ignore
    this.myApiService.getWorkload(this.projectid).subscribe(
      (data) => {
        this.workloadInfo = data; // Store the retrieved user information
      },
    );
  }
  getStatusClass(status: string): string {
    switch (status.toLowerCase()) {
      case 'in_progress':
        return 'status-in-progress';
      case 'done':
        return 'status-done';
      case 'failed':
        return 'status-failed';
      default:
        return '';
    }
  }
  WorkloadData = {
    workloadState:"",
    workloadId:''
  };

  Inprogress(workloadId: string) {
this.WorkloadData.workloadState="IN_PROGRESS"
this.WorkloadData.workloadId=workloadId
    this.myApiService.UpdataWorkload(workloadId,this.WorkloadData).subscribe(data=>{
      console.log(data)
    })
  }

  Done(workloadId: any) {
    this.WorkloadData.workloadState = "DONE";
    this.WorkloadData.workloadId = workloadId;
    this.myApiService.UpdataWorkload(workloadId, this.WorkloadData).subscribe(data => {
      console.log(data);

      // Get skills associated with the workload
      this.myApiService.getWorkloadSkills(workloadId).subscribe(skillDataList => {
        console.log(skillDataList);

        for (const skillData of skillDataList) {
          // Get the skillId
          // @ts-ignore
          const skillId = skillData.skill_id;

          // Get userSkillId using the getUserSkillId API
          // @ts-ignore
          this.myApiService.getUserSkillID(skillId, this.user).subscribe(userSkill => {
            console.log("userSkill",userSkill);
            // @ts-ignore
            const newProficiency = Math.min(userSkill.proficiency+1, 5);            // Update the userSkill using the updateUserSkill API
            // @ts-ignore

            const updatedUserSkill = {
              // @ts-ignore
              user_skill_id: userSkill.user_skill_id,
              // @ts-ignore
              proficiency:newProficiency
              // Construct the updated UserSkill object as needed
            };
            console.log("updatedUserSkill",updatedUserSkill)

            this.myApiService.UpdateUserskill(updatedUserSkill.user_skill_id,updatedUserSkill).subscribe(result => {
              console.log(result);
            });
          });
        }
      });
    });
  }

  FAILED(workloadId: any) {
    this.WorkloadData.workloadState = "FAILED";
    this.WorkloadData.workloadId = workloadId;
    this.myApiService.UpdataWorkload(workloadId, this.WorkloadData).subscribe(data => {
      console.log(data);

      // Get skills associated with the workload
      this.myApiService.getWorkloadSkills(workloadId).subscribe(skillDataList => {
        console.log(skillDataList);

        for (const skillData of skillDataList) {
          // Get the skillId
          // @ts-ignore
          const skillId = skillData.skill_id;

          // Get userSkillId using the getUserSkillId API
          // @ts-ignore
          this.myApiService.getUserSkillID(skillId, this.user).subscribe(userSkill => {
            console.log("userSkill",userSkill);
            // @ts-ignore
            const newProficiency = Math.max(userSkill.proficiency-1, 0);            // Update the userSkill using the updateUserSkill API
            // @ts-ignore

            const updatedUserSkill = {
              // @ts-ignore
              user_skill_id: userSkill.user_skill_id,
              // @ts-ignore
              proficiency:newProficiency
              // Construct the updated UserSkill object as needed
            };
            console.log("updatedUserSkill",updatedUserSkill)

            this.myApiService.UpdateUserskill(updatedUserSkill.user_skill_id,updatedUserSkill).subscribe(result => {
              console.log(result);
            });
          });
        }
      });
    });
  }




}
