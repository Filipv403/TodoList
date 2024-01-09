package com.example.todolist

import java.util.Date

class Item(Subject: String, Description: String, RealizationDate: Date) {
    var Id: Int = 1;
    var Subject: String = "";
    var Description: String = "";
    var RealizationDate: Date = Date();
    var Completed: Boolean = false;
    var Validity: Boolean = true;
}