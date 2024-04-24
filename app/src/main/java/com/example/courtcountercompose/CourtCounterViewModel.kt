package com.example.courtcountercompose

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class CourtCounterViewModel: ViewModel() {
    private var _scoreA = MutableStateFlow(0)
    private var _scoreB = MutableStateFlow(0)
    val scoreA: StateFlow<Int>
        get() = _scoreA.asStateFlow()
    val scoreB: StateFlow<Int>
        get() = _scoreB.asStateFlow()

    fun countAFreeThrowShot() {
        _scoreA.update {
            it + 1
        }
    }

    fun countBFreeThrowShot() {
        _scoreB.update {
            it + 1
        }
    }
    fun countAShot() {
        _scoreA.update {
            it + 2
        }
    }

    fun countBShot() {
        _scoreB.update {
            it + 2
        }
    }

    fun countAThreePointShot() {
        _scoreA.update {
            it + 3
        }
    }

    fun countBThreePointShot() {
        _scoreB.update {
            it + 3
        }
    }

    fun resetGame() {
        _scoreA.update { 0 }
        _scoreB.update { 0 }
    }
}