package com.example.inputpengguna_prak5_234

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FormDataDiri(modifier: Modifier){
    //variabel2 utk mengingat nilai masukan dari keyboard
    var textNama by remember { mutableStateOf("") }
    var textAlamat by remember {mutableStateOf("")}
    var textJK by remember {mutableStateOf("")}

    //variabel2 utk menyimpan data yang diperoleh
    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }

    val gender:List<String> = listOf("Laki-laki","Perempuan")

    Column(modifier = Modifier.padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally) {
        OutlinedTextField(
            value = textNama,
            singleLine = true,
            shape = MaterialTheme.shapes.large,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Nama Lengkap") },
            onValueChange = {
                textNama = it
            }
        )
        Row {
            gender.forEach { item ->
                Row(modifier = Modifier.selectable(
                    selected = textJK == item,
                    onClick = { textJK = item }
                ), verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = textJK == item,
                        onClick = {
                            textJK = item
                        }
                    )
                    Text(text = item)
                }
            }
        }
        OutlinedTextField(
            value = textAlamat,
            singleLine = true,
            modifier = Modifier.width(width = 250.dp),
            label = { Text(text = "Alamat lengkap")},
            onValueChange = {
                textAlamat = it
            }
        )
        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )
        Button(
            modifier = Modifier.fillMaxWidth(1f),
            //the button is enabled when the user make a selection
            enabled = textAlamat.isNotEmpty(),
            onClick = {
                nama=textNama
                jenis=textJK
                alamat=textAlamat
            }
        ) {
            Text(stringResource((R.string.submit)))
        }

        HorizontalDivider(
            modifier = Modifier.padding(
                bottom = dimensionResource(R.dimen.padding_medium),
                top = dimensionResource(R.dimen.padding_medium)),
            thickness = dimensionResource(R.dimen.divider_tipis),
            color = Color.DarkGray
        )

        ElevatedCard (
            elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(containerColor = Color.Black),
            modifier = Modifier.height(100.dp).width(300.dp)
        ) {
            Column(
                modifier = Modifier.padding(horizontal = 5.dp, vertical = 15.dp),
            ) {
                Text(text = "Nama: "+nama, color = Color.White)
                Text(text = "Gender: "+jenis, color = Color.White)
                Text(text = "Alamat: "+alamat, color = Color.White)
            }
        }
    }
}


@Composable
fun FormDataDiriLengkap(modifier: Modifier) {
    var txtNama by remember { mutableStateOf("") }
    var txtAlamat by remember {mutableStateOf("")}
    var txtJK by remember {mutableStateOf("")}
    var txtStatusPernikahan by remember {mutableStateOf("")}

    var nama by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var jk by remember {mutableStateOf("")}
    var statusP by remember {mutableStateOf("")}

    val gender:List<String> = listOf("Laki-laki", "Perempuan")
    val status:List<String> = listOf("Janda", "Lajang", "Duda")

    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(color = colorResource(R.color.purple_200))
        ){
            Text(
                text = "Formulir Pendaftaran",
                color = Color.White,
                fontSize = 25.sp,
                )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)) {
            ElevatedCard(modifier = Modifier
                .fillMaxWidth()
                .padding(all = 20.dp)
                .background(color = Color.White))
            {
                Column(modifier = Modifier) {
                    Text(
                        text = "NAMA LENGKAP",
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    OutlinedTextField(
                        value = txtNama,
                        singleLine = true,
                        shape = MaterialTheme.shapes.large,
                        modifier = Modifier.width(width = 250.dp),
                        label = { Text(text = "Isian nama lengkap") },
                        onValueChange = {
                            txtNama = it
                        })
                    Text(
                        text = "JENIS KELAMIN",
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Column(modifier = Modifier) {
                        gender.forEach { item ->
                            Column(
                                modifier = Modifier.selectable(
                                    selected = txtJK == item,
                                    onClick = { txtJK = item }
                                ), horizontalAlignment = Alignment.CenterHorizontally) {
                                RadioButton(
                                    selected = txtJK == item,
                                    onClick = {
                                        txtJK = item
                                    }
                                )
                                Text(text = item)
                            }
                        }
                    }
                    Text(
                        text = "STATUS PERKAWINAN",
                        color = Color.Black,
                        fontSize = 10.sp
                    )
                    Column(modifier = Modifier) {
                        status.forEach { item ->
                            Column(
                                modifier = Modifier.selectable(
                                    selected = txtStatusPernikahan == item,
                                    onClick = { txtStatusPernikahan = item }
                                ), horizontalAlignment = Alignment.CenterHorizontally) {
                                RadioButton(
                                    selected = txtStatusPernikahan == item,
                                    onClick = {
                                        txtStatusPernikahan = item
                                    }
                                )
                                Text(text = item)
                            }
                        }
                    }

                }
            }
        }
    }
}