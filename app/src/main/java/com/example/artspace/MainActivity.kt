package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

data class Picture(
    val name: String,
    val imagen: Int,
    val dimensions: String,
    val style: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceTheme {
                ArtSpaceApp()
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    val pictures = listOf(
        Picture(
            name = "Cádiz",
            imagen = R.drawable.cadiz,
            dimensions = "50 x 80 cm",
            style = "Óleo"
        ),
        Picture(
            name = "Interior Bodega",
            imagen = R.drawable.interior_bodega,
            dimensions = "35 x 50 cm",
            style = "Carboncillo y acrílico"
        ),
        Picture(
            name = "Naturaleza Desnuda",
            imagen = R.drawable.naturaleza_desnuda,
            dimensions = "25 x 30 cm",
            style = "Grafito"
        ),
        Picture(
            name = "Dibujo Oriental",
            imagen = R.drawable.dibujo_oriental,
            dimensions = "Información pendiente",
            style = "Información pendiente"
        ),
        Picture(
            name = "Dibujo Oriental",
            imagen = R.drawable.dibujo_oriental2,
            dimensions = "Información pendiente",
            style = "Información pendiente"
        ),
        Picture(
            name = "Cádiz desde el mar",
            imagen = R.drawable.cadiz_desde_el_mar,
            dimensions = "50 x 70 cm",
            style = "Tinta negra"
        ),
        Picture(
            name = "Casa Abandonada",
            imagen = R.drawable.casa_abandonada,
            dimensions = "25 x 25 cm",
            style = "Óleo"
        ),
        Picture(
            name = "Iglesia Mayor Prioral",
            imagen = R.drawable.iglesia_mayor_prioral,
            dimensions = "60 x 80 cm",
            style = "Óleo"
        )
    )

    var index by remember { mutableIntStateOf(0) }
    val actualPicture = pictures[index]

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp, vertical = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surfaceVariant,
                shadowElevation = 6.dp
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = actualPicture.imagen),
                        contentDescription = actualPicture.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(0.8f)
                            .clip(RoundedCornerShape(4.dp)),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp),
                color = MaterialTheme.colorScheme.surface,
                shadowElevation = 3.dp,
                border = androidx.compose.foundation.BorderStroke(
                    1.dp,
                    MaterialTheme.colorScheme.outlineVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = actualPicture.name,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "Dimension: ${actualPicture.dimensions}",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Text(
                        text = "Art Style: ${actualPicture.style}",
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        if (index > 0) {
                            index--
                        }
                    },
                    enabled = index > 0
                ) {
                    Text("Previous")
                }

                Text(
                    text = "${index + 1} / ${pictures.size}",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )

                Button(
                    onClick = {
                        if (index < pictures.lastIndex) {
                            index++
                        }
                    },
                    enabled = index < pictures.lastIndex
                ) {
                    Text("Next")
                }
            }
        }
    }
}
