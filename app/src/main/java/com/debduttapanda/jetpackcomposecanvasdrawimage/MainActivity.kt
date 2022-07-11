package com.debduttapanda.jetpackcomposecanvasdrawimage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Matrix
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.graphics.withSaveLayer
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.debduttapanda.jetpackcomposecanvasdrawimage.ui.theme.JetpackComposeCanvasDrawImageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeCanvasDrawImageTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val vector = ImageVector.vectorResource(id = R.drawable.ic_drawing)//drawable vector
                    val painter = rememberVectorPainter(image = vector)//convert to painter
                    /////////////////////
                    val image = ImageBitmap.imageResource(id = R.drawable.dog)//raster image
                    Canvas(
                        modifier = Modifier
                    ){
                        //draw the vector
                        withTransform(
                            {
                                //rotate(45f)
                                //translate(100f,50f)
                                //scale(1f,2f)
                                transform(
                                    Matrix().apply {
                                        rotateZ(0f)//good
                                        scale(2f,2f)
                                        translate(150f,75f)
                                    }
                                )
                            }
                        ){
                            //translate(
                            //    100f,50f
                            //) {
                            //    rotate(45f){
                            //        scale(
                            //            1f,1f
                            //        ){
                                        with(painter) {
                                            draw(
                                                painter.intrinsicSize
                                            )
                                        }
                            //        }
                            //    }
                            //}



                            drawImage(
                                image = image,
                                topLeft = Offset(x = 150f, y = 500f)
                            )
                        }
                        drawImage(
                            image = image,
                            topLeft = Offset(x = 150f, y = 500f)
                        )

                        with(painter) {
                            draw(
                                painter.intrinsicSize
                            )
                        }
                    }
                }
            }
        }
    }
}