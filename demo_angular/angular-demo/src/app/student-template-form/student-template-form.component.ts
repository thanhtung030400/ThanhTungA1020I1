import { Component, OnInit } from '@angular/core';
import {NgForm} from "@angular/forms";
import {studentDao} from "../StudentDao";
import {IStudent} from "../IStudent";

@Component({
  selector: 'app-student-template-form',
  templateUrl: './student-template-form.component.html',
  styleUrls: ['./student-template-form.component.css']
})
export class StudentTemplateFormComponent implements OnInit {
studentEdit:IStudent={
  id:10,
  name:"student",
  age: 20,
  avatar:'',
  mark:10,
  address:'quang tri'
}
  constructor() { }

  ngOnInit(): void {
  }

  createStudent(studentForm: NgForm) {
    studentDao.push(studentForm.value)
    console.log(studentForm.value);
  }
}
