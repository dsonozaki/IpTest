package com.sonozaki.iptest.domain

interface Mapper<T, S> {
    fun map(from: T): S
}