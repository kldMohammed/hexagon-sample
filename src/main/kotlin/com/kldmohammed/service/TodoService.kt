package com.kldmohammed.service

import com.kldmohammed.ext.dbQuery
import com.kldmohammed.model.NewTodo
import com.kldmohammed.model.Todos
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.statements.InsertStatement

class TodoService {

    suspend fun getAll() = dbQuery { Todos.selectAll() }

    suspend fun getById(id: Int) = dbQuery { Todos.select { Todos.id eq id } }


    suspend fun new(todo: NewTodo) = dbQuery {
        val id: Int = Todos.insert {
            it[title] = todo.title
            it[description] = todo.description
        } get Todos.id
    }
}