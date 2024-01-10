package com.example.todolist

import java.util.Date

class Item(Subject: String, Description: String) {
    var Id: Int = 1;
    var Subject: String = Subject;
    var Description: String = Description;
    //var RealizationDate: Date = Date();
    var Completed: Boolean = false;
    var Validity: Boolean = true;
}