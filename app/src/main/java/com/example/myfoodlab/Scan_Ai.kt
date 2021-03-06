package com.example.myfoodlab

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.myfoodlab.ml.MobilenetV110224Quant
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer

class Scan_Ai : AppCompatActivity() {
    lateinit var select_image_button : ImageView
    lateinit var make_prediction : ConstraintLayout
    lateinit var img_view : ImageView
    lateinit var text_view : TextView
    private var bitmap: Bitmap? = null
    lateinit var camerabtn : ImageView

    fun checkandGetpermissions(){
        if(checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED){
            requestPermissions(arrayOf(android.Manifest.permission.CAMERA), 100)
        }
        else{
            Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan_ai)

        select_image_button = findViewById(R.id.selectbtn)
        make_prediction = findViewById(R.id.predictionbtn)
        img_view = findViewById(R.id.imageai)
        text_view = findViewById(R.id.textView423)
        camerabtn = findViewById(R.id.camerabtn)

        // handling permissions
        checkandGetpermissions()

        val labels = application.assets.open("labels2.txt").bufferedReader().use { it.readText() }.split("\n")

        select_image_button.setOnClickListener(View.OnClickListener {
            Log.d("mssg", "button pressed")
            var intent : Intent = Intent(Intent.ACTION_GET_CONTENT)
            intent.type = "image/*"

            startActivityForResult(intent, 250)
        })

        make_prediction.setOnClickListener{
            when (bitmap == null){
                true -> {

                    Toast.makeText(this@Scan_Ai,"???????????????????????????????????????????????????????????????????????????????????????", Toast.LENGTH_SHORT).show()
                }
                false -> {
                    val resized = Bitmap.createScaledBitmap(bitmap!! , 224,224, true)
                    val model = MobilenetV110224Quant.newInstance(this)
                    val tbuffer = TensorImage.fromBitmap(resized)
                    val byteBuffer = tbuffer.buffer

// Creates inputs for reference.
                    //val shape = intArrayOf(224, 224)
                    val inputFeature0 = TensorBuffer.createFixedSize(intArrayOf(1, 224, 224, 3), DataType.UINT8)
                    //val inputFeature0 = TensorBuffer.createFixedSize(shape, DataType.UINT8)
                    Log.d("shape", byteBuffer.toString())
                    Log.d("shape", inputFeature0.buffer.toString())

                    inputFeature0.loadBuffer(byteBuffer)

// Runs model inference and gets result.
                    val outputs = model.process(inputFeature0)
                    val outputFeature0 = outputs.outputFeature0AsTensorBuffer

                    val max = getMax(outputFeature0.floatArray)

                    text_view.setText(labels[max])
// Releases model resources if no longer used.
                    model.close()
                }
            }


        }


        camerabtn.setOnClickListener(View.OnClickListener {
            val camera : Intent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(camera, 200)
        })


    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        /*if (data?.clipData != null){*/

        if(requestCode == 250){
            when(data?.data != null){
                true -> {
                    img_view.setImageURI(data?.data)
                    val uri : Uri ?= data?.data
                    bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                    text_view.text = ""
                }

                false -> {
                    img_view.setImageURI(null)
                    img_view.setImageBitmap(null)
                    bitmap = null
                    img_view.setImageResource(R.drawable.camera_ai)
                    text_view.text = "Choose image"


                }
            }
            /*img_view.setImageURI(data?.data)
            var uri : Uri ?= data?.data
            bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)*/
        } else if(requestCode == 200 && resultCode == Activity.RESULT_OK ){
            bitmap = data?.extras?.get("data") as Bitmap
            img_view.setImageBitmap(bitmap)
            text_view.text = ""
        } else{
            img_view.setImageURI(null)
            img_view.setImageBitmap(null)
            bitmap = null
            img_view.setImageResource(R.drawable.camera_ai)
            text_view.text = "Choose image"
        }

        //}

        /*else{
            img_view.setImageBitmap("")
        }*/


    }



    fun getMax(arr:FloatArray) : Int{
        var ind = 0;
        var min = 0.0f;

        for(i in 0..1000)
        {
            if(arr[i] > min)
            {
                min = arr[i]
                ind = i;
            }
        }
        return ind
    }
}