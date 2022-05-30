import { Component, OnInit } from '@angular/core';
import { MatDialog, MatDialogConfig } from '@angular/material/dialog';
import { ActivatedRoute } from '@angular/router';
import { InfoDialogComponent } from 'src/app/shared/components/info-dialog/info-dialog.component';
import { UpdateExperienceEducationDialogComponent } from './components/update-experience-education-dialog/update-experience-education-dialog.component';
import { UpdateProfileDialogComponent } from './components/update-profile-dialog/update-profile-dialog.component';
import { UpdateSkillsInterestsDialogComponent } from './components/update-skills-interests-dialog/update-skills-interests-dialog.component';
import { ProfileService } from './services/profile.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  profile: any;

  constructor(private route: ActivatedRoute, private profileService: ProfileService, private dialog: MatDialog) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(params => {
      this.profileService.getProfile(params.get('username')).subscribe(
        data => {
          this.profile = data;
        }
      )
    })
  }


  openUpdateProfileDialog(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = {
      profile: this.profile
    };
    const dialogRef = this.dialog.open(UpdateProfileDialogComponent, dialogConfig);
    dialogRef.componentInstance.okay.subscribe(res => {
      if(res.success){
        this.profile = res.success;
        const dialogConfig = new MatDialogConfig();
        dialogConfig.data = {
          title: "Successful",
          message: "You have successfully updated your info.",
          buttonText: "Okay",
        };
        this.dialog.open(InfoDialogComponent, dialogConfig);
      } else {
        if (res.error.status == 401){
          const dialogConfig = new MatDialogConfig();
          dialogConfig.data = {
            title: "Unauthorized",
            message: "You do not have the permission to do this",
            buttonText: "Okay",
          };
          this.dialog.open(InfoDialogComponent, dialogConfig);
        } else {
          const dialogConfig = new MatDialogConfig();
          dialogConfig.data = {
            title: "User not found",
            message: "The user could not be found in our records.",
            buttonText: "Okay",
          };
          this.dialog.open(InfoDialogComponent, dialogConfig);
        }

      }
    })
  }


  openUpdateSkillsDialog(): void{
    const dialogConfig = new MatDialogConfig();
    dialogConfig.data = {
      skills: this.profile.skills,
      interests: this.profile.interests
    };
    this.dialog.open(UpdateSkillsInterestsDialogComponent, dialogConfig);
  }

  openUpdateExperienceDialog(): void{
    const dialogConfig = new MatDialogConfig();
    
    this.dialog.open(UpdateExperienceEducationDialogComponent, dialogConfig);
  }
}
