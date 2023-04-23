// This code is a modification of an existing project
// link to the project: https://github.com/rudrajikadra/TicTacToe-Game-Android-Kotlin

package com.example.tic_tac_toe

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.tic_tac_toe.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    var playerName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Show the greeting layout and hide the Tic Tac Toe layout
        binding.greetingLayout.root.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.root.visibility = android.view.View.GONE

        // Set a click listener on the "Start Game" button
        binding.greetingLayout.buttonSubmit.setOnClickListener {

            // Get the user's name from the text input
            playerName = binding.greetingLayout.editTextName.text.toString()

            // Display a welcome message with the user's name
            binding.greetingLayout.welcomeMessage.text = "Welcome, ${playerName}! Click next button to play"
            binding.greetingLayout.buttonSubmit.visibility = android.view.View.GONE
            binding.greetingLayout.editTextName.visibility = android.view.View.GONE
            binding.greetingLayout.nextButton.visibility = android.view.View.VISIBLE
        }

        binding.greetingLayout.nextButton.setOnClickListener {

            // Hide the greeting layout and show the Tic Tac Toe layout
            binding.greetingLayout.root.visibility = android.view.View.GONE
            binding.ticTacToeLayout.root.visibility = android.view.View.VISIBLE
            binding.ticTacToeLayout.button1.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button2.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button3.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button4.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button5.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button6.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button7.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button8.visibility = android.view.View.INVISIBLE
            binding.ticTacToeLayout.button9.visibility = android.view.View.INVISIBLE

            binding.ticTacToeLayout.PVP.setBackgroundColor(Color.CYAN)
            binding.ticTacToeLayout.PVC.setBackgroundColor(Color.CYAN)

        }
    }

    var Player1 = ArrayList<Int>()
    var Player2 = ArrayList<Int>()
    var ActivePlayer = 1
    var setPlayer = 1

    fun restartGame(view: View)
    {
        binding.ticTacToeLayout.button1.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button2.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button3.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button4.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button5.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button6.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button7.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button8.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button9.setBackgroundResource(android.R.drawable.btn_default)

        binding.ticTacToeLayout.button1.text = ""
        binding.ticTacToeLayout.button2.text = ""
        binding.ticTacToeLayout.button3.text = ""
        binding.ticTacToeLayout.button4.text = ""
        binding.ticTacToeLayout.button5.text = ""
        binding.ticTacToeLayout.button6.text = ""
        binding.ticTacToeLayout.button7.text = ""
        binding.ticTacToeLayout.button8.text = ""
        binding.ticTacToeLayout.button9.text = ""

        Player1.clear()
        Player2.clear()
        ActivePlayer = 1

        binding.ticTacToeLayout.button1.isEnabled = true
        binding.ticTacToeLayout.button2.isEnabled = true
        binding.ticTacToeLayout.button3.isEnabled = true
        binding.ticTacToeLayout.button4.isEnabled = true
        binding.ticTacToeLayout.button5.isEnabled = true
        binding.ticTacToeLayout.button6.isEnabled = true
        binding.ticTacToeLayout.button7.isEnabled = true
        binding.ticTacToeLayout.button8.isEnabled = true
        binding.ticTacToeLayout.button9.isEnabled = true

        binding.ticTacToeLayout.button1.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button2.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button3.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button4.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button5.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button6.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button7.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button8.visibility = android.view.View.INVISIBLE
        binding.ticTacToeLayout.button9.visibility = android.view.View.INVISIBLE

        binding.ticTacToeLayout.PVP.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.PVP.setBackgroundColor(Color.CYAN)

        binding.ticTacToeLayout.PVC.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.PVC.setBackgroundColor(Color.CYAN)

    }

    fun buttonClick(view: View)
    {
        val buSelected:Button = view as Button
        var cellId = 0
        when(buSelected.id)
        {
            R.id.button1 -> cellId = 1
            R.id.button2 -> cellId = 2
            R.id.button3 -> cellId = 3

            R.id.button4 -> cellId = 4
            R.id.button5 -> cellId = 5
            R.id.button6 -> cellId = 6

            R.id.button7 -> cellId = 7
            R.id.button8 -> cellId = 8
            R.id.button9 -> cellId = 9
        }
        PlayGame(cellId,buSelected)

    }

    fun PlayerChoose(view:View)
    {
        val ps:Button = view as Button
        when(ps.id)
        {
            R.id.PVP -> {
                setPlayer = 1
                ps.setBackgroundColor(Color.CYAN)
                binding.ticTacToeLayout.PVC.visibility = android.view.View.GONE
            }
            R.id.PVC -> {
                setPlayer = 2
                ps.setBackgroundColor(Color.CYAN)
                binding.ticTacToeLayout.PVP.visibility = android.view.View.GONE
            }
        }
        binding.ticTacToeLayout.button1.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button2.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button3.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button4.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button5.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button6.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button7.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button8.visibility = android.view.View.VISIBLE
        binding.ticTacToeLayout.button9.visibility = android.view.View.VISIBLE

        binding.ticTacToeLayout.button1.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button2.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button3.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button4.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button5.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button6.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button7.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button8.setBackgroundResource(android.R.drawable.btn_default)
        binding.ticTacToeLayout.button9.setBackgroundResource(android.R.drawable.btn_default)
    }

    fun PlayGame(cellId:Int,buSelected:Button)
    {
        if (ActivePlayer == 1)
        {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.GREEN)
            Player1.add(cellId)
            ActivePlayer = 2
            if (setPlayer == 1)
            {}
            else
            {
                try {
                    AutoPlay()
                }catch (ex:Exception)
                {
                    Toast.makeText(this,"Game Over",Toast.LENGTH_SHORT).show()
                }
            }
        }
        else
        {
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.BLUE)
            Player2.add(cellId)
            ActivePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()

        // check if all cells are filled with no winner
        if (Player1.size + Player2.size == 9 && !checkWinner())
        {
            Toast.makeText(this, "Draw", Toast.LENGTH_SHORT).show()
        }
    }

    fun checkWinner() : Boolean
    {
        val winnerList = arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9),
            arrayOf(1,4,7), arrayOf(2,5,8), arrayOf(3,6,9),
            arrayOf(1,5,9), arrayOf(3,5,7))
        for (winner in winnerList)
        {
            if (Player1.contains(winner[0]) && Player1.contains(winner[1]) && Player1.contains(winner[2]))
            {
                Toast.makeText(this, "${playerName} won the game!", Toast.LENGTH_SHORT).show()
                return true
            }
            else if (Player2.contains(winner[0]) && Player2.contains(winner[1]) && Player2.contains(winner[2]))
            {
                Toast.makeText(this, "Rival won the game!", Toast.LENGTH_SHORT).show()
                return true
            }
        }
        return false
    }

    fun stopTouch()
    {
        binding.ticTacToeLayout.button1.isEnabled = false
        binding.ticTacToeLayout.button2.isEnabled = false
        binding.ticTacToeLayout.button3.isEnabled = false
        binding.ticTacToeLayout.button4.isEnabled = false
        binding.ticTacToeLayout.button5.isEnabled = false
        binding.ticTacToeLayout.button6.isEnabled = false
        binding.ticTacToeLayout.button7.isEnabled = false
        binding.ticTacToeLayout.button8.isEnabled = false
        binding.ticTacToeLayout.button9.isEnabled = false
    }

    fun AutoPlay()
    {
        val emptyCells = ArrayList<Int>()
        for (cellId in 1..9) {
            if (Player1.contains(cellId) || Player2.contains(cellId))
            {}
            else
            {
                emptyCells.add(cellId)
            }
        }

        val r = Random()
        val randomIndex = r.nextInt(emptyCells.size-0)+0
        val cellId = emptyCells[randomIndex]

        val buSelect:Button?
        when(cellId)
        {
            1 -> buSelect = binding.ticTacToeLayout.button1
            2 -> buSelect = binding.ticTacToeLayout.button2
            3 -> buSelect = binding.ticTacToeLayout.button3
            4 -> buSelect = binding.ticTacToeLayout.button4
            5 -> buSelect = binding.ticTacToeLayout.button5
            6 -> buSelect = binding.ticTacToeLayout.button6
            7 -> buSelect = binding.ticTacToeLayout.button7
            8 -> buSelect = binding.ticTacToeLayout.button8
            9 -> buSelect = binding.ticTacToeLayout.button9
            else -> buSelect = binding.ticTacToeLayout.button1
        }

        PlayGame(cellId,buSelect)
    }
}