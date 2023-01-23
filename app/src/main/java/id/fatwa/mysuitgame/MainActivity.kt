package id.fatwa.mysuitgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
	private lateinit var btnRock: ImageView
	private lateinit var btnPaper: ImageView
	private lateinit var btnScissor: ImageView
	private lateinit var comPaper: ImageView
	private lateinit var comRock: ImageView
	private lateinit var comScissor: ImageView
	
	private lateinit var result: TextView
	private lateinit var btnReset: ImageView
	
	private var choice: List<String> = listOf("Batu", "Gunting", "Kertas")
	
	private var selected: String = ""
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)
		
		result = findViewById(R.id.result)
		
		btnReset = findViewById(R.id.reset)
		btnReset.setOnClickListener(this)
		
		btnPaper = findViewById(R.id.player_kertas)
		btnPaper.setOnClickListener(this)
		
		btnRock = findViewById(R.id.player_batu)
		btnRock.setOnClickListener(this)
		
		btnScissor = findViewById(R.id.player_gunting)
		btnScissor.setOnClickListener(this)
		
		comPaper = findViewById(R.id.computer_kertas)
		comRock = findViewById(R.id.computer_batu)
		comScissor = findViewById(R.id.computer_gunting)
	}
	
	private fun matching(playerOne: String, computer: String) {
		if (playerOne.lowercase() == computer.lowercase()) {
			result.setText("DRAW!")
		} else if (playerOne.lowercase() == "batu") {
			if (computer.lowercase() == "gunting") {
				result.setText("Pemain 1 MENANG!")
			} else {
				result.setText("Pemain 2 MENANG!")
			}
		} else if (playerOne.lowercase() == "gunting") {
			if (computer.lowercase() == "kertas") {
				result.setText("Pemain 1 MENANG!")
			} else {
				result.setText("Pemain 2 MENANG!")
			}
		} else if (playerOne.lowercase() == "kertas") {
			if (computer.lowercase() == "batu") {
				result.setText("Pemain 1 MENANG!")
			} else {
				result.setText("Pemain 2 MENANG!")
			}
		}
	}
	
	override fun onClick(v: View?) {
		val size = choice.size - 1
		val randomIndex = (0..size).random()
		val computerSelected: String = choice[randomIndex]
		
		when (v?.id) {
			R.id.player_batu -> {
				selected = "Batu"
				btnRock.setBackgroundResource(R.drawable.bg_active)
				btnPaper.setBackgroundColor(android.R.color.transparent)
				btnScissor.setBackgroundColor(android.R.color.transparent)
				when (randomIndex) {
					0 -> {
						comRock.setBackgroundResource(R.drawable.bg_active)
						comPaper.setBackgroundColor(android.R.color.transparent)
						comScissor.setBackgroundColor(android.R.color.transparent)
					}
					1 -> {
						comScissor.setBackgroundResource(R.drawable.bg_active)
						comPaper.setBackgroundColor(android.R.color.transparent)
						comRock.setBackgroundColor(android.R.color.transparent)
					}
					else -> {
						comPaper.setBackgroundResource(R.drawable.bg_active)
						comScissor.setBackgroundColor(android.R.color.transparent)
						comRock.setBackgroundColor(android.R.color.transparent)
					}
				}
				matching(selected, computerSelected)
				btnRock.setEnabled(false);
				btnPaper.setEnabled(false);
				btnScissor.setEnabled(false);
			}
			R.id.player_gunting -> {
				selected = "Gunting"
				btnScissor.setBackgroundResource(R.drawable.bg_active)
				btnRock.setBackgroundColor(android.R.color.transparent)
				btnPaper.setBackgroundColor(android.R.color.transparent)
				when (randomIndex) {
					0 -> {
						comRock.setBackgroundResource(R.drawable.bg_active)
						comPaper.setBackgroundColor(android.R.color.transparent)
						comScissor.setBackgroundColor(android.R.color.transparent)
					}
					1 -> {
						comScissor.setBackgroundResource(R.drawable.bg_active)
						comPaper.setBackgroundColor(android.R.color.transparent)
						comRock.setBackgroundColor(android.R.color.transparent)
					}
					else -> {
						comPaper.setBackgroundResource(R.drawable.bg_active)
						comScissor.setBackgroundColor(android.R.color.transparent)
						comRock.setBackgroundColor(android.R.color.transparent)
					}
				}
				matching(selected, computerSelected)
				btnRock.setEnabled(false);
				btnPaper.setEnabled(false);
				btnScissor.setEnabled(false);
			}
			R.id.player_kertas -> {
				selected = "Kertas"
				btnPaper.setBackgroundResource(R.drawable.bg_active)
				btnScissor.setBackgroundColor(android.R.color.transparent)
				btnRock.setBackgroundColor(android.R.color.transparent)
				when (randomIndex) {
					0 -> {
						comRock.setBackgroundResource(R.drawable.bg_active)
						comPaper.setBackgroundColor(android.R.color.transparent)
						comScissor.setBackgroundColor(android.R.color.transparent)
					}
					1 -> {
						comScissor.setBackgroundResource(R.drawable.bg_active)
						comPaper.setBackgroundColor(android.R.color.transparent)
						comRock.setBackgroundColor(android.R.color.transparent)
					}
					else -> {
						comPaper.setBackgroundResource(R.drawable.bg_active)
						comScissor.setBackgroundColor(android.R.color.transparent)
						comRock.setBackgroundColor(android.R.color.transparent)
					}
				}
				matching(selected, computerSelected)
				btnRock.setEnabled(false);
				btnPaper.setEnabled(false);
				btnScissor.setEnabled(false);
			}
			R.id.reset -> {
				btnRock.setBackgroundColor(android.R.color.transparent)
				btnPaper.setBackgroundColor(android.R.color.transparent)
				btnScissor.setBackgroundColor(android.R.color.transparent)
				comRock.setBackgroundColor(android.R.color.transparent)
				comPaper.setBackgroundColor(android.R.color.transparent)
				comScissor.setBackgroundColor(android.R.color.transparent)
				result.setText("VS")
				btnRock.setEnabled(true);
				btnPaper.setEnabled(true);
				btnScissor.setEnabled(true);
			}
		}
	}
}