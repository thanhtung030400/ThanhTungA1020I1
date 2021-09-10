import { Component, OnInit } from '@angular/core';
import {IStudent} from "../IStudent";

@Component({
  selector: 'app-student-information',
  templateUrl: './student-information.component.html',
  styleUrls: ['./student-information.component.css']
})
export class StudentInformationComponent implements OnInit {
studentInformation: IStudent={
  id:1,
  name:'tung',
  age:21,
  address:'da nang',
  avatar: 'https://www.w3schools.com/howto/img_avatar2.png',
  mark:5

}
  constructor() { }

  ngOnInit(): void {
  }
  changeMark(mark:number){
    this.studentInformation.mark = mark;
  }

}
