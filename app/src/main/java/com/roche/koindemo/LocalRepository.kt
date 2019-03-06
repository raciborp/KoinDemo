package com.roche.koindemo

interface LocalRepository {
    fun saveText(text: String)
    val text: String
}

class LocalRepositoryImpl : LocalRepository {

    private var savedText = ""

    override fun saveText(text: String) {
        savedText = text
    }

    override val text: String
        get() = savedText

}