package com.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.paintapp.PaintView.Companion.colorList
import com.paintapp.PaintView.Companion.pathList
import com.paintapp.common.extensions.showToast
import com.paintapp.PaintView.Companion.selectedBrushColor
import com.paintapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object {
        var path = Path()
        var brush = Paint()
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        registerEvents()
    }

    private fun registerEvents() {
        binding.redColorPalette.setOnClickListener(redPaletteColorClickListener)
        binding.greenColorPalette.setOnClickListener(greenPaletteColorClickListener)
        binding.blueColorPalette.setOnClickListener(bluePaletteColorClickListener)
        binding.purpleColorPalette.setOnClickListener(purplePaletteColorClickListener)
        binding.blackColorPalette.setOnClickListener(blackPaletteColorClickListener)
        binding.eraser.setOnClickListener(eraserClickListener)
    }

    private val redPaletteColorClickListener = View.OnClickListener {
        showToast("Red Color Selected")
        brush.color = Color.RED
        currentColor(brush.color)
    }

    private val greenPaletteColorClickListener = View.OnClickListener {
        showToast("Green Color Selected")
        brush.color = Color.GREEN
        currentColor(brush.color)
    }

    private val bluePaletteColorClickListener = View.OnClickListener {
        showToast("Blue Color Selected")
        brush.color = Color.BLUE
        currentColor(brush.color)
    }

    private val purplePaletteColorClickListener = View.OnClickListener {
        showToast("Purple Color Selected")
        brush.color = Color.argb(100,148, 3, 252)
        currentColor(brush.color)
    }

    private val blackPaletteColorClickListener = View.OnClickListener {
        showToast("Black Color Selected")
        brush.color = Color.BLACK
        currentColor(brush.color)
    }

    private val eraserClickListener = View.OnClickListener {
        showToast("Eraser Selected")
        pathList.clear()
        colorList.clear()
        path.reset()
    }

    private fun currentColor(color : Int){
        selectedBrushColor = color
        path = Path()
    }
}