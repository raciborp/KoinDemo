package com.roche.koindemo

interface FakeApi {
    val status: String
}

class FakeApiImpl : FakeApi {
    override val status: String
        get() = "Fake status"
}