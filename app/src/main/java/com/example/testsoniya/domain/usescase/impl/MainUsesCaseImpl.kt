package com.example.testsoniya.domain.usescase.impl

import com.example.testsoniya.domain.repository.MainRepository
import com.example.testsoniya.domain.usescase.MainUsesCase
import javax.inject.Inject

class MainUsesCaseImpl @Inject constructor(private val mainRepository: MainRepository) : MainUsesCase {
    override fun getCharacters() = mainRepository.getAllCharacter()
    override fun findCharacter(name : String) = mainRepository.searchCharacter(name)
}