package com.example.todolist

import java.util.Date

class Item(Subject: String, RealizationDate: Date) {
    var Id: Int = 1;
    var Subject: String = "";
    var RealizationDate: Date = Date();
    var Completed: Boolean = false;
    var Validity: Boolean = true;
}