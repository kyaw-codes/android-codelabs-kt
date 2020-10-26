package com.example.android.guesstheword.screens.game

import android.os.CountDownTimer
import android.text.format.DateUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {

    private var _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    val wordHint: LiveData<String> = Transformations.map(word) { word ->
        val randomPosition = (1 until word.length).random()
        "Current word has ${word.length} letters\nThe letter at position $randomPosition is ${word[randomPosition]}"
    }

    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private var _gameFinished = MutableLiveData<Boolean>()
    val eventGameFinished
        get() = _gameFinished

    private lateinit var wordList: MutableList<String>

    // Countdown time
    private val _currentTime = MutableLiveData<Long>()
    private val currentTime: LiveData<Long>
        get() = _currentTime

    // The string version of the current time
    val currentTimeString: LiveData<String> = Transformations.map(currentTime) { time -> DateUtils.formatElapsedTime(time) }

    private val timer: CountDownTimer

    companion object {
        // Time when the game is over
        private const val DONE = 0L
        // Countdown time interval
        private const val ONE_SECOND = 1000L
        // Total time for the game
        private const val COUNTDOWN_TIMER = 60000L
    }

    init {

        _word.value = ""
        _score.value = 0

        timer = object: CountDownTimer(COUNTDOWN_TIMER, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = millisUntilFinished / ONE_SECOND
            }

            override fun onFinish() {
                _currentTime.value = DONE
                onGameFinish()
            }
        }

        timer.start()
        resetList()
        nextWord()
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        // Shuffle the word list, if the list is empty
        if (wordList.isEmpty()) {
            // onGameFinish()
            resetList()
        } else {
            // Select and remove a word from the list
            _word.value = wordList.removeAt(0)
        }
    }

    fun onSkip() {
        _score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = score.value?.plus(1)
        nextWord()
    }

    fun onGameFinish() {
        _gameFinished.value = true
        onGameFinishComplete()
    }

    private fun onGameFinishComplete() {
        _gameFinished.value = false
    }

    override fun onCleared() {
        super.onCleared()

        timer.cancel()
    }


}