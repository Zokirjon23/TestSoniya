package com.example.testsoniya.domain.usescase.impl

import com.example.testsoniya.domain.repository.MainRepository
import com.example.testsoniya.domain.usescase.DetailUsesCase
import javax.inject.Inject

class DetailUsesCaseImpl @Inject constructor(private val mainRepository: MainRepository) : DetailUsesCase {
}