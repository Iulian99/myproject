package com.example.mhealthapplication.ConsumFragment

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.graphics.scale
import androidx.fragment.app.Fragment
import com.example.mhealthapplication.R
import com.example.mhealthapplication.TFLiteModel
import java.nio.ByteBuffer
import java.nio.ByteOrder

class ConsumFragment : Fragment() {

    private lateinit var model: TFLiteModel
    private lateinit var imageViewUpload: ImageView
    private lateinit var result: TextView
    private val pickImageLauncher =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            uri?.let {
                val bitmap = MediaStore.Images.Media.getBitmap(requireContext().contentResolver, it)
                imageViewUpload.setImageBitmap(bitmap)
                runModel(bitmap)
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_consum, container, false)

        imageViewUpload = view.findViewById(R.id.imageViewUpload)
        result = view.findViewById(R.id.result)

        imageViewUpload.setOnClickListener {
            pickImageLauncher.launch("image/*")
        }

        model = TFLiteModel(requireContext())

        return view
    }

    private fun runModel(bitmap: Bitmap) {
        val inputBuffer = convertBitmapToByteBuffer(bitmap)
//      Change 4
        val output = Array(1) { FloatArray(4) }

        model.interpreter.run(inputBuffer, output)

        val predictedIndex = getPredictionResult(output)
        val predictedLabel = getLabel(predictedIndex)
        result.text = predictedLabel
        Toast.makeText(requireContext(), "Predictie: $predictedLabel", Toast.LENGTH_SHORT).show()
    }

//  "Apple", "Kiwi", "Mango", "Orange"
    private fun getLabel(index: Int): String {
//      change label
        val labels = listOf("Apple", "Kiwi", "Mango", "Orange")
        return if (index in labels.indices) labels[index] else "Necunoscut"
//        if (index in labels.indices) {
//            return labels[index]
//        } else return "Necunoscut"

    }

    private fun getPredictionResult(output: Array<FloatArray>): Int {
        return output[0].indices.maxByOrNull { output[0][it] } ?: -1
    }

    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer {
//      dimensiunea imaginii
        val inputSize = 224
//      stocarea valorile pixelilor
        val byteBuffer = ByteBuffer.allocateDirect(4 * inputSize * inputSize * 3)  // 4 bytes per float, 3 (RGB)
        byteBuffer.order(ByteOrder.nativeOrder())
//      redimensionarea imaginii
        val resizedBitmap = bitmap.scale(inputSize, inputSize)
//      se extrag valorile de culoare pentru fiecare pixel
        val intValues = IntArray(inputSize * inputSize)
        resizedBitmap.getPixels(intValues, 0, inputSize, 0, 0, inputSize, inputSize)

//      conversia valorilor pixelilor intr-u ByteBuffer
        for (pixelValue in intValues) {
            byteBuffer.putFloat(((pixelValue shr 16) and 0xFF) / 255.0f)  // R
            byteBuffer.putFloat(((pixelValue shr 8) and 0xFF) / 255.0f)   // G
            byteBuffer.putFloat((pixelValue and 0xFF) / 255.0f)           // B
        }
        return byteBuffer
    }
}