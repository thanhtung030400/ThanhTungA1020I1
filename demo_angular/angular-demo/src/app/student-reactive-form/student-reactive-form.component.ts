import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {studentDao} from "../StudentDao";

@Component({
  selector: 'app-student-reactive-form',
  templateUrl: './student-reactive-form.component.html',
  styleUrls: ['./student-reactive-form.component.css']
})
export class StudentReactiveFormComponent implements OnInit {
  createStudentForm!:FormGroup ;
  constructor(private  fb:FormBuilder  ) { }

  ngOnInit(): void {
    // this.createStudentForm= new FormGroup({
    //   id: new FormControl('', [Validators.required]),
    //   name: new FormControl(''),
    //   age: new FormControl(''),
    //   address: new FormControl(''),
    //   avatar: new FormControl(''),
    //   mark: new FormControl('')
    // })
    this.createStudentForm= this.fb.group({
      id:['',[Validators.required, Validators.min(5)]],
      name: ['', [Validators.required]],
      age:['',[Validators.required]],
      address:['',[Validators.required]],
      avatar:['',[Validators.required]],
      mark:['',[Validators.required]]
    })
  }

  createStudent() {
    studentDao.unshift(this.createStudentForm.value);
  }
}
