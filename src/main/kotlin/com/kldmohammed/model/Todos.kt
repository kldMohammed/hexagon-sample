package com.kldmohammed.model

import org.jetbrains.exposed.sql.ResultRow
import org.jetbrains.exposed.sql.Table

object Todos : Table(name = "todo") {
    var id = integer("id").primaryKey().autoIncrement()
    var title = varchar("title", 250)
    var description = text("description")
}


data class Todo(val id: Int, val title: String, val description: String)


//class used to read params from request
data class NewTodo(val title: String, val description: String)

fun Todos.toDomain(row: ResultRow) = Todo(row[id], row[title], row[description])


